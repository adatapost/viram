package in.credit.servlets;

import in.credit.U;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Team
 */
@WebServlet(name = "ShowReportServlet", urlPatterns = {"/show-report","/admin/show-report"})
public class ShowReportServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cmd = U.param(request, "cmd");
        String accountId = U.param(request, "accountId");
        String path = request.getServletContext().getRealPath("/report/");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("REPORT_IMAGE", path + "/");
        map.put("CUSTOMER_IMAGE", request.getServletContext().getRealPath("/images/Customers/") + "/");
        response.setContentType("application/pdf");
   
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.err.println("Driver not loaded " + e);
        }
        JasperReport report;
        JasperPrint print;

        if ("account".equals(cmd)) {
            try {
                report = JasperCompileManager.compileReport(path + "\\account.jrxml");
                print = JasperFillManager.fillReport(report, null, U.genConnection());
                JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
            } catch (Exception e) {
                System.err.println("Error " + cmd + " report => " + e);
            }
        }
        if ("current-account".equals(cmd)) {
            try {
                report = JasperCompileManager.compileReport(path + "\\current-ac.jrxml");
                
                print = JasperFillManager.fillReport(report, map, U.genConnection());
                JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
            } catch (Exception e) {
                System.err.println("Error " + cmd + " report => " + e);
            }
        }
        
        if ("savings-account".equals(cmd)) {
            try {
                report = JasperCompileManager.compileReport(path + "\\saving-ac.jrxml");
                
                print = JasperFillManager.fillReport(report, map, U.genConnection());
                JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
            } catch (Exception e) {
                System.err.println("Error " + cmd + " report => " + e);
            }
        }
        
        if ("ledgers".equals(cmd)) {
            try {
                report = JasperCompileManager.compileReport(path + "\\ledgers.jrxml");
                map.put("Parameter1", accountId);
                print = JasperFillManager.fillReport(report, map, U.genConnection());
                JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
            } catch (Exception e) {
                System.err.println("Error " + cmd + " report => " + e);
            }
        }
        
        if ("ledger".equals(cmd)) {
            try {
                report = JasperCompileManager.compileReport(path + "\\ledger.jrxml");
                map.put("Parameter1", Integer.parseInt(accountId));
                print = JasperFillManager.fillReport(report, map, U.genConnection());
                JasperExportManager.exportReportToPdfStream(print, response.getOutputStream());
            } catch (Exception e) {
                System.err.println("Error " + cmd + " report => " + e);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
