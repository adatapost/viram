package in.credit.bao;

import in.credit.HbUtil;
import in.credit.model.Ledger;
import in.credit.model.Recurring;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Team
 */
public class RecurringBao {

    public static boolean add(RecurringViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        try {
            Recurring r=new Recurring();
            r.setAmount(BigDecimal.valueOf(model.getAmount()));
            r.setCreated(model.getCreated());
            r.setEndDate(model.getEndDate());
            r.setFrequency(model.getFrequency());
            r.setInterestRate(BigDecimal.valueOf(model.getInterestRate()));
            r.setLedger(new Ledger());
            r.getLedger().setLedgerId(model.getLedgerId());
            r.setStartDate(model.getStartDate());
            r.setTerm(model.getTerm());
            session.save(r);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("RecurringBao::add " + e);
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean update(RecurringViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<Recurring> list = session.createCriteria(Recurring.class)
                .add(Restrictions.eq("ledgerId", model.getLedgerId())).list();
        try {
            if (!list.isEmpty()) {
                Recurring upd = list.get(0);
                
                upd.setStartDate(model.getStartDate());
                upd.setFrequency(model.getFrequency());
                upd.setTerm(model.getFrequency());
                upd.setEndDate(model.getEndDate());
                upd.setAmount(BigDecimal.valueOf(model.getAmount()));
                upd.setInterestRate(BigDecimal.valueOf(model.getInterestRate()));
                upd.setCreated(model.getCreated());
                session.update(upd);
                session.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("RecurringBao::update " + e);
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean delete(RecurringViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<Recurring> list = session.createCriteria(Recurring.class)
                .add(Restrictions.eq("ledgerId", model.getLedgerId()))
                .list();
        try {
            if (!list.isEmpty()) {
                Recurring del = list.get(0);
                session.delete(del);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("RecurringBao::delete " + e);
        } finally {
            session.close();
        }
        return false;
    }

    public static List<RecurringViewModel> gets() {
        Session session = HbUtil.openSession();
        List<RecurringViewModel> list=new ArrayList<>();
        session.beginTransaction();
        try {
            List<Recurring> result= session.createCriteria(Recurring.class).list();
            for(Recurring a : result ){
                RecurringViewModel r=new  RecurringViewModel(a.getLedger().getLedgerId(), a.getLedger().getLedgerName(), a.getLedger().getAccount().getAccountId(), a.getStartDate(),a.getFrequency(),a.getTerm(), a.getEndDate(),a.getAmount().doubleValue(), a.getInterestRate().doubleValue(),a.getCreated());
                list.add(r);
            }
        } finally {
            session.close();
        }
        return list;
    }

    public static RecurringViewModel get(RecurringViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        RecurringViewModel r=new RecurringViewModel();
        List<Recurring> list = session.createCriteria(Recurring.class)
                .add(Restrictions.eq("ledgerId", model.getLedgerId())).list();
        try {
            if (!list.isEmpty()) {
                Recurring a = list.get(0);
                r=new  RecurringViewModel(a.getLedger().getLedgerId(), a.getLedger().getLedgerName(), a.getLedger().getAccount().getAccountId(), a.getStartDate(),a.getFrequency(),a.getTerm(), a.getEndDate(),a.getAmount().doubleValue(), a.getInterestRate().doubleValue(),a.getCreated());
            }
        } catch (Exception e) {
            System.out.println("RecurringBao::get " + e);
        } finally {
            session.close();
        }
        return r;
    }
}
