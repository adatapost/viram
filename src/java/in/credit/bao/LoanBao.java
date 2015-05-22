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
import in.credit.model.LoanInstallment;
import java.math.BigDecimal;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
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
            Loan loan = new Loan();
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

                /* Remove Installments */
                session.createSQLQuery("delete from loan_installment where ledger_id=" + model.getLedgerId())
                        .executeUpdate();

                /* Adding loan installments */
                java.util.Date startDate = model.getStartDate();
                java.util.Calendar cal = java.util.Calendar.getInstance();
                cal.setTime(startDate);
                double amount = model.getAmount(),
                        installment = model.getInstallment();

                int noInst = new Double(amount / installment).intValue();
                System.out.println(noInst);
                for (int i = 1; i <= noInst; i++) {

                    cal.add(java.util.Calendar.MONTH, 1);
                    java.util.Date dt = cal.getTime();
                    System.out.println(i + " " + dt);
                    LoanInstallment inst = new LoanInstallment();
                    inst.setLedger(new Ledger());
                    inst.getLedger().setLedgerId(model.getLedgerId());
                    inst.setInstAmount(model.getInstallment());
                    inst.setInstDate(dt);
                    session.save(inst);
                }
                /* End installments */

                session.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("LoanBao::update " + e);

        } finally {
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
        } finally {
            session.close();
        }
        return false;
    }

    public static List<LoanViewModel> gets() {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<LoanViewModel> list = new ArrayList<>();
        List<Loan> result = session.createCriteria(Loan.class).list();
        for (Loan a : result) {
            list.add(new LoanViewModel(a.getLedgerId(), a.getLedger().getLedgerName(), a.getStartDate(), a.getEndDate(), a.getAmount().doubleValue(), a.getInterestRate().doubleValue(), a.getInstallment()));
        }

        session.close();
        return list;
    }

    public static LoanViewModel get(LoanViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        LoanViewModel b = new LoanViewModel();
        List<Loan> list = session.createCriteria(Loan.class)
                .add(Restrictions.eq("ledgerId", model.getLedgerId())).list();
        try {
            if (!list.isEmpty()) {
                Loan a = list.get(0);
                b = new LoanViewModel(a.getLedgerId(), a.getLedger().getLedgerName(), a.getStartDate(), a.getEndDate(), a.getAmount().doubleValue(), a.getInterestRate().doubleValue(), a.getInstallment());
                for(LoanInstallment inst : a.getLedger().getLoanInstallments()) {
                    LoanInstallmentViewModel lvm=new LoanInstallmentViewModel(inst.getInstId(), inst.getLedger().getLedgerId(), inst.getInstAmount(), inst.getInstDate(), inst.getPaidDate());
                    b.getInstallments().add(lvm);
                }
                Collections.sort(b.getInstallments(), (x,y)->{
                  return x.getInstId() - y.getInstId();
                });
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
    
    public static boolean updateLoanInstallment(LoanInstallmentViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<LoanInstallment> list = session.createCriteria(LoanInstallment.class)
                .add(Restrictions.eq("instId", model.getInstId())).list();
        try {
            if (!list.isEmpty()) {
                LoanInstallment upd = list.get(0);
                upd.setPaidDate(model.getPaidDate());
                session.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("LoanBao::updateLoanInstallment" + e);

        } finally {
            session.close();
        }
        return false;
    }
    
    public static boolean updateLoanInstallmentAuto(LoanInstallmentViewModel model) {
        Session session = HbUtil.openSession();
        session.beginTransaction();
        List<LoanInstallment> list = session.createCriteria(LoanInstallment.class)
                .add(Restrictions
                        .and(
                                Restrictions.eq("ledger.ledgerId", model.getLedgerId()),
                                Restrictions.isNull("paidDate"))
                ).list();
        try {
            if (!list.isEmpty()) {
                long amount = model.getInstAmount();
                for(LoanInstallment inst: list) {
                    if(amount<=0) {
                        break;
                    }
                    if(amount>=inst.getInstAmount()){
                        inst.setPaidDate(model.getPaidDate());
                        amount = amount - inst.getInstAmount();
                        session.update(inst);
                    }
                }
            }
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("LoanBao::updateLoanInstallmentAuto" + e);

        } finally {
            session.close();
        }
        return false;
    }
}
