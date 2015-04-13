package in.credit.bao;

import in.credit.HbUtil;
import in.credit.U;
import in.credit.model.Account;
import in.credit.model.AccountType;
import in.credit.model.City;
import in.credit.model.Nominee;
import in.credit.model.UserAccount;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class AccountBao {

    public static boolean add(AccountViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        try {
            Account account = new Account();
            
            account.setAccountType(new AccountType());
            account.getAccountType().setTypeId(model.getTypeId());
            account.setAddress(model.getAddress());
            account.setBirthDate(model.getBirthDate());
            account.setCity(new City());
            account.getCity().setCityId(model.getCityId());
            account.setCreated(model.getCreated());
            account.setCustImg(model.getCustImg());
            account.setFirstName(model.getFirstName());
            account.setGender(model.getGender());
            account.setIsDeleted(model.getIsDeleted());
            account.setLastName(model.getLastName());
            account.setMiddleName(model.getMiddleName());
            account.setPhone(model.getPhone());
            account.setUpdated(model.getUpdated());
            account.setUserAccountByReferenceId(new UserAccount());
            account.getUserAccountByReferenceId().setUserId(model.getReferenceUserId());
            account.setUserAccountByCreatedBy(new UserAccount());
            account.getUserAccountByCreatedBy().setUserId(model.getCreatedByUserId());
            account.setUserAccountByUserId(new UserAccount());
            account.getUserAccountByUserId().setUserId(model.getUserId());
            session.save(account);
            session.getTransaction().commit();
             
            session.beginTransaction();
            Nominee n = new Nominee();
            n.setAccount(new Account());
            n.getAccount().setAccountId(model.getUserId());
            n.setBirthDate(model.getNoBirthDate());
            n.setFirstName(model.getNoFirstName());
            n.setGender(model.getNoGender());
            n.setLastName(model.getNoLastName());
            n.setMiddleName(model.getNoMiddleName());
            
            session.save(n);
            session.getTransaction().commit();
            
            System.out.println("Account added");
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("AccountBao::add " + e);
        } finally {
            session.close();
        }

        return false;
    }

    public static boolean update(AccountViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<Account> list = session.createCriteria(Account.class)
                .add(Restrictions.eq("accountId", model.getUserId())).list();
        try {
            if (!list.isEmpty()) {
                Account upd = list.get(0);
                upd.getAccountType().setTypeId(model.getTypeId());
                upd.setAddress(model.getAddress());
                upd.setBirthDate(model.getBirthDate());
                upd.getCity().setCityId(model.getCityId());
                upd.setFirstName(model.getFirstName());
                upd.setGender(model.getGender());
                upd.setLastName(model.getLastName());
                upd.setMiddleName(model.getMiddleName());
                upd.setPhone(model.getPhone());
                upd.setUpdated(U.now());
                upd.getUserAccountByReferenceId().setUserId(model.getReferenceUserId());
                upd.setIsDeleted(model.getIsDeleted());

                session.update(upd);
                session.getTransaction().commit();
                return true;
            }

        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("AccountBao::update " + e);
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean delete(AccountViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<Account> list = session.createCriteria(Account.class)
                .add(Restrictions.eq("accountId", model.getUserId()))
                .list();

        try {
            if (!list.isEmpty()) {
                Account upd = list.get(0);
                session.delete(upd);
                session.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return false;
    }

    public static AccountViewModel get(AccountViewModel model) {
        Session session = HbUtil.getSession();
        session.beginTransaction();
        List<Account> list = session.createCriteria(Account.class)
                .add(Restrictions.eq("accountId",
                                model.getUserId())).list();
        AccountViewModel result = new AccountViewModel();
        try {
            if (!list.isEmpty()) {
                Account a = list.get(0);
                Nominee n = a.getNominees().stream().findFirst().get();
                result = new AccountViewModel(a.getAccountId(), a.getUserAccountByUserId().getRole().getRoleId(), a.getUserAccountByUserId().getUserEmail(),
                        a.getUserAccountByUserId().getUserPass(),
                        a.getAccountType().getTypeId(),
                        a.getCity().getState().getStateId(),
                        a.getCity().getCityId(),
                        a.getFirstName(), a.getMiddleName(),
                        a.getLastName(), a.getGender(), a.getAddress(),
                        a.getPhone(), a.getBirthDate(), a.getIsDeleted(),
                        a.getCreated(), a.getUpdated(), a.getCustImg(),
                        a.getUserAccountByReferenceId().getUserId(),
                        a.getUserAccountByCreatedBy().getUserId(), n.getFirstName(),
                        n.getMiddleName(), n.getLastName(), n.getGender(),
                        n.getBirthDate());

                result.setTypeName(a.getAccountType().getTypeName());
                result.setCityName(a.getCity().getCityName());
                result.setStateName(a.getCity().getState().getStateName());
                result.setRoleName(a.getUserAccountByUserId().getRole().getRoleName());
                
                 
            }

        } catch (Exception e) {
            System.out.println("AccountBao::get " + e);
        } finally {
            session.close();
        }
        return result;
    }

    public static List<AccountViewModel> gets() {
        Session session = HbUtil.openSession();
        List<AccountViewModel> list = new ArrayList<>();
        session.beginTransaction();

        try {
            List<Account> result = session.createCriteria(Account.class).list();
            for (Account a : result) {
                Nominee n = a.getNominees().stream().findFirst().get();

                AccountViewModel p = new AccountViewModel(a.getAccountId(), a.getUserAccountByUserId().getRole().getRoleId(), a.getUserAccountByUserId().getUserEmail(),
                        a.getUserAccountByUserId().getUserPass(),
                        a.getAccountType().getTypeId(),
                        a.getCity().getState().getStateId(),
                        a.getCity().getCityId(),
                        a.getFirstName(), a.getMiddleName(),
                        a.getLastName(), a.getGender(), a.getAddress(),
                        a.getPhone(), a.getBirthDate(), a.getIsDeleted(),
                        a.getCreated(), a.getUpdated(), a.getCustImg(),
                        a.getUserAccountByReferenceId().getUserId(),
                        a.getUserAccountByCreatedBy().getUserId(), n.getFirstName(),
                        n.getMiddleName(), n.getLastName(), n.getGender(),
                        n.getBirthDate());
                p.setTypeName(a.getAccountType().getTypeName());
                p.setCityName(a.getCity().getCityName());
                p.setStateName(a.getCity().getState().getStateName());
                p.setRoleName(a.getUserAccountByUserId().getRole().getRoleName());
                list.add(p);
            }
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return list;

    }

    public static AccountViewModel getAccount(int accountId) {
        return get(new AccountViewModel(accountId));
    }

    //getAccount list by Account Type
    public static List<AccountViewModel> getAccountsByAccType(int typeId) {
        return gets().stream().filter((x) -> x.getTypeId() == typeId).collect(Collectors.toList());
    }

    public static boolean changePhone(int accountId, String newPhone) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<Account> list = session.createCriteria(Account.class).add(Restrictions.eq("accountId", accountId)).list();

        try {
            if (!list.isEmpty()) {
                Account upd = list.get(0);
                upd.setPhone(newPhone);
                session.update(upd);
                session.getTransaction().commit();

                return true;
            }
        } catch (Exception e) {
        } finally {
            session.close();
        }

        return false;
    }

    public static boolean setCustImg(int accountId, String custImg) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<Account> list = session.createCriteria(Account.class).add(Restrictions.eq("accountId", accountId)).list();
        try {
            if (!list.isEmpty()) {
                Account upd = list.get(0);
                upd.setCustImg(custImg);
                session.update(upd);
                session.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
        } finally {
            session.close();
        }

        return false;
    }

}
