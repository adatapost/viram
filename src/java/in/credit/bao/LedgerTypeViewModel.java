package in.credit.bao;

/**
 *
 * @author Team
 */
public class LedgerTypeViewModel {
    private int ledgerTypeId;
     private String ledgerTypeName;

    public LedgerTypeViewModel() {
    }

    public LedgerTypeViewModel(int ledgerTypeId) {
        this.ledgerTypeId = ledgerTypeId;
    }

    public LedgerTypeViewModel(int ledgerTypeId, String ledgerTypeName) {
        this.ledgerTypeId = ledgerTypeId;
        this.ledgerTypeName = ledgerTypeName;
    }

    public int getLedgerTypeId() {
        return ledgerTypeId;
    }

    public void setLedgerTypeId(int ledgerTypeId) {
        this.ledgerTypeId = ledgerTypeId;
    }

    public String getLedgerTypeName() {
        return ledgerTypeName;
    }

    public void setLedgerTypeName(String ledgerTypeName) {
        this.ledgerTypeName = ledgerTypeName;
    }
     
    public boolean isValid() {
        return ledgerTypeName!=null && ledgerTypeName.length()>=1;
    }
}
