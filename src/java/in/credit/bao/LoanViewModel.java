package in.credit.bao;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Viram
 */
public class LoanViewModel {
    
    private int ledgerId;
    private String ledgerName;
    private Date startDate;
    private Date endDate;
    private double amount;
    private double interestRate;
    private int installment;

    public LoanViewModel() {
    }

    public LoanViewModel(int ledgerId) {
        this.ledgerId = ledgerId;
    }

    public LoanViewModel(int ledgerId, String ledgerName, Date startDate, Date endDate, double amount, double interestRate, int installment) {
        this.ledgerId = ledgerId;
        this.ledgerName = ledgerName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.interestRate = interestRate;
        this.installment = installment;
    }

    public int getLedgerId() {
        return ledgerId;
    }

    public void setLedgerId(int ledgerId) {
        this.ledgerId = ledgerId;
    }

    public String getLedgerName() {
        return ledgerName;
    }

    public void setLedgerName(String ledgerName) {
        this.ledgerName = ledgerName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getInstallment() {
        return installment;
    }

    public void setInstallment(int installment) {
        this.installment = installment;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.ledgerId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LoanViewModel other = (LoanViewModel) obj;
        if (this.ledgerId != other.ledgerId) {
            return false;
        }
        return true;
    }

     
   
}
