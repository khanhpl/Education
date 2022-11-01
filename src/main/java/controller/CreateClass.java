/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Avatar;
import models.Classes;
import models.Student;
import models.Subject;
import repository.SchoolRepo;
import repository.ValidateRepo;

/**
 *
 * @author nhn19
 */
@WebServlet(name = "taolop", urlPatterns = {"/taolop"})
public class CreateClass extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/createclass.jsp");
        rd.forward(request, response);
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
        try {
            String classID = request.getParameter("malop");
            String timeStart = request.getParameter("batdau");
            String timeEnd = request.getParameter("ketthuc");
            String subjectID = request.getParameter("mamon");
            String subjectName = request.getParameter("tenmon");
            
            Subject sbCheck = new Subject(subjectID, subjectName);
            
            Classes classCheck = new Classes(classID, timeStart, timeEnd, sbCheck);
            if (!ValidateRepo.checkInputClasses(classCheck)) {
                request.setAttribute("kiemtralop", ValidateRepo.nofiInputClasses(classCheck));
                request.setAttribute("lopnhapcu", classCheck);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/createclass.jsp");
                rd.forward(request, response);
            } else {
                List<Student> listStudentNull = new ArrayList<>();
                String studentID2 = "";
                String name = "";
                String email = "";
                int phone = 0;
                String url = "";
                Avatar a = new Avatar(url);
                
                Student studentNull = new Student(studentID2, name, email, phone, a);
                listStudentNull.add(studentNull);
                
                Subject sb = new Subject(subjectID, subjectName);
                Classes clas = new Classes(classID, timeStart, timeEnd, sb, listStudentNull);
                
                SchoolRepo.createClass(clas);
                
                response.sendRedirect(request.getContextPath() + "/trangchu");
            }
        } catch (Exception e) {
            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
}
