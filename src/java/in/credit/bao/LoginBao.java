package in.credit.bao;
import in.credit.U;
import in.credit.model.UserAccount;

/**
 *
 * @author Team
 */
public class LoginBao {

    public static UserAccountViewModel login(UserAccountViewModel obj) {
        UserAccountViewModel acc= UserAccountBao.get(obj);
        if(acc==null) return null;
        if( U.verifyHashPassword(acc.getUserPass(), obj.getUserPass())) {
            UserAccountBao.updateLastLogin(acc);
            return acc;
        }
        return null;
    }
}
