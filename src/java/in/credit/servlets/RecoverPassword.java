package in.credit.servlets;

import in.credit.U;
import in.credit.bao.LoginBao;
import in.credit.bao.UserAccountBao;
import in.credit.bao.UserAccountViewModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Team
 */
@WebServlet(name = "RecoverPAssword", urlPatterns = {"/recover"})
public class RecoverPassword extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/recover.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               
        UserAccountViewModel user=new UserAccountViewModel();
        user.setUserEmail(U.param(request, "userEmail"));
        
        user = UserAccountBao.get(user);
        if(user!=null){
            String newPass = U.getRandomPassword();
            String hash = U.hashPassword(newPass);
            String msg=U.sendEmail(user.getUserEmail(), "Member", "Recovery of password",
                    "\nDear,\n\nPlease keep note of your password : " + newPass);
            UserAccountBao.changePass(user.getUserId(), hash, user.getUserPass());
            if(msg.equals("OK")) {
                request.setAttribute("message", "New password is sent to your email. Please verify your Inbox");
            } else {
                request.setAttribute("message", "Due to tehnical issue, we cannot sent your password through the email so please note down your new password : " + newPass);
            }
        } else {
            request.setAttribute("message","Given user email is not exists.");
        }
        request.getRequestDispatcher("/recover.jsp").forward(request, response);
    }
}
