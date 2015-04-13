package in.credit.bao;

import in.credit.model.Role;
import java.util.Date;

/**
 *
 * @author Team
 */
public class UserAccountViewModel {

    private int userId;
    private int roleId;
    private String roleName;
    private String userEmail;
    private String userPass;
    private Date created;
    private Date updated;
    private boolean isDeleted;
    private boolean isActivate;
    private Date lastLogin;

    public UserAccountViewModel() {
    }

    public UserAccountViewModel(int userId) {
        this.userId = userId;
    }

    public UserAccountViewModel(int userId, int roleId, String roleName, String userEmail, String userPass, Date created, Date updated, boolean isDeleted, boolean isActivate, Date lastLogin) {
        this.userId = userId;
        this.roleId = roleId;
        this.roleName = roleName;
        this.userEmail = userEmail;
        this.userPass = userPass;
        this.created = created;
        this.updated = updated;
        this.isDeleted = isDeleted;
        this.isActivate = isActivate;
        this.lastLogin = lastLogin;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public boolean isIsActivate() {
        return isActivate;
    }

    public void setIsActivate(boolean isActivate) {
        this.isActivate = isActivate;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.userId;
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
        final UserAccountViewModel other = (UserAccountViewModel) obj;
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }
    
    
}
