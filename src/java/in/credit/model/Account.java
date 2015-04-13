package in.credit.model;
// Generated Apr 13, 2015 1:34:56 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Account generated by hbm2java
 */
public class Account  implements java.io.Serializable {


     private int accountId;
     private AccountType accountType;
     private City city;
     private UserAccount userAccountByUserId;
     private UserAccount userAccountByCreatedBy;
     private UserAccount userAccountByReferenceId;
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
     private Set<Ledger> ledgers = new HashSet<Ledger>(0);
     private Set<Nominee> nominees = new HashSet<Nominee>(0);

    public Account() {
    }

	
    public Account(UserAccount userAccountByUserId, String firstName, String middleName, String lastName, String gender, String address) {
        this.userAccountByUserId = userAccountByUserId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
    }
    public Account(AccountType accountType, City city, UserAccount userAccountByUserId, UserAccount userAccountByCreatedBy, UserAccount userAccountByReferenceId, String firstName, String middleName, String lastName, String gender, String address, String phone, Date birthDate, Boolean isDeleted, Date created, Date updated, String custImg, Set<Ledger> ledgers, Set<Nominee> nominees) {
       this.accountType = accountType;
       this.city = city;
       this.userAccountByUserId = userAccountByUserId;
       this.userAccountByCreatedBy = userAccountByCreatedBy;
       this.userAccountByReferenceId = userAccountByReferenceId;
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
       this.ledgers = ledgers;
       this.nominees = nominees;
    }
   
    public int getAccountId() {
        return this.accountId;
    }
    
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    public AccountType getAccountType() {
        return this.accountType;
    }
    
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
    public City getCity() {
        return this.city;
    }
    
    public void setCity(City city) {
        this.city = city;
    }
    public UserAccount getUserAccountByUserId() {
        return this.userAccountByUserId;
    }
    
    public void setUserAccountByUserId(UserAccount userAccountByUserId) {
        this.userAccountByUserId = userAccountByUserId;
    }
    public UserAccount getUserAccountByCreatedBy() {
        return this.userAccountByCreatedBy;
    }
    
    public void setUserAccountByCreatedBy(UserAccount userAccountByCreatedBy) {
        this.userAccountByCreatedBy = userAccountByCreatedBy;
    }
    public UserAccount getUserAccountByReferenceId() {
        return this.userAccountByReferenceId;
    }
    
    public void setUserAccountByReferenceId(UserAccount userAccountByReferenceId) {
        this.userAccountByReferenceId = userAccountByReferenceId;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMiddleName() {
        return this.middleName;
    }
    
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Date getBirthDate() {
        return this.birthDate;
    }
    
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public Boolean getIsDeleted() {
        return this.isDeleted;
    }
    
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
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
    public String getCustImg() {
        return this.custImg;
    }
    
    public void setCustImg(String custImg) {
        this.custImg = custImg;
    }
    public Set<Ledger> getLedgers() {
        return this.ledgers;
    }
    
    public void setLedgers(Set<Ledger> ledgers) {
        this.ledgers = ledgers;
    }
    public Set<Nominee> getNominees() {
        return this.nominees;
    }
    
    public void setNominees(Set<Nominee> nominees) {
        this.nominees = nominees;
    }




}


