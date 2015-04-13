package in.credit.servlets;

import in.credit.U;
import in.credit.bao.LoginBao;
import in.credit.bao.UserAccountViewModel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Viram
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate(); // Remove all keys and create new object
        String[] userRole = {"Admin", "Employee", "Customer"};
        request.setAttribute("userRole", userRole);
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fileName = "/login.jsp";
        UserAccountViewModel login=new UserAccountViewModel();
        login.setUserId(U.paramInt(request, "userId"));
        login.setUserEmail(U.param(request, "userEmail"));
        login.setUserPass(U.param(request, "userPass"));
        
        HttpSession session = request.getSession();
        login = LoginBao.login(login);
        if(login !=null) {
           
            session.setAttribute("userId", login.getUserId());
            session.setAttribute("user", login);
            switch(login.getRoleId())
            {
                case 1:
                session.setAttribute("isAdmin", true);
                session.setAttribute("role", "admin");
                fileName = "/admin/index.jsp";
                    break;
                case 2:
                session.setAttribute("isEmp", true);
                session.setAttribute("role", "employee");
                fileName = "/employee/index.jsp";
                    break;
                case 3:
                session.setAttribute("isCust", true);
                session.setAttribute("role", "customer");
                fileName = "/customer/index.jsp";
                    break;
            }
        
        }
         
        
        String message = "Incorrect user Email or password";
        String[] userRole = {"Admin", "Employee", "Customer"};
        request.setAttribute("userRole", userRole);
        request.setAttribute("message", message);
        request.getRequestDispatcher(fileName).forward(request, response);
    }
}
