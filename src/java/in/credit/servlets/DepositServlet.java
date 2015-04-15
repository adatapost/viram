package in.credit.servlets;

import in.credit.U;
import in.credit.bao.AccountBao;
import in.credit.bao.AccountViewModel;
import in.credit.bao.DepositBao;
import in.credit.bao.DepositViewModel;
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
@WebServlet(name = "DepositServlet", urlPatterns = {"/admin/deposit", "/employee/deposit"})
public class DepositServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LedgerViewModel ledger = new LedgerViewModel();
        ledger.setLedgerId(U.paramInt(request, "ledgerId"));
        ledger = LedgerBao.get(ledger);
        AccountViewModel account = AccountBao.get(new AccountViewModel(ledger.getAccountId()));
        DepositViewModel fixed = DepositBao.get(new DepositViewModel(ledger.getLedgerId()));
        fixed.setLedger(ledger);

        request.setAttribute("ledger", fixed);
        request.setAttribute("model", account);
        request.getRequestDispatcher("/WEB-INF/pages/deposit.jsp").forward(request, response);
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
        DepositViewModel fixed = DepositBao.get(new DepositViewModel(ledger.getLedgerId()));
        fixed.setLedger(ledger);
        
        ledger.setLedgerName(U.param(request, "ledgerName"));
        ledger.setIsClosed(U.paramBool(request, "isClosed"));
        ledger.setIsDeleted(U.paramBool(request, "isDeleted"));
        
        fixed.setAmount(U.paramDbl(request, "amount"));
        fixed.setMaturityDate(U.paramDate(request, "maturityDate"));
        fixed.setInterestRate(U.paramDbl(request, "interestRate"));
        fixed.setStartDate(U.paramDate(request, "startDate"));
        fixed.setTerm(U.paramInt(request, "term"));
        
        if("Update".equals(cmd)) {
            message = LedgerBao.update(ledger) && DepositBao.update(fixed) ? "Ledger updated successfully" : "Cannot update ledger.";
        }
        if("Delete".equals(cmd)) {
            if(DepositBao.delete(fixed) && LedgerBao.delete(ledger)) {
                request.getRequestDispatcher("/WEB-INF/pages/account.jsp").forward(request, response);
                return;
            } else {
                message = "Cannot delete ledger - It is referenced";
            }
        }

        request.setAttribute("ledger", fixed);
        request.setAttribute("model", account);
        request.setAttribute("message",message);
        request.getRequestDispatcher("/WEB-INF/pages/deposit.jsp").forward(request, response);
    }
}
