/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import repository.AccountRepo;
import repository.SchoolRepo;
import utils.AppUtils;

/**
 *
 * @author HP
 */
@WebServlet(name = "dangnhap", urlPatterns = {"/dangnhap"})
public class AccountLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String _u = request.getParameter("username");
            String _p = request.getParameter("password");
            AccountRepo.read();
            
            
            boolean vail = AccountRepo.checkLogin(_u, _p);
            if (vail) {
                SchoolRepo.read();
                
                AppUtils.storeLoginedUser(request.getSession(), AccountRepo.details(_u));
                
                //Teacher teacher = SchoolRepo.schoolData.getTeacher();
                HttpSession session = request.getSession();
                session.setAttribute("tendangnhap", _u);
               // session.setAttribute("giaovien", teacher);
                response.sendRedirect(request.getContextPath() + "/trangchu");
            }
        } catch (Exception e) {
            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE, null, e);
        }
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
