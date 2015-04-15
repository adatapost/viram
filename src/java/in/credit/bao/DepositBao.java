package in.credit.bao;

import in.credit.HbUtil;
import in.credit.model.Deposit;
import in.credit.model.Ledger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Team
 */
public class DepositBao {

    public static boolean add(DepositViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();

        try {
            Deposit d=new Deposit();
            d.setAmount(BigDecimal.valueOf(model.getAmount()));
            d.setCreated(model.getCreated());
            d.setInterestRate(BigDecimal.valueOf(model.getInterestRate()));
            d.setLedger(new Ledger());
            d.getLedger().setLedgerId(model.getLedgerId());
            d.setMaturityDate(model.getMaturityDate());
            d.setStartDate(model.getStartDate());
            d.setTerm(model.getTerm());
            session.save(d);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("DepositBao::add " + e);
        }finally {
            session.close();
        }
        return false;
    }

    public static boolean update(DepositViewModel model) {
        Session sess = HbUtil.openSession();
        sess.beginTransaction();
        List<Deposit> list = sess.createCriteria(Deposit.class)
                .add(Restrictions.eq("ledgerId", model.getLedgerId()))
                .list();

        try {
            if (!list.isEmpty()) {
                Deposit upd = list.get(0);
                upd.setAmount(BigDecimal.valueOf(model.getAmount()));
                upd.setInterestRate(BigDecimal.valueOf(model.getInterestRate()));
                
                upd.setMaturityDate(model.getMaturityDate());
                upd.setStartDate(model.getStartDate());
                upd.setTerm(model.getTerm());
                sess.update(upd);
                sess.getTransaction().commit();
                return true;
            }

        } catch (Exception e) {
            sess.getTransaction().rollback();
            System.out.println("DepositBao::update " + e);
        }finally {
            sess.close();
        }
        return false;
    }

    public static boolean delete(DepositViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<Deposit> list = session.createCriteria(Deposit.class)
                .add(Restrictions.eq("ledgerId", model.getLedgerId())).list();

        try {
            if (!list.isEmpty()) {
                Deposit del = list.get(0);
                session.delete(del);
                session.getTransaction().commit();
                return true;
            }

        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("DepositBao::delete " + e);
        }finally {
            session.close();
        }
        return false;
    }

    public static List<DepositViewModel> gets() {
        Session sess = HbUtil.openSession();
        List<DepositViewModel> list=new ArrayList<>();
        sess.beginTransaction();
        List<Deposit> result = sess.createCriteria(Deposit.class).list();
        for(Deposit a: result) {
            DepositViewModel d=new DepositViewModel( a.getLedger().getLedgerId(), a.getLedger().getLedgerName(), a.getLedger().getAccount().getAccountId(), a.getStartDate(), a.getMaturityDate(), a.getAmount().doubleValue(), a.getInterestRate().doubleValue(),a.getCreated(), a.getTerm());
            list.add(d);
        }
        sess.close();
        return list;
    }
    
    
    public static DepositViewModel get(DepositViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<Deposit> list = session.createCriteria(Deposit.class)
                .add(Restrictions.eq("ledgerId", model.getLedgerId())).list();
        DepositViewModel d=new DepositViewModel();
        try {
            if (!list.isEmpty()) {
                Deposit a = list.get(0);
                 d=new DepositViewModel( a.getLedger().getLedgerId(), a.getLedger().getLedgerName(), a.getLedger().getAccount().getAccountId(), a.getStartDate(), a.getMaturityDate(), a.getAmount().doubleValue(), a.getInterestRate().doubleValue(),a.getCreated(), a.getTerm());
            }

        } catch (Exception e) {
            System.out.println("DepositBao::get " + e);
        }finally {
            session.close();
        }
        return d;
    }
}
