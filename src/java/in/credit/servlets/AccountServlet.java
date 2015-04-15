package in.credit.servlets;

import in.credit.U;
import in.credit.bao.AccountBao;
import in.credit.bao.AccountViewModel;
import in.credit.bao.DepositBao;
import in.credit.bao.DepositViewModel;
import in.credit.bao.LedgerBao;
import in.credit.bao.LedgerTypeBao;
import in.credit.bao.LedgerTypeViewModel;
import in.credit.bao.LedgerViewModel;
import in.credit.bao.LoanBao;
import in.credit.bao.LoanViewModel;
import in.credit.bao.RecurringBao;
import in.credit.bao.RecurringViewModel;
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
@WebServlet(name = "AccountServlet",
        urlPatterns = {"/admin/account", "/employee/account"})
public class AccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("accounts", AccountBao.gets());
        request.setAttribute("model", new AccountViewModel());
        request.getRequestDispatcher("/WEB-INF/pages/account.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = "";
        String fileName = "/WEB-INF/pages/account.jsp";
        AccountViewModel model = new AccountViewModel();

        LedgerViewModel ledger = new LedgerViewModel();
        LedgerTypeViewModel type = LedgerTypeBao.get(new LedgerTypeViewModel(U.paramInt(request, "ledgerTypeId")));
        ledger.setAccountId(U.paramInt(request, "userId"));
        ledger.setCreated(U.now());
        ledger.setCurrentAcYear(U.now().getYear() + 1900);
        ledger.setIsClosed(U.paramBool(request, "isClosed"));
        ledger.setIsDeleted(U.paramBool(request, "isDeleted"));
        ledger.setLedgerName(U.param(request, "ledgerName"));
        ledger.setLedgerTypeId(U.paramInt(request, "ledgerTypeId"));
        ledger.setLedgerTypeName(type.getLedgerTypeName());
        ledger.setUpdated(U.now());

        String cmd = U.param(request, "cmd");
        model.setUserId(U.paramInt(request, "userId"));

        /* Actions  */
        if ("AddLedger".equals(cmd)) {
            if (LedgerBao.add(ledger)) {
                if (ledger.getLedgerTypeId() == 6) {
                    DepositViewModel dm = new DepositViewModel();
                    dm.setAmount(0);
                    dm.setCreated(U.now());
                    dm.setInterestRate(0);
                    dm.setLedgerId(ledger.getLedgerId());
                    dm.setMaturityDate(U.now());
                    dm.setStartDate(U.now());
                    dm.setTerm(0);
                    DepositBao.add(dm);
                }
                if (ledger.getLedgerTypeId() == 5) {
                    RecurringViewModel dm = new RecurringViewModel();
                    dm.setAmount(0);
                    dm.setCreated(U.now());
                    dm.setEndDate(U.now());
                    dm.setFrequency(0);
                    dm.setInterestRate(0);
                    dm.setLedgerId(ledger.getLedgerId());
                    dm.setStartDate(U.now());
                    dm.setTerm(0);
                    RecurringBao.add(dm);
                }
                if (ledger.getLedgerTypeId() == 7) {
                    LoanViewModel dm = new LoanViewModel();
                    dm.setLedgerId(ledger.getLedgerId());
                    dm.setAmount(0.0);
                    dm.setEndDate(U.now());
                    dm.setInstallment(0);
                    dm.setInterestRate(0);
                    dm.setStartDate(U.now());
                    LoanBao.add(dm);
                }
                message = "Ledger created successfully";
            } else {
                message = "Cannot create ledger";
            }
        }

        if (model.getUserId()
                != 0) {
            model = AccountBao.get(model);
        }

        if (type.getLedgerTypeId()
                != 0) {
            ledger.setLedgerName(model.getFirstName() + " " + model.getMiddleName() + " " + model.getLastName() + " " + type.getLedgerTypeName() + " A/C");
        }

        request.setAttribute(
                "model", model);
        request.setAttribute(
                "accounts", AccountBao.gets());
        request.setAttribute(
                "ledger", ledger);
        request.setAttribute(
                "ledgers", LedgerBao.getLedgersByAccountId(model.getUserId()));
        request.setAttribute(
                "ledgerTypes", LedgerTypeBao.gets());
        request.setAttribute(
                "message", message);
        request.getRequestDispatcher(fileName)
                .forward(request, response);
    }

}
