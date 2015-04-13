package in.credit.bao;
 
import java.util.Date;

/**
 *
 * @author Team
 */
public class AccountViewModel {

    private int userId;
    private int roleId;
    private String userEmail;
    private String userPass;

    private int typeId;
    private int stateId;
    private int cityId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String address;
    private String phone;
    private Date birthDate;
    private Boolean isDeleted;
    private Date created;
    private Date updated;
    private String custImg;
    public int referenceUserId;
    public int createdByUserId;

    private String noFirstName;
    private String noMiddleName;
    private String noLastName;
    private String noGender;
    private Date noBirthDate;
    
    private String roleName;
    private String typeName;
    private String cityName;
    private String stateName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public AccountViewModel() {
    }

    public AccountViewModel(int userId) {
        this.userId = userId;
    }

    public AccountViewModel(int userId, int roleId, String userEmail, String userPass, int typeId, int stateId, int cityId, String firstName, String middleName, String lastName, String gender, String address, String phone, Date birthDate, Boolean isDeleted, Date created, Date updated, String custImg, int referenceUserId, int createdByUserId, String noFirstName, String noMiddleName, String noLastName, String noGender, Date noBirthDate) {
        this.userId = userId;
        this.roleId = roleId;
        this.userEmail = userEmail;
        this.userPass = userPass;
        this.typeId = typeId;
        this.stateId = stateId;
        this.cityId = cityId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.birthDate = birthDate;
        this.isDeleted = isDeleted;
        this.created = created;
        this.updated = updated;
        this.custImg = custImg;
        this.referenceUserId = referenceUserId;
        this.createdByUserId = createdByUserId;
        this.noFirstName = noFirstName;
        this.noMiddleName = noMiddleName;
        this.noLastName = noLastName;
        this.noGender = noGender;
        this.noBirthDate = noBirthDate;
    }

    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
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

    public String getCustImg() {
        return custImg;
    }

    public void setCustImg(String custImg) {
        this.custImg = custImg;
    }

    public int getReferenceUserId() {
        return referenceUserId;
    }

    public void setReferenceUserId(int referenceUserId) {
        this.referenceUserId = referenceUserId;
    }

    public int getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(int createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public String getNoFirstName() {
        return noFirstName;
    }

    public void setNoFirstName(String noFirstName) {
        this.noFirstName = noFirstName;
    }

    public String getNoMiddleName() {
        return noMiddleName;
    }

    public void setNoMiddleName(String noMiddleName) {
        this.noMiddleName = noMiddleName;
    }

    public String getNoLastName() {
        return noLastName;
    }

    public void setNoLastName(String noLastName) {
        this.noLastName = noLastName;
    }

    public String getNoGender() {
        return noGender;
    }

    public void setNoGender(String noGender) {
        this.noGender = noGender;
    }

    public Date getNoBirthDate() {
        return noBirthDate;
    }

    public void setNoBirthDate(Date noBirthDate) {
        this.noBirthDate = noBirthDate;
    }

    @Override
    public String toString() {
        return "AccountViewModel{" + "userId=" + userId + ", roleId=" + roleId + ", userEmail=" + userEmail + ", userPass=" + userPass + ", typeId=" + typeId + ", stateId=" + stateId + ", cityId=" + cityId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", gender=" + gender + ", address=" + address + ", phone=" + phone + ", birthDate=" + birthDate + ", isDeleted=" + isDeleted + ", created=" + created + ", updated=" + updated + ", custImg=" + custImg + ", referenceUserId=" + referenceUserId + ", createdByUserId=" + createdByUserId + ", noFirstName=" + noFirstName + ", noMiddleName=" + noMiddleName + ", noLastName=" + noLastName + ", noGender=" + noGender + ", noBirthDate=" + noBirthDate + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.userId;
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
        final AccountViewModel other = (AccountViewModel) obj;
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }
    
    

}
