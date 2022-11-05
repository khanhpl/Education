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
import models.Teacher;
import models.TeacherValidate;
import repository.SchoolRepo;
import repository.ValidateRepo;

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
        
        String teacherID = request.getParameter("magv");
        String name = request.getParameter("tengv");
        String email = request.getParameter("email");
        String phone = request.getParameter("dienthoai");

        Teacher teacherCheck = new Teacher(teacherID, name, email, phone);
        try {
            if (!ValidateRepo.checkInputTeacher(teacherCheck)) {
                request.setAttribute("gvcu", teacherCheck);
                TeacherValidate udNofi = ValidateRepo.nofiInputTeacher(teacherCheck);
                udNofi.setTeacherID("");
                request.setAttribute("kiemtragv", udNofi);
            } else {
                SchoolRepo.updateTeacher(teacherID, teacherCheck);
                response.sendRedirect(request.getContextPath() + "/trangchu");
            }
        } catch (Exception e) {
            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
