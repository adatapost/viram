/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.credit.servlets;

import in.credit.U;
import in.credit.bao.AccountBao;
import in.credit.bao.LedgerBao;
import in.credit.bao.LedgerTypeBao;
import in.credit.bao.LedgerViewModel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Viram
 */
@WebServlet(name = "LedgerServlet", urlPatterns = {"/admin/ledger"})
public class LedgerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        
         request.setAttribute("ledgerType", LedgerTypeBao.gets());
         request.getRequestDispatcher("/WEB-INF/pages/ledger.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {String  dispatcherFile = U.param(request, "dispatcherFile");

            request.getRequestDispatcher("/WEB-INF/pages/ledger.jsp").forward(request, response);
    }
}
