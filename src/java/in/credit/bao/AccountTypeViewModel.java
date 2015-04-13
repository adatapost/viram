package in.credit.bao;

/**
 *
 * @author Team
 */
public class AccountTypeViewModel {
    private int typeId;
    private String typeName;

    public AccountTypeViewModel() {
    }

    public AccountTypeViewModel(int typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public AccountTypeViewModel(int typeId) {
        this.typeId = typeId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
    public boolean isValid() {
        return typeName!=null && typeName.length()>=1;
    }
}
