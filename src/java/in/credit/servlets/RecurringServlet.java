package in.credit.servlets;

import in.credit.U;
import in.credit.bao.AccountBao;
import in.credit.bao.AccountViewModel;
import in.credit.bao.LedgerBao;
import in.credit.bao.LedgerViewModel;
import in.credit.bao.RecurringBao;
import in.credit.bao.RecurringViewModel;
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
@WebServlet(name = "RecurringServlet", urlPatterns = {"/admin/recurring", "/employee/recurring"})
public class RecurringServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LedgerViewModel ledger = new LedgerViewModel();
        ledger.setLedgerId(U.paramInt(request, "ledgerId"));
        ledger = LedgerBao.get(ledger);
        AccountViewModel account = AccountBao.get(new AccountViewModel(ledger.getAccountId()));
        RecurringViewModel recurring = RecurringBao.get(new RecurringViewModel(ledger.getLedgerId()));
        recurring.setLedger(ledger);

        request.setAttribute("ledger", recurring);
        request.setAttribute("model", account);
        request.getRequestDispatcher("/WEB-INF/pages/recurring.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = "";
        String cmd = U.param(request, "cmd");
        LedgerViewModel ledger = new LedgerViewModel();
        ledger.setLedgerId(U.paramInt(request, "ledgerId"));
        ledger = LedgerBao.get(ledger);
        AccountViewModel account = AccountBao.get(new AccountViewModel(ledger.getAccountId()));
        RecurringViewModel recurring = RecurringBao.get(new RecurringViewModel(ledger.getLedgerId()));
        recurring.setLedger(ledger);
        
        ledger.setLedgerName(U.param(request, "ledgerName"));
        ledger.setIsClosed(U.paramBool(request, "isClosed"));
        ledger.setIsDeleted(U.paramBool(request, "isDeleted"));
        
        recurring.setAmount(U.paramDbl(request, "amount"));
        recurring.setEndDate(U.paramDate(request, "endDate"));
        recurring.setFrequency(U.paramInt(request, "frequency"));
        recurring.setInterestRate(U.paramDbl(request, "interestRate"));
        recurring.setStartDate(U.paramDate(request, "startDate"));
        recurring.setTerm(U.paramInt(request, "term"));
        
        if("Update".equals(cmd)) {
            message = LedgerBao.update(ledger) && RecurringBao.update(recurring) ? "Ledger updated successfully" : "Cannot update ledger.";
        }
        if("Delete".equals(cmd)) {
            if(RecurringBao.delete(recurring) && LedgerBao.delete(ledger)) {
                request.getRequestDispatcher("/WEB-INF/pages/account.jsp").forward(request, response);
                return;
            } else {
                message = "Cannot delete ledger - It is referenced";
            }
        }

        request.setAttribute("ledger", recurring);
        request.setAttribute("model", account);
        request.setAttribute("message",message);
        request.getRequestDispatcher("/WEB-INF/pages/recurring.jsp").forward(request, response);
    }
}
