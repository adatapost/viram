package in.credit.bao;

import in.credit.HbUtil;
import in.credit.U;
import in.credit.model.Role;
import in.credit.model.UserAccount;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Team
 */
public class UserAccountBao {

    public static boolean add(UserAccountViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<UserAccount> list = session.createCriteria(UserAccount.class)
                .add(Restrictions.eq("userEmail", model.getUserEmail()))
                .list();
        if (!list.isEmpty()) {
            return false;
        }
        UserAccount userAccount = new UserAccount();
        userAccount.setCreated(model.getCreated());
        userAccount.setIsActivate(model.isIsActivate());
        userAccount.setIsDeleted(model.isIsDeleted());
        userAccount.setRole(new Role());
        userAccount.getRole().setRoleId(model.getRoleId());
        userAccount.setUserEmail(model.getUserEmail());
        userAccount.setUserPass(U.hashPassword(model.getUserPass()));
        try {
            session.save(userAccount);
            session.getTransaction().commit();
            model.setUserId(userAccount.getUserId());
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("UserAccountBao::add " + e);
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean updateLastLogin(UserAccountViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<UserAccount> list = session.createCriteria(UserAccount.class)
                .add(Restrictions.eq("userId", model.getUserId())).list();
        try {
            if (!list.isEmpty()) {
                UserAccount upd = list.get(0);
                upd.setLastLogin(U.now());
                session.update(upd);
                session.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("UserAccountBao::lastLogin " + e);
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean update(UserAccountViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<UserAccount> list = session.createCriteria(UserAccount.class)
                .add(Restrictions.eq("userId", model.getUserId())).list();
        try {
            if (!list.isEmpty()) {
                UserAccount upd = list.get(0);

                upd.getRole().setRoleId(model.getRoleId());
                upd.setUserEmail(model.getUserEmail());
                upd.setUserPass(U.hashPassword(model.getUserPass()));
                upd.setCreated(model.getCreated());
                upd.setIsDeleted(model.isIsDeleted());
                upd.setIsActivate(model.isIsActivate());
                upd.setLastLogin(model.getLastLogin());
                upd.setUpdated(model.getUpdated());
                session.update(upd);
                session.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("UserAccountBao::update " + e);
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean delete(UserAccountViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<UserAccount> list = session.createCriteria(UserAccount.class)
                .add(Restrictions.eq("userId", model.getUserId())).list();
        try {
            if (!list.isEmpty()) {
                UserAccount upd = list.get(0);
                session.delete(upd);
                session.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("UserAccountBao::delete " + e);
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean delete(int userId) {

        return delete(new UserAccountViewModel(userId));
    }

    public static List<UserAccountViewModel> gets() {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<UserAccountViewModel> list = new ArrayList<>();
        try {
            List<UserAccount> result = session.createCriteria(UserAccount.class).list();
            for (UserAccount a : result) {
                UserAccountViewModel m = new UserAccountViewModel(a.getUserId(), a.getRole().getRoleId(), a.getRole().getRoleName(), a.getUserEmail(), a.getUserPass(), a.getCreated(), a.getUpdated(), a.getIsDeleted(), a.getIsActivate(), a.getLastLogin());
                list.add(m);
            }
        } finally {
            session.close();
        }
        return list;
    }

    public static UserAccountViewModel get(UserAccountViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();

        List<UserAccount> list = session.createCriteria(UserAccount.class)
                .add(Restrictions.or(
                                Restrictions.eq("userEmail", model.getUserEmail()),
                                Restrictions.eq("userId", model.getUserId())
                        ))
                .list();
        try {
            if (!list.isEmpty()) {
                UserAccount a = list.get(0);
                UserAccountViewModel m = new UserAccountViewModel(a.getUserId(), a.getRole().getRoleId(), a.getRole().getRoleName(), a.getUserEmail(), a.getUserPass(), a.getCreated(), a.getUpdated(), a.getIsDeleted(), a.getIsActivate(), a.getLastLogin());
                return m;
            }

        } catch (Exception e) {
            System.out.println("UserAccountBao::get " + e);
        } finally {
            session.close();
        }
        return null;
    }

    /**
     *
     * @param roleName
     * @return List of User Account as specified Role Name
     */
    public static List<UserAccountViewModel> gets(int roleId) {
         return gets().stream().filter(x->x.getRoleId()==roleId).collect(Collectors.toList());
    }

    /**
     *
     * @param from
     * @param to
     * @return List of all User Accounts Created between 'from' and 'to' date
     */
    public static List<UserAccountViewModel> getUAccountsBetween(Date from, Date to) {
        return gets().stream().filter(
                x->x.getCreated().after(from) && x.getCreated().before(to))
                .collect(Collectors.toList());
    }

    public static boolean changePass(int userId, String newPass, String oldPass) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<UserAccount> list = session.createCriteria(UserAccount.class).add(Restrictions.and(Restrictions.eq("userId", userId), Restrictions.like("userPass", oldPass)))
                .list();
        try {
            if (!list.isEmpty()) {
                UserAccount upd = list.get(0);
                upd.setUserPass(newPass);
                session.update(upd);
                session.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            System.out.println("UserAccountBao::changePass " + e);
        } finally {
            session.close();
        }
        return false;
    }
}
