package in.credit.bao;

import in.credit.HbUtil;
import in.credit.model.Journal;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Team
 */
public class JournalBao {

    public static boolean add(Journal journal) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        try {
            session.save(journal);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("JournalBao::add " + e);
        }finally {
            session.close();
        }
        return false;
    }

    public static boolean update(Journal journal) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<Journal> list = session.createCriteria(Journal.class).add(Restrictions.eq("docId", journal.getDocId())).list();
        try {
            if (!list.isEmpty()) {
                Journal upd = list.get(0);
                upd.setAmount(journal.getAmount());
                upd.setDocDate(journal.getDocDate());
                upd.setDocId(journal.getDocId());
                upd.setIsDeleted(journal.getIsDeleted());
                upd.setParticular(journal.getParticular());
                upd.setLedgerByCrLedgerId(journal.getLedgerByCrLedgerId());
                upd.setLedgerByDrLedgerId(journal.getLedgerByDrLedgerId());
                session.update(upd);
                session.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("JournalBao::update " + e);
        }finally {
            session.close();
        }
        return false;
    }

    public static boolean delete(Journal journal) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<Journal> list = session.createCriteria(Journal.class).add(Restrictions.eq("docId", journal.getDocId())).list();
        try {
            if (!list.isEmpty()) {
                Journal del = list.get(0);
                session.delete(del);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("JornalBao::delete " + e);
        }finally {
            session.close();
        }
        return false;
    }

    public static List<Journal> gets() {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        try{
        return session.createCriteria(Journal.class).list();
        }finally {
            session.close();
        }
    }

    public static Journal get(Journal journal) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<Journal> list=session.createCriteria(Journal.class).add(Restrictions.eq("docId", journal.getDocId())).list();
        
        try {
            if (!list.isEmpty()) {
                Journal search = list.get(0);
                return search;
            }

        } catch (Exception e) { 
            System.out.println("DepositBao::get " + e);
        }finally {
            session.close();
        }
        return null;
    }
    public static List<Journal> getJournal(Date date){
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<Journal> list=session.createCriteria(Journal.class).add(Restrictions.like("docDate", date)).list();
        session.close();
        return list;
    }
    public static List<Journal> getJournalBetween(Date from,Date to){
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<Journal> list=session.createCriteria(Journal.class).add(Restrictions.between("docDate", from, to)).list();
        session.close();
        return list;
    }
    public static List<Journal>  getJournal(int ledgerId){
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<Journal> list=session.createCriteria(Journal.class)
                .add(Restrictions.or(Restrictions
                        .eq("ledgerByCrLedgerId.ledgerId", ledgerId)
                        ,Restrictions.eq("ledgerByDrLedgerId.ledgerId", ledgerId)))
                .list();
        session.close();
        return list;
    }
}
