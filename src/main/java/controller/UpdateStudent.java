/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import models.Student;
import models.StudentValidate;
import repository.SchoolRepo;
import repository.ValidateRepo;

/**
 *
 * @author nhn19
 */
@WebServlet(name = "suathongtin", urlPatterns = {"/suathongtin"})
public class UpdateStudent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String classID = request.getParameter("malop");
        String studentID = request.getParameter("masinhvien");

        request.setAttribute("thongtinsua", SchoolRepo.detailStudent(classID, studentID));
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/updatestudent.jsp?malop=" + classID + "&masinhvien=" + studentID);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String classID = request.getParameter("malop");
            String studentID = request.getParameter("masinhvien");
            String studentName = request.getParameter("tensinhvien");
            String email = request.getParameter("email");
            String phone = request.getParameter("dienthoai");

            StudentValidate studentCheck = new StudentValidate(studentID, studentName, email, phone);

            if (!ValidateRepo.checkInputStudent(classID, studentCheck)){
                request.setAttribute("kiemtrasinhvien", ValidateRepo.nofiInputStudent(classID, studentCheck));
                request.setAttribute("thongtinsua", studentCheck);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/updatestudent.jsp?malop=" + classID);
                rd.forward(request, response);
            } else {
                int phone2 = Integer.parseInt(phone);
                Student student = new Student(studentID, studentName, email, phone2);
                SchoolRepo.updateStudent(classID, student);
                response.sendRedirect(request.getContextPath() + "/chitietlop?malop=" + classID);
            }
        } catch (Exception e) {
            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
