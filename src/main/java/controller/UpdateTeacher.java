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
import models.Classes;
import models.Subject;
import models.Teacher;
import repository.SchoolRepo;

/**
 *
 * @author HP
 */
@WebServlet(name = "suagv", urlPatterns = {"/suagv"})
public class UpdateTeacher extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String teacherID = request.getParameter("magv");

        request.setAttribute("thongtingiaovien", SchoolRepo.detailTeacher(teacherID));
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/updateteacher.jsp?magv=" + teacherID);
        rd.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try {
            String teacherID = request.getParameter("magv");
            String name = request.getParameter("tengv");
            String mail = request.getParameter("mail");
            int phone = Integer.parseInt(request.getParameter("sdt"));

          //  Teacher teacher = new Teacher(teacherID, name, mail, phone);
           // SchoolRepo.updateTeacher(teacher);

            response.sendRedirect(request.getContextPath() + "/trangchu");
        } catch (Exception e) {
            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
