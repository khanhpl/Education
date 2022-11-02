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
@WebServlet(name = "themsinhvien", urlPatterns = {"/themsinhvien"})
public class CreateStudent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String classID = request.getParameter("malop");
        String teacherID = request.getParameter("magv");
        String subjectID = request.getParameter("mamon");
        //request.setAttribute("malop", classID);
        // request.setAttribute("magv", teacherID);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/createstudent.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String classID = request.getParameter("malop");
            String teacherID = request.getParameter("magv");
            String studentID = request.getParameter("masinhvien");
            String studentName = request.getParameter("tensinhvien");
            String email = request.getParameter("email");
            String phone = request.getParameter("dienthoai");
            String subjectID = request.getParameter("mamon");
            // request.setAttribute("malop", classID);
            //  request.setAttribute("magv", teacherID);

            StudentValidate studentCheck = new StudentValidate(studentID, studentName, email, phone);

            if (!ValidateRepo.checkInputStudent(subjectID, studentCheck)) {
                request.setAttribute("kiemtrasinhvien", ValidateRepo.nofiInputStudent(subjectID, studentCheck));
                request.setAttribute("sinhviencu", studentCheck);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/createstudent.jsp?malop=" + classID + "&mamon=" + subjectID);
                rd.forward(request, response);
            } else {

                Student s = new Student(studentID, studentName, email, phone);

                SchoolRepo.createStudent(teacherID, classID, s);
                System.out.println(teacherID + " đây là mã giáo viên của createstudent");
                response.sendRedirect(request.getContextPath() + "/chitietlop?malop=" + classID + "&magv=" + teacherID);
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/chitietlop?malop=" + classID);
//            rd.forward(request, response);
            }
        } catch (Exception e) {
            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
