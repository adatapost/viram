/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.credit.bao;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Prajapati
 */
public class JournalViewModel {

    private int docId;
    private int ledgerByCrLedgerId;
    private int ledgerByDrLedgerId;
    private Date docDate;
    private double amount;
    private String particular;
    private boolean isDeleted;

    public JournalViewModel() {
    }

    public JournalViewModel(int docId) {
        this.docId = docId;
    }

    public JournalViewModel(int ledgerByCrLedgerId, int ledgerByDrLedgerId, Date docDate, double amount, String particular) {
        this.ledgerByCrLedgerId = ledgerByCrLedgerId;
        this.ledgerByDrLedgerId = ledgerByDrLedgerId;
        this.docDate = docDate;
        this.amount = amount;
        this.particular = particular;
    }

    public int getDocId() {
        return docId;
    }

    public void setDocId(int docId) {
        this.docId = docId;
    }

    public int getLedgerByCrLedgerId() {
        return ledgerByCrLedgerId;
    }

    public void setLedgerByCrLedgerId(int ledgerByCrLedgerId) {
        this.ledgerByCrLedgerId = ledgerByCrLedgerId;
    }

    public int getLedgerByDrLedgerId() {
        return ledgerByDrLedgerId;
    }

    public void setLedgerByDrLedgerId(int ledgerByDrLedgerId) {
        this.ledgerByDrLedgerId = ledgerByDrLedgerId;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getParticular() {
        return particular;
    }

    public void setParticular(String particular) {
        this.particular = particular;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.docId;
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
        final JournalViewModel other = (JournalViewModel) obj;
        if (this.docId != other.docId) {
            return false;
        }
        return true;
    }

}
