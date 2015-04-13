package in.credit.bao;

import in.credit.HbUtil;
import in.credit.U;
import in.credit.model.Account;
import in.credit.model.Ledger;
import in.credit.model.LedgerType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Team
 */
public class LedgerBao {

    public static boolean add(LedgerViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        try {
            List<Ledger> result = session.createCriteria(Ledger.class)
                    .add(Restrictions.eq("ledgerName", model.getLedgerName()))
                    .list();
            if (!result.isEmpty()) {
                return false;
            }

            Ledger ledger = new Ledger();
            ledger.setLedgerType(new LedgerType());
            ledger.getLedgerType().setLedgerTypeId(model.getLedgerTypeId());
            ledger.setCreated(model.getCreated());
            ledger.setAccount(new Account());
            ledger.getAccount().setAccountId(model.getAccountId());
            ledger.setCurrentAcYear(model.getCurrentAcYear());
            ledger.setIsClosed(model.isIsClosed());
            ledger.setIsDeleted(model.isIsDeleted());
            ledger.setLedgerName(model.getLedgerName());
            ledger.setUpdated(model.getUpdated());
            session.save(ledger);
            session.getTransaction().commit();
            
            model.setLedgerId(ledger.getLedgerId());
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("LedgerBao::add " + e);
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean update(LedgerViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<Ledger> list = session.createCriteria(Ledger.class).add(Restrictions.eq("ledgerId", model.getLedgerId())).list();
        try {
            if (!list.isEmpty()) {
                Ledger upd = list.get(0);
                upd.getAccount().setAccountId(model.getAccountId());
                upd.setCurrentAcYear(model.getCurrentAcYear());
                upd.setLedgerName(model.getLedgerName());
                upd.setIsClosed(model.isIsClosed());
                upd.setIsDeleted(model.isIsDeleted());
                upd.setUpdated(U.now());
                session.update(upd);
                session.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("LedgerBao::update " + e);
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean delete(LedgerViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<Ledger> list = session.createCriteria(Ledger.class)
                .add(Restrictions.eq("ledgerId", model.getLedgerId()))
                .list();
        try {
            if (!list.isEmpty()) {
                Ledger upd = list.get(0);
                
                session.delete(upd);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return false;
    }
    
    public static boolean deleteByAccountId(int userId) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<Ledger> list = session.createCriteria(Ledger.class)
                .add(Restrictions.eq("account.accountId", userId))
                .list();
        try {
            if (!list.isEmpty()) {
                Ledger upd = list.get(0);
                session.delete(upd);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
        } finally {
            session.close();
        }
        return false;
    }

    public static List<LedgerViewModel> getLedgersByAccountId(int accountId) {
        return gets().stream().filter(x->x.getAccountId() == accountId).collect(Collectors.toList());
    }
    public static List<LedgerViewModel> gets() {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<LedgerViewModel> list = new ArrayList<>();
        try {
            List<Ledger> result = session.createCriteria(Ledger.class).list();
            for (Ledger a : result) {
                list.add(new LedgerViewModel(a.getLedgerId(),
                        a.getLedgerType().getLedgerTypeId(),
                        a.getLedgerName(), a.getAccount().getAccountId(),
                        a.getCreated(), a.getUpdated(), a.getIsClosed(), a.getIsDeleted(),
                        a.getCurrentAcYear(),a.getLedgerType().getLedgerTypeName()));
            }
        } finally {
            session.close();
        }
        return list;
    }

    public static LedgerViewModel get(LedgerViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        LedgerViewModel result = new LedgerViewModel();
        List<Ledger> list = session.createCriteria(Ledger.class)
                .add(Restrictions.eq("ledgerId", model.getLedgerId()))
                .list();
        try {
            if (!list.isEmpty()) {
                Ledger a = list.get(0);
                result = new LedgerViewModel(a.getLedgerId(),
                        a.getLedgerType().getLedgerTypeId(),
                        a.getLedgerName(), a.getAccount().getAccountId(),
                        a.getCreated(), a.getUpdated(), a.getIsClosed(), a.getIsDeleted(),
                        a.getCurrentAcYear(),a.getLedgerType().getLedgerTypeName());
            }

        } catch (Exception e) {
            System.out.println("LedgerBao::get " + e);
        } finally {
            session.close();
        }
        return result;
    }
}
