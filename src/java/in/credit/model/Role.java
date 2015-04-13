package in.credit.model;
// Generated Apr 13, 2015 1:34:56 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Role generated by hbm2java
 */
public class Role  implements java.io.Serializable {


     private Integer roleId;
     private String roleName;
     private Set<UserAccount> userAccounts = new HashSet<UserAccount>(0);

    public Role() {
    }

	
    public Role(String roleName) {
        this.roleName = roleName;
    }
    public Role(String roleName, Set<UserAccount> userAccounts) {
       this.roleName = roleName;
       this.userAccounts = userAccounts;
    }
   
    public Integer getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public Set<UserAccount> getUserAccounts() {
        return this.userAccounts;
    }
    
    public void setUserAccounts(Set<UserAccount> userAccounts) {
        this.userAccounts = userAccounts;
    }




}


