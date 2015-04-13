package in.credit.bao;

import in.credit.HbUtil;
import in.credit.model.AccountType;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Team
 */
public class AccountTypeBao {

    public static boolean add(AccountTypeViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        try {
            session.save(new AccountType(model.getTypeName()));
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("AccountTypeBao::add " + e);
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean update(AccountTypeViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<AccountType> list = session.createCriteria(AccountType.class).add(Restrictions.eq("typeId", model.getTypeId())).list();

        try {
            if (!list.isEmpty()) {
                AccountType upd = list.get(0);
                upd.setTypeName(model.getTypeName());
                session.update(upd);
                session.getTransaction().commit();
                return true;
            }

        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("AccountTypeBao::update " + e);
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean delete(AccountTypeViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<AccountType> list = session.createCriteria(AccountType.class)
                .add(Restrictions.eq("typeId", model.getTypeId())).list();
        try {
            if (!list.isEmpty()) {
                AccountType del = list.get(0);
                session.delete(del);
                session.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("AccountTypeBao::delete " + e);
        } finally {
            session.close();
        }
        return false;
    }

    public static List<AccountTypeViewModel> gets() {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<AccountType> result = session.createCriteria(AccountType.class).list();
        List<AccountTypeViewModel> list = new ArrayList<>();
        for (AccountType a : result) {
            list.add(new AccountTypeViewModel(a.getTypeId(), a.getTypeName()));
        }
        session.close();
        return list;
    }

    public static AccountTypeViewModel get(AccountTypeViewModel type) {
        Session sess = HbUtil.openSession();
        sess.beginTransaction();
        List<AccountType> list = sess.createCriteria(AccountType.class).add(Restrictions.eq("typeId", type.getTypeId())).list();
        AccountTypeViewModel model = new AccountTypeViewModel();
        try {
            if (!list.isEmpty()) {
                AccountType a = list.get(0);
                model = new AccountTypeViewModel(a.getTypeId(), a.getTypeName());
            }
        } catch (Exception e) {
            System.out.println("AccountTypeBao::get " + e);
        } finally {
            sess.close();
        }
        return model;
    }
}
