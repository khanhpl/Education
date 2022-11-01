/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Avatar;
import models.Teacher;
import repository.SchoolRepo;

/**
 *
 * @author HP
 */
@WebServlet(name = "xemttgv", urlPatterns = {"/xemttgv"})
public class DetailTeacher extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String teacherID = request.getParameter("magv");

        try {
            Teacher detailTeacher = SchoolRepo.detailTeacher(teacherID);
            System.out.println(detailTeacher);
            Avatar a = new Avatar("123");
            Teacher test = new Teacher("sfda", "nhjkajk", "dfask@gmail.com", 0213123, a);

            request.setAttribute("thongtingiaovien", detailTeacher);
            System.out.println("12312312");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/detailteacher.jsp");
            System.out.println("fasdbfkjhasjfk");
            rd.forward(request, response);
        } catch (Exception e) {
            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE, null, e);
        }
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

    }

}
