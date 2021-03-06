package in.credit.servlets;

import in.credit.U;
import in.credit.bao.AccountBao;
import in.credit.bao.AccountViewModel;
import in.credit.bao.LedgerBao;
import in.credit.bao.LedgerViewModel;
import in.credit.bao.LoanBao;
import in.credit.bao.LoanViewModel;
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
@WebServlet(name = "LoanServlet", urlPatterns = {"/admin/loan", "/employee/loan"})
public class LoanServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LedgerViewModel ledger = new LedgerViewModel();
        ledger.setLedgerId(U.paramInt(request, "ledgerId"));
        ledger = LedgerBao.get(ledger);
        AccountViewModel account = AccountBao.get(new AccountViewModel(ledger.getAccountId()));
        LoanViewModel loan = LoanBao.get(new LoanViewModel(ledger.getLedgerId()));
        loan.setLedger(ledger);

        request.setAttribute("ledger", loan);
        request.setAttribute("model", account);
        request.getRequestDispatcher("/WEB-INF/pages/loan.jsp").forward(request, response);
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
        LoanViewModel loan = LoanBao.get(new LoanViewModel(ledger.getLedgerId()));
        loan.setLedger(ledger);

        ledger.setLedgerName(U.param(request, "ledgerName"));
        ledger.setIsClosed(U.paramBool(request, "isClosed"));
        ledger.setIsDeleted(U.paramBool(request, "isDeleted"));

        loan.setAmount(U.paramDbl(request, "amount"));
        loan.setEndDate(U.paramDate(request, "endDate"));
        loan.setInterestRate(U.paramDbl(request, "interestRate"));
        loan.setStartDate(U.paramDate(request, "startDate"));
        loan.setInstallment(U.paramInt(request, "installment"));

        if ("Update".equals(cmd)) {
            message = LedgerBao.update(ledger) && LoanBao.update(loan) ? "Ledger updated successfully" : "Cannot update ledger.";
        }
        if ("Delete".equals(cmd)) {
            if (LoanBao.delete(loan) && LedgerBao.delete(ledger)) {
                request.getRequestDispatcher("/WEB-INF/pages/account.jsp").forward(request, response);
                return;
            } else {
                message = "Cannot delete ledger - It is referenced";
            }
        }

        request.setAttribute("ledger", loan);
        request.setAttribute("model", account);
        request.setAttribute("message", message);
        request.getRequestDispatcher("/WEB-INF/pages/loan.jsp").forward(request, response);
    }

}
