package in.credit.bao;

import in.credit.model.Ledger;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Team
 */
public class LoanInstallmentViewModel {

    private int instId;
    private int ledgerId;
    private long instAmount;
    private Date instDate;
    private Date paidDate;

    public LoanInstallmentViewModel() {
    }

    public LoanInstallmentViewModel(int instId) {
        this.instId = instId;
    }

    public LoanInstallmentViewModel(int instId, int ledgerId, long instAmount, Date instDate, Date paidDate) {
        this.instId = instId;
        this.ledgerId = ledgerId;
        this.instAmount = instAmount;
        this.instDate = instDate;
        this.paidDate = paidDate;
    }
    

    public int getInstId() {
        return instId;
    }

    public void setInstId(int instId) {
        this.instId = instId;
    }

    public int getLedgerId() {
        return ledgerId;
    }

    public void setLedgerId(int ledgerId) {
        this.ledgerId = ledgerId;
    }

    public long getInstAmount() {
        return instAmount;
    }

    public void setInstAmount(long instAmount) {
        this.instAmount = instAmount;
    }

    public Date getInstDate() {
        return instDate;
    }

    public void setInstDate(Date instDate) {
        this.instDate = instDate;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.instId;
        hash = 13 * hash + Objects.hashCode(this.instDate);
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
        final LoanInstallmentViewModel other = (LoanInstallmentViewModel) obj;
        if (this.instId != other.instId) {
            return false;
        }
        if (!Objects.equals(this.instDate, other.instDate)) {
            return false;
        }
        return true;
    }

}
