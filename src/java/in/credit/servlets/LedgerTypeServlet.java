package in.credit.servlets;

import in.credit.U;
import in.credit.bao.LedgerTypeBao;
import in.credit.bao.LedgerTypeViewModel;
import in.credit.model.LedgerType;
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
@WebServlet(name = "LedgerTypeServlet", 
        urlPatterns = {"/admin/ledger-type"})
public class LedgerTypeServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("ledgerTypes", LedgerTypeBao.gets());
        request.setAttribute("model", new LedgerTypeViewModel());
        request.getRequestDispatcher("/WEB-INF/pages/ledger-type.jsp").forward(request, response);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LedgerTypeViewModel model=new LedgerTypeViewModel();
        model.setLedgerTypeId(U.paramInt(request, "ledgerTypeId"));
        model.setLedgerTypeName(U.param(request, "ledgerTypeName"));
        String cmd = U.param(request, "cmd");
        String message = "";

        /* Actions */ 
        if("Add".equals(cmd)) {
            message= LedgerTypeBao.add(model) ? "Ledger type added successfully" : "Duplicate ledger typename";
        }
        if("Update".equals(cmd)) {
            message= LedgerTypeBao.update(model) ? "Ledger type updated successfully" : "Cannot update ledger type";
        }
        if("Delete".equals(cmd)) {
            message= LedgerTypeBao.delete(model) ? "Ledger type deleted successfully" : "Cannot delete ledger type";
            model=new LedgerTypeViewModel();
        }
        if("Clear".equals(cmd)) {
            model=new LedgerTypeViewModel();
        }
        
        if(model.getLedgerTypeId()!=0){
            model=LedgerTypeBao.get(model);
        }

        request.setAttribute("message", message);
        request.setAttribute("ledgerTypes", LedgerTypeBao.gets());
        request.setAttribute("model", model);
        request.getRequestDispatcher("/WEB-INF/pages/ledger-type.jsp").forward(request, response);
    }
  
}
