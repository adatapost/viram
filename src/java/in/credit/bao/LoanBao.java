/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.credit.bao;

import in.credit.HbUtil;
import in.credit.U;
import in.credit.model.Ledger;
import in.credit.model.Loan;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Viram
 */
public class LoanBao {

    public static boolean add(LoanViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        try {
            Loan loan=new Loan();
            loan.setAmount(BigDecimal.valueOf(model.getAmount()));
            loan.setCreated(U.now());
            loan.setEndDate(model.getEndDate());
            loan.setInstallment(model.getInstallment());
            loan.setInterestRate(BigDecimal.valueOf(model.getInterestRate()));
            loan.setLedger(new Ledger());
            loan.getLedger().setLedgerId(model.getLedgerId());
            loan.setStartDate(model.getStartDate());
            session.save(loan);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("LoanBao::add " + e);
        } finally {
            session.close();
        }
        return false;
    }

    public static boolean update(LoanViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<Loan> list = session.createCriteria(Loan.class)
                .add(Restrictions.eq("ledgerId", model.getLedgerId())).list();
        try {
            if (!list.isEmpty()) {
                Loan upd = list.get(0);
                
                upd.setStartDate(model.getStartDate());
                upd.setEndDate(model.getEndDate());
                
                upd.setInstallment(model.getInstallment());
                upd.setInterestRate(BigDecimal.valueOf(model.getInterestRate()));
                upd.setAmount(BigDecimal.valueOf(model.getAmount()));
                session.update(upd);
                session.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("LoanBao::update " + e);
        } finally{
            session.close();
        }
        return false;
    }

    public static boolean delete(LoanViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<Loan> list = session.createCriteria(Loan.class)
                .add(Restrictions.eq("ledgerId", model.getLedgerId())).list();
        try {
            if (!list.isEmpty()) {
                Loan del = list.get(0);
                session.delete(del);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("LoanBao::delete " + e);
        } finally{
            session.close();
        }
        return false;
    }

    public static List<LoanViewModel> gets() {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<LoanViewModel> list=new ArrayList<>();
        List<Loan> result =session.createCriteria(Loan.class).list();
        for(Loan a: result) {
            list.add(new LoanViewModel(a.getLedgerId(), a.getLedger().getLedgerName(), a.getStartDate(), a.getEndDate(), a.getAmount().doubleValue(), a.getInterestRate().doubleValue(), a.getInstallment()));
        }
        
        session.close();
        return list;
    }

    public static LoanViewModel get(Loan loan) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        LoanViewModel b=new LoanViewModel();
        List<Loan> list = session.createCriteria(Loan.class).add(Restrictions.eq("ledgerId", loan.getLedgerId())).list();
        try {
            if (!list.isEmpty()) {
                Loan a = list.get(0);
                b= new LoanViewModel(a.getLedgerId(), a.getLedger().getLedgerName(), a.getStartDate(), a.getEndDate(), a.getAmount().doubleValue(), a.getInterestRate().doubleValue(), a.getInstallment());
            }

        } catch (Exception e) {
            System.out.println("LoanBao::get " + e);
        }
        return b;
    }

    public static boolean changeIntrRate(int ledgerId, BigDecimal newInterestRate) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<Loan> list = session.createCriteria(Loan.class).add(Restrictions.eq("ledgerId", ledgerId)).list();
        if (!list.isEmpty()) {
            Loan upd = list.get(0);
            upd.setInterestRate(newInterestRate);
            session.update(upd);
            session.getTransaction().commit();
            return true;
        }
        return false;
    }
}
