package in.credit.servlets;

import in.credit.U;
import in.credit.bao.UserAccountBao;
import in.credit.bao.UserAccountViewModel;
import in.credit.model.Role;
import in.credit.model.UserAccount;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Team
 */
@WebServlet(name = "EmployeeServlet", urlPatterns = {"/admin/employees"})
public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.setAttribute("employees", UserAccountBao.gets(2));
         request.getRequestDispatcher("/admin/employees.jsp")
                 .forward(request, response);
         
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserAccountViewModel emp = new UserAccountViewModel();
        
        emp.setUserId(U.paramInt(request, "userId"));
        emp.setUserEmail(U.param(request, "userEmail"));
        emp.setUserPass(U.param(request, "userPass"));
        emp.setIsActivate(U.paramBool(request, "isActivate"));
        emp.setIsDeleted(U.paramBool(request, "isDeleted"));
        emp.setRoleId(2);
        
        String cmd = U.param(request, "cmd");
        String message = "";
        
        if("Add".equals(cmd)) {
            emp.setCreated(U.now());
            if(UserAccountBao.add(emp)) {
                message = "Employee created successfully";
            } else {
                message = "Duplicate email address. Reenter please";
            }
        }
        if("Edit".equals(cmd)) {
            emp = UserAccountBao.get(emp);
            if(emp == null) {
                message = "Employee not found";
                emp=new UserAccountViewModel();
            } else {
                request.setAttribute("isFound", true);
            }
        }
        if("Update".equals(cmd)) {
            emp.setUpdated(U.now());
            request.setAttribute("isFound", true);
            if(UserAccountBao.update(emp)) {
                message = "Employee updated successfully";
            } else {
                message = "Cannnot update employee";
            }
        }
        if("Delete".equals(cmd)) {
            emp.setUpdated(U.now());
            
            if(UserAccountBao.delete(emp.getUserId())) {
                message = "Employee deleted successfully";
            } else {
                message = "Cannnot delete employee";
            }
        }
        
        request.setAttribute("emp", emp);
         request.setAttribute("employees", UserAccountBao.gets(2));
         request.getRequestDispatcher("/admin/employees.jsp")
                 .forward(request, response);
    }
}
