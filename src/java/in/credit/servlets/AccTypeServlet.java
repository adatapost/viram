package in.credit.servlets;

import in.credit.U;
import in.credit.bao.AccountTypeBao;
import in.credit.bao.AccountTypeViewModel;
import in.credit.model.AccountType;
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
@WebServlet(name = "AccTypeServlet", 
        urlPatterns = {"/admin/actype"})
public class AccTypeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("accTypes", AccountTypeBao.gets());
        request.setAttribute("model", new AccountTypeViewModel());
        request.getRequestDispatcher("/WEB-INF/pages/actype.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        AccountTypeViewModel model=new AccountTypeViewModel();
        model.setTypeId(U.paramInt(request, "typeId"));
        model.setTypeName(U.param(request, "typeName"));
        String message = "";
        String cmd = U.param(request, "cmd");
        

        /* Actions */
        if ("Add".equals(cmd)) {
          message = AccountTypeBao.add(model) ?  "Account Type added" :  "Duplicate account type";
        }
        if ("Update".equals(cmd)) {
           message = AccountTypeBao.update(model) ?  "Account Type updated" :  "Cannot update account type";
        }
        if ("Delete".equals(cmd)) {
           message = AccountTypeBao.delete(model) ?  "Account Type deleted" :  "Cannot delete account type";
        }
        if ("Clear".equals(cmd)) {
           model=new AccountTypeViewModel();
        }
 
        if(model.getTypeId()!=0) {
            model=AccountTypeBao.get(model);
        }
        request.setAttribute("message", message);
        request.setAttribute("accTypes", AccountTypeBao.gets());
        request.setAttribute("model", model);
        request.getRequestDispatcher("/WEB-INF/pages/actype.jsp").forward(request, response);
    }
}
