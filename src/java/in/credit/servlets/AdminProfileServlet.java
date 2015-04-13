/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.credit.servlets;

import in.credit.U;
import in.credit.bao.UserAccountBao;
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
@WebServlet(name = "AdminProfileServlet", urlPatterns = {"/admin/AdminProfile"})
public class AdminProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("account", null);
        request.getRequestDispatcher("/admin/adminProfile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msg="";
        String cmd=U.param(request, "cmd");
        if("Save".equals(cmd)){
            String userEmail=U.param(request, "userEmail");
            String oldPass=U.param(request, "pass");
            String newPass=U.param(request, "userPass");
            int userId=U.paramInt(request, "userId");
            if(UserAccountBao.changePass(userId,newPass, oldPass)){
                msg="OOooooooookkkkkkkk!!!";
            }else{
                msg="eRRoR!!!";
            }
        }
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("/admin/adminProfile.jsp").forward(request, response);
    }

}
