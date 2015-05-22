package in.credit.model;
// Generated Apr 24, 2015 9:08:10 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Nominee generated by hbm2java
 */
public class Nominee  implements java.io.Serializable {


     private Integer nomineeId;
     private Account account;
     private String firstName;
     private String middleName;
     private String lastName;
     private String gender;
     private Date birthDate;

    public Nominee() {
    }

	
    public Nominee(String firstName, String middleName, String lastName, String gender) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
    }
    public Nominee(Account account, String firstName, String middleName, String lastName, String gender, Date birthDate) {
       this.account = account;
       this.firstName = firstName;
       this.middleName = middleName;
       this.lastName = lastName;
       this.gender = gender;
       this.birthDate = birthDate;
    }
   
    public Integer getNomineeId() {
        return this.nomineeId;
    }
    
    public void setNomineeId(Integer nomineeId) {
        this.nomineeId = nomineeId;
    }
    public Account getAccount() {
        return this.account;
    }
    
    public void setAccount(Account account) {
        this.account = account;
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
    public Date getBirthDate() {
        return this.birthDate;
    }
    
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }




}


