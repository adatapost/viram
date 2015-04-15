package in.credit.servlets;

import in.credit.U;
import in.credit.bao.AccountBao;
import in.credit.bao.AccountViewModel;
import in.credit.bao.JournalBao;
import in.credit.bao.JournalViewModel;
import in.credit.bao.LedgerBao;
import in.credit.bao.LedgerViewModel;
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
@WebServlet(name = "JournalServlet",
        urlPatterns = {"/admin/journal", "/employee/journal"})
public class JournalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("accounts", AccountBao.gets());
        request.setAttribute("model", new AccountViewModel());
        request.getRequestDispatcher("/WEB-INF/pages/journal.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = "";
        String cmd = U.param(request, "cmd");
        
        AccountViewModel model = new AccountViewModel();
        model.setUserId(U.paramInt(request, "userId"));
        
        LedgerViewModel ledger = new LedgerViewModel();
        ledger.setLedgerId(U.paramInt(request, "ledgerId"));
        
        JournalViewModel journal = new JournalViewModel();
        journal.setDocId(U.paramInt(request, "docId"));
        String jourType = U.param(request, "jourType");
        int jourTypeId = U.paramInt(request, "jourTypeId");

        if (jourType.equals("Cr")) {
            journal.setLedgerByCrLedgerId(jourTypeId);
            journal.setLedgerByDrLedgerId(ledger.getLedgerId());
        } else {
            journal.setLedgerByDrLedgerId(jourTypeId);
            journal.setLedgerByCrLedgerId(ledger.getLedgerId());
        }
        
        journal.setAmount(U.paramDbl(request, "amount"));
        journal.setDocDate(U.now());
        journal.setIsDeleted(false);
        journal.setParticular(U.param(request, "particular"));

        if ("Back".equals(cmd)) {
            ledger.setLedgerId(0);
        }
        
        if("Add".equals(cmd)) {
           message=JournalBao.add(journal) ? "Journal added successfully" : "Cannot add journal";
        }
        
        if("Delete".equals(cmd)) {
            message = JournalBao.delete(journal) ? "Journal entry deleted successfully" : "Cannot delete journal entry";
        }
        
        
        
        if (model.getUserId()
                != 0) {
            model = AccountBao.get(model);
        }
        if (ledger.getLedgerId() != 0) {
            ledger = LedgerBao.get(ledger);
        }

        request.setAttribute(
                "model", model);
        request.setAttribute(
                "ledger", ledger);
        request.setAttribute(
                "accounts", AccountBao.gets());

        request.setAttribute(
                "ledgers", LedgerBao.getLedgersByAccountId(model.getUserId()));

        request.setAttribute(
                "bankLedgers", LedgerBao.getLedgersByAccountId(1));

        request.setAttribute(
                "journals", JournalBao.gets(ledger.getLedgerId()));

        request.setAttribute(
                "message", message);
        request.getRequestDispatcher("/WEB-INF/pages/journal.jsp")
                .forward(request, response);
    }

}
