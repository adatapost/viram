package in.credit.bao;

import in.credit.model.Ledger;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Team
 */
public class DepositViewModel {

    
    private int ledgerId;
    private String ledgerName;
    private int userId;
    private Date startDate;
    private Date maturityDate;
    private double amount;
    private double interestRate;
    private Date created;
    private int term;
    private LedgerViewModel ledger;

    public LedgerViewModel getLedger() {
        return ledger;
    }

    public void setLedger(LedgerViewModel ledger) {
        this.ledger = ledger;
    }

    
    

    public DepositViewModel() {
    }

    public DepositViewModel(int ledgerId) {
        this.ledgerId = ledgerId;
    }

    public DepositViewModel(int ledgerId, String ledgerName, int userId, Date startDate, Date maturityDate, double amount, double interestRate, Date created, int term) {
        this.ledgerId = ledgerId;
        this.ledgerName = ledgerName;
        this.userId = userId;
        this.startDate = startDate;
        this.maturityDate = maturityDate;
        this.amount = amount;
        this.interestRate = interestRate;
        this.created = created;
        this.term = term;
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

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
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

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.ledgerId;
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
        final DepositViewModel other = (DepositViewModel) obj;
        if (this.ledgerId != other.ledgerId) {
            return false;
        }
        return true;
    }

     
    
}
