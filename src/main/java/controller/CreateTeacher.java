/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Classes;
import models.Teacher;
import repository.SchoolRepo;
import repository.ValidateRepo;

/**
 *
 * @author nhn19
 */
@WebServlet(name = "themgv", urlPatterns = {"/themgv"})
public class CreateTeacher extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.sendRedirect(request.getContextPath() + "/createteacher.jsp");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/createteacher.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String teacherID = request.getParameter("magv");
        String teacherName = request.getParameter("tengv");
        String email = request.getParameter("email");
        String phone = request.getParameter("dienthoai");

        Teacher teacherCheck = new Teacher(teacherID, phone, email, phone);
        if (!ValidateRepo.checkInputTeacher(teacherCheck)) {
            request.setAttribute("kiemtragv", ValidateRepo.nofiInputTeacher(teacherCheck));
            request.setAttribute("gvcu", teacherCheck);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/createteacher.jsp");
            rd.forward(request, response);
        } else {
            if (!ValidateRepo.checkTeacherID(teacherID)) {
                request.setAttribute("kiemtragv", ValidateRepo.nofiInputTeacher(teacherCheck));
                request.setAttribute("gvcu", teacherCheck);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/createteacher.jsp");
                rd.forward(request, response);
            } else {
                Classes clasNull = SchoolRepo.classNull();
                List<Classes> listClassNull = new ArrayList<>();
                listClassNull.add(clasNull);
                Teacher tNew = new Teacher(teacherID, teacherName, email, phone, listClassNull);

                SchoolRepo.createTeacher(tNew);
                response.sendRedirect(request.getContextPath() + "/trangchu");
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
