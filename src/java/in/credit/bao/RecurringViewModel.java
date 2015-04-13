package in.credit.bao;

import java.util.Date;

/**
 *
 * @author Team
 */
public class RecurringViewModel {

    
    private int ledgerId;
    private String ledgerName;
    private int userId;
    private Date startDate;
    private int frequency;
    private int term;
    private Date endDate;
    private double amount;
    private double interestRate;
    private Date created;

    public RecurringViewModel() {
    }

    public RecurringViewModel(int ledgerId) {
        this.ledgerId = ledgerId;
    }

    public RecurringViewModel(int ledgerId, String ledgerName, int userId, Date startDate, int frequency, int term, Date endDate, double amount, double interestRate, Date created) {
        this.ledgerId = ledgerId;
        this.ledgerName = ledgerName;
        this.userId = userId;
        this.startDate = startDate;
        this.frequency = frequency;
        this.term = term;
        this.endDate = endDate;
        this.amount = amount;
        this.interestRate = interestRate;
        this.created = created;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.ledgerId;
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
        final RecurringViewModel other = (RecurringViewModel) obj;
        if (this.ledgerId != other.ledgerId) {
            return false;
        }
        return true;
    }

   
}
