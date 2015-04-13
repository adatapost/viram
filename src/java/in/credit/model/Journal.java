package in.credit.model;
// Generated Apr 13, 2015 1:34:56 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.Date;

/**
 * Journal generated by hbm2java
 */
public class Journal  implements java.io.Serializable {


     private Integer docId;
     private Ledger ledgerByCrLedgerId;
     private Ledger ledgerByDrLedgerId;
     private Date docDate;
     private BigDecimal amount;
     private String particular;
     private Boolean isDeleted;

    public Journal() {
    }

    public Journal(Ledger ledgerByCrLedgerId, Ledger ledgerByDrLedgerId, Date docDate, BigDecimal amount, String particular, Boolean isDeleted) {
       this.ledgerByCrLedgerId = ledgerByCrLedgerId;
       this.ledgerByDrLedgerId = ledgerByDrLedgerId;
       this.docDate = docDate;
       this.amount = amount;
       this.particular = particular;
       this.isDeleted = isDeleted;
    }
   
    public Integer getDocId() {
        return this.docId;
    }
    
    public void setDocId(Integer docId) {
        this.docId = docId;
    }
    public Ledger getLedgerByCrLedgerId() {
        return this.ledgerByCrLedgerId;
    }
    
    public void setLedgerByCrLedgerId(Ledger ledgerByCrLedgerId) {
        this.ledgerByCrLedgerId = ledgerByCrLedgerId;
    }
    public Ledger getLedgerByDrLedgerId() {
        return this.ledgerByDrLedgerId;
    }
    
    public void setLedgerByDrLedgerId(Ledger ledgerByDrLedgerId) {
        this.ledgerByDrLedgerId = ledgerByDrLedgerId;
    }
    public Date getDocDate() {
        return this.docDate;
    }
    
    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }
    public BigDecimal getAmount() {
        return this.amount;
    }
    
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public String getParticular() {
        return this.particular;
    }
    
    public void setParticular(String particular) {
        this.particular = particular;
    }
    public Boolean getIsDeleted() {
        return this.isDeleted;
    }
    
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }




}


