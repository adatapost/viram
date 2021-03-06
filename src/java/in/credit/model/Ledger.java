package in.credit.model;
// Generated Apr 24, 2015 9:08:10 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Ledger generated by hbm2java
 */
public class Ledger  implements java.io.Serializable {


     private Integer ledgerId;
     private Account account;
     private LedgerType ledgerType;
     private String ledgerName;
     private Date created;
     private Date updated;
     private Boolean isClosed;
     private Boolean isDeleted;
     private Integer currentAcYear;
     private Set<LoanInstallment> loanInstallments = new HashSet<LoanInstallment>(0);
     private Set<Journal> journalsForCrLedgerId = new HashSet<Journal>(0);
     private Set<Journal> journalsForDrLedgerId = new HashSet<Journal>(0);
     private Recurring recurring;
     private Loan loan;
     private Deposit deposit;

    public Ledger() {
    }

	
    public Ledger(String ledgerName) {
        this.ledgerName = ledgerName;
    }
    public Ledger(Account account, LedgerType ledgerType, String ledgerName, Date created, Date updated, Boolean isClosed, Boolean isDeleted, Integer currentAcYear, Set<LoanInstallment> loanInstallments, Set<Journal> journalsForCrLedgerId, Set<Journal> journalsForDrLedgerId, Recurring recurring, Loan loan, Deposit deposit) {
       this.account = account;
       this.ledgerType = ledgerType;
       this.ledgerName = ledgerName;
       this.created = created;
       this.updated = updated;
       this.isClosed = isClosed;
       this.isDeleted = isDeleted;
       this.currentAcYear = currentAcYear;
       this.loanInstallments = loanInstallments;
       this.journalsForCrLedgerId = journalsForCrLedgerId;
       this.journalsForDrLedgerId = journalsForDrLedgerId;
       this.recurring = recurring;
       this.loan = loan;
       this.deposit = deposit;
    }
   
    public Integer getLedgerId() {
        return this.ledgerId;
    }
    
    public void setLedgerId(Integer ledgerId) {
        this.ledgerId = ledgerId;
    }
    public Account getAccount() {
        return this.account;
    }
    
    public void setAccount(Account account) {
        this.account = account;
    }
    public LedgerType getLedgerType() {
        return this.ledgerType;
    }
    
    public void setLedgerType(LedgerType ledgerType) {
        this.ledgerType = ledgerType;
    }
    public String getLedgerName() {
        return this.ledgerName;
    }
    
    public void setLedgerName(String ledgerName) {
        this.ledgerName = ledgerName;
    }
    public Date getCreated() {
        return this.created;
    }
    
    public void setCreated(Date created) {
        this.created = created;
    }
    public Date getUpdated() {
        return this.updated;
    }
    
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
    public Boolean getIsClosed() {
        return this.isClosed;
    }
    
    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }
    public Boolean getIsDeleted() {
        return this.isDeleted;
    }
    
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    public Integer getCurrentAcYear() {
        return this.currentAcYear;
    }
    
    public void setCurrentAcYear(Integer currentAcYear) {
        this.currentAcYear = currentAcYear;
    }
    public Set<LoanInstallment> getLoanInstallments() {
        return this.loanInstallments;
    }
    
    public void setLoanInstallments(Set<LoanInstallment> loanInstallments) {
        this.loanInstallments = loanInstallments;
    }
    public Set<Journal> getJournalsForCrLedgerId() {
        return this.journalsForCrLedgerId;
    }
    
    public void setJournalsForCrLedgerId(Set<Journal> journalsForCrLedgerId) {
        this.journalsForCrLedgerId = journalsForCrLedgerId;
    }
    public Set<Journal> getJournalsForDrLedgerId() {
        return this.journalsForDrLedgerId;
    }
    
    public void setJournalsForDrLedgerId(Set<Journal> journalsForDrLedgerId) {
        this.journalsForDrLedgerId = journalsForDrLedgerId;
    }
    public Recurring getRecurring() {
        return this.recurring;
    }
    
    public void setRecurring(Recurring recurring) {
        this.recurring = recurring;
    }
    public Loan getLoan() {
        return this.loan;
    }
    
    public void setLoan(Loan loan) {
        this.loan = loan;
    }
    public Deposit getDeposit() {
        return this.deposit;
    }
    
    public void setDeposit(Deposit deposit) {
        this.deposit = deposit;
    }




}


