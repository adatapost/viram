package in.credit.bao;

import java.util.Date;

/**
 *
 * @author Team
 */
public class LedgerViewModel {

    private int ledgerId;
    private int ledgerTypeId;
    private String ledgerTypeName;
    private String ledgerName;
    private int accountId;
    private Date created;
    private Date updated;
    private boolean isClosed;
    private boolean isDeleted;
    private int currentAcYear;

    public LedgerViewModel() {
    }

    public LedgerViewModel(int ledgerId) {
        this.ledgerId = ledgerId;
    }

    public LedgerViewModel(int ledgerId, int ledgerTypeId, String ledgerName, int accountId, Date created, Date updated, boolean isClosed, boolean isDeleted, int currentAcYear, String ledgerTypeName) {
        this.ledgerId = ledgerId;
        this.ledgerTypeId = ledgerTypeId;
        this.ledgerName = ledgerName;
        this.accountId = accountId;
        this.created = created;
        this.updated = updated;
        this.isClosed = isClosed;
        this.isDeleted = isDeleted;
        this.currentAcYear = currentAcYear;
        this.ledgerTypeName = ledgerTypeName;
    }

    public String getLedgerTypeName() {
        return ledgerTypeName;
    }

    public void setLedgerTypeName(String ledgerTypeName) {
        this.ledgerTypeName = ledgerTypeName;
    }

    
    public int getLedgerId() {
        return ledgerId;
    }

    public void setLedgerId(int ledgerId) {
        this.ledgerId = ledgerId;
    }

    public int getLedgerTypeId() {
        return ledgerTypeId;
    }

    public void setLedgerTypeId(int ledgerTypeId) {
        this.ledgerTypeId = ledgerTypeId;
    }

    public String getLedgerName() {
        return ledgerName;
    }

    public void setLedgerName(String ledgerName) {
        this.ledgerName = ledgerName;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public boolean isIsClosed() {
        return isClosed;
    }

    public void setIsClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getCurrentAcYear() {
        return currentAcYear;
    }

    public void setCurrentAcYear(int currentAcYear) {
        this.currentAcYear = currentAcYear;
    }

    @Override
    public String toString() {
        return "LedgerViewModel{" + "ledgerId=" + ledgerId + ", ledgerTypeId=" + ledgerTypeId + ", ledgerName=" + ledgerName + ", accountId=" + accountId + ", created=" + created + ", updated=" + updated + ", isClosed=" + isClosed + ", isDeleted=" + isDeleted + ", currentAcYear=" + currentAcYear + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.ledgerId;
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
        final LedgerViewModel other = (LedgerViewModel) obj;
        if (this.ledgerId != other.ledgerId) {
            return false;
        }
        return true;
    }

}
