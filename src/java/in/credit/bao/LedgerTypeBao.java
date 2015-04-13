package in.credit.bao;

import in.credit.HbUtil;
import in.credit.model.LedgerType;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Team
 */
public class LedgerTypeBao {

    public static boolean add(LedgerTypeViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        try {
            session.save(new LedgerType(model.getLedgerTypeName()));
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("LedgerTypeBao::add " + e);
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean update(LedgerTypeViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<LedgerType> list = session.createCriteria(LedgerType.class)
                .add(Restrictions.eq("ledgerTypeId", model.getLedgerTypeId())).list();

        try {
            if (!list.isEmpty()) {
                LedgerType upd = list.get(0);
                upd.setLedgerTypeName(model.getLedgerTypeName());
                session.update(upd);
                session.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("LedgerTypeBao::update " + e);
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean delete(LedgerTypeViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<LedgerType> list = session.createCriteria(LedgerType.class)
                .add(Restrictions.eq("ledgerTypeId", model.getLedgerTypeId())).list();
        try {
            if (!list.isEmpty()) {
                LedgerType del = list.get(0);
                session.delete(del);
                session.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("LedgerTypeBao::delete " + e);
        } finally {
            session.close();
        }
        return false;
    }

    public static List<LedgerTypeViewModel> gets() {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<LedgerType> result = session.createCriteria(LedgerType.class).list();
        List<LedgerTypeViewModel> list = new ArrayList<>();
        for (LedgerType a : result) {
            list.add(new LedgerTypeViewModel(a.getLedgerTypeId(), a.getLedgerTypeName()));
        }
        session.close();
        return list;
    }

    public static LedgerTypeViewModel get(LedgerTypeViewModel model) {
        Session sess = HbUtil.openSession();
        sess.beginTransaction();
        List<LedgerType> list = sess.createCriteria(LedgerType.class)
                .add(Restrictions.eq("ledgerTypeId", model.getLedgerTypeId())).list();
        LedgerTypeViewModel result = new LedgerTypeViewModel();
        try {
            if (!list.isEmpty()) {
                LedgerType s = list.get(0);
                result = new LedgerTypeViewModel(s.getLedgerTypeId(), s.getLedgerTypeName());
            }

        } catch (Exception e) {
            System.out.println("LedgerTypeBao::get " + e);
        } finally {
            sess.close();
        }
        return result;
    }
}
