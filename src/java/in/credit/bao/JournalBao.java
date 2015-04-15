package in.credit.bao;

import in.credit.HbUtil;
import in.credit.model.Journal;
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
public class JournalBao {

    public static boolean add(JournalViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        try {
            Journal j = new Journal();
            j.setAmount(BigDecimal.valueOf(model.getAmount()));
            j.setDocDate(model.getDocDate());
            j.setIsDeleted(model.isIsDeleted());
            j.setLedgerByCrLedgerId(new Ledger());
            j.getLedgerByCrLedgerId().setLedgerId(model.getLedgerByCrLedgerId());
            j.setLedgerByDrLedgerId(new Ledger());
            j.getLedgerByDrLedgerId().setLedgerId(model.getLedgerByDrLedgerId());
            j.setParticular(model.getParticular());
            session.save(j);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("JournalBao::add " + e);
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean update(JournalViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<Journal> list = session.createCriteria(Journal.class)
                .add(Restrictions.eq("docId", model.getDocId())).list();
        try {
            if (!list.isEmpty()) {
                Journal upd = list.get(0);
                upd.setAmount(BigDecimal.valueOf(model.getAmount()));
                upd.setDocDate(model.getDocDate());

                upd.setIsDeleted(model.isIsDeleted());
                upd.setParticular(model.getParticular());
                upd.getLedgerByCrLedgerId().setLedgerId(model.getLedgerByCrLedgerId());
                upd.getLedgerByDrLedgerId().setLedgerId(model.getLedgerByDrLedgerId());
                session.update(upd);
                session.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("JournalBao::update " + e);
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean delete(JournalViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<Journal> list = session.createCriteria(Journal.class)
                .add(Restrictions.eq("docId", model.getDocId())).list();
        try {
            if (!list.isEmpty()) {
                Journal del = list.get(0);
                session.delete(del);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("JornalBao::delete " + e);
        } finally {
            session.close();
        }
        return false;
    }

    public static List<JournalViewModel> gets() {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<JournalViewModel> list = new ArrayList<>();
        try {
            List<Journal> result = session.createCriteria(Journal.class).list();
            for (Journal a : result) {
                JournalViewModel j = new JournalViewModel(a.getDocId(), a.getLedgerByCrLedgerId().getLedgerId(), a.getLedgerByCrLedgerId().getLedgerName(), a.getLedgerByDrLedgerId().getLedgerId(), a.getLedgerByDrLedgerId().getLedgerName(), a.getDocDate(), a.getAmount().doubleValue(), a.getParticular(), a.getIsDeleted());
                list.add(j);
            }
        } finally {
            session.close();
        }
        return list;
    }

    public static JournalViewModel get(JournalViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<Journal> list = session.createCriteria(Journal.class).
                add(Restrictions.eq("docId", model.getDocId())).list();
        JournalViewModel j = new JournalViewModel();
        try {
            if (!list.isEmpty()) {
                Journal a = list.get(0);
                j = new JournalViewModel(a.getDocId(), a.getLedgerByCrLedgerId().getLedgerId(), a.getLedgerByCrLedgerId().getLedgerName(), a.getLedgerByDrLedgerId().getLedgerId(), a.getLedgerByDrLedgerId().getLedgerName(), a.getDocDate(), a.getAmount().doubleValue(), a.getParticular(), a.getIsDeleted());
            }
        } catch (Exception e) {
            System.out.println("DepositBao::get " + e);
        } finally {
            session.close();
        }
        return j;
    }

    public static List<JournalViewModel> gets(Date date) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<Journal> result = session.createCriteria(Journal.class).add(Restrictions.like("docDate", date)).list();

        List<JournalViewModel> list = new ArrayList<>();
        for (Journal a : result) {
            JournalViewModel j = new JournalViewModel(a.getDocId(), a.getLedgerByCrLedgerId().getLedgerId(), a.getLedgerByCrLedgerId().getLedgerName(), a.getLedgerByDrLedgerId().getLedgerId(), a.getLedgerByDrLedgerId().getLedgerName(), a.getDocDate(), a.getAmount().doubleValue(), a.getParticular(), a.getIsDeleted());
            list.add(j);
        }
        session.close();
        return list;
    }

    public static List<JournalViewModel> gets(Date from, Date to) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<Journal> result = session.createCriteria(Journal.class)
                .add(Restrictions.between("docDate", from, to)).list();
        List<JournalViewModel> list = new ArrayList<>();
        for (Journal a : result) {
            JournalViewModel j = new JournalViewModel(a.getDocId(), a.getLedgerByCrLedgerId().getLedgerId(), a.getLedgerByCrLedgerId().getLedgerName(), a.getLedgerByDrLedgerId().getLedgerId(), a.getLedgerByDrLedgerId().getLedgerName(), a.getDocDate(), a.getAmount().doubleValue(), a.getParticular(), a.getIsDeleted());
            list.add(j);
        }
        session.close();
        return list;
    }

    public static List<JournalViewModel> gets(int ledgerId) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<Journal> result = session.createCriteria(Journal.class)
                .add(Restrictions.or(
                                Restrictions.eq("ledgerByCrLedgerId.ledgerId", ledgerId),
                                Restrictions.eq("ledgerByDrLedgerId.ledgerId", ledgerId)))
                .list();
        List<JournalViewModel> list = new ArrayList<>();
        for (Journal a : result) {
            JournalViewModel j = new JournalViewModel(a.getDocId(), a.getLedgerByCrLedgerId().getLedgerId(), a.getLedgerByCrLedgerId().getLedgerName(), a.getLedgerByDrLedgerId().getLedgerId(), a.getLedgerByDrLedgerId().getLedgerName(), a.getDocDate(), a.getAmount().doubleValue(), a.getParticular(), a.getIsDeleted());
            list.add(j);
        }
        session.close();
        return list;
    }
}
