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
            System.out.println(subjectID);
            // request.setAttribute("malop", classID);
            //  request.setAttribute("magv", teacherID);

            Student student = new Student(studentID, studentName, email, phone);
            
            if (!ValidateRepo.checkInputStudent(subjectID, student)) {
                request.setAttribute("kiemtrasinhvien", ValidateRepo.nofiInputStudent(subjectID, student));
                request.setAttribute("sinhviencu", student);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/createstudent.jsp?malop=" + classID + "&mamon=" + subjectID);
                rd.forward(request, response);
            } else {
                if (!ValidateRepo.checkStudentID(subjectID, studentID)) {
                    request.setAttribute("kiemtrasinhvien", ValidateRepo.nofiInputStudent(subjectID, student));
                    request.setAttribute("sinhviencu", student);
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/createstudent.jsp?malop=" + classID + "&mamon=" + subjectID);
                    rd.forward(request, response);
                } else {
                    SchoolRepo.createStudent(teacherID, classID, subjectID, student);
                    response.sendRedirect(request.getContextPath() + "/danhsachlopcuagv?magv=" + teacherID + "&malop=" + classID + "&mamon=" + subjectID);
                }
            }
        } catch (Exception e) {
            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
