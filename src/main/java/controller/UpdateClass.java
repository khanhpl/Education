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
@WebServlet(name = "sualop", urlPatterns = {"/sualop"})
public class UpdateClass extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String classID = request.getParameter("malop");

        request.setAttribute("thongtinlop", SchoolRepo.detailClass(classID));
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/updateclass.jsp?malop=" + classID);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String classID = request.getParameter("malop");
            String subjectID = request.getParameter("mamon");
            String subjectName = request.getParameter("tenmon");
            String timeStart = request.getParameter("batdau");
            String timeEnd = request.getParameter("ketthuc");

            Subject sbCheck = new Subject(subjectID, subjectName);
            Classes classCheck = new Classes(classID, timeStart, timeEnd, sbCheck);

            if (!ValidateRepo.checkInputClasses(classCheck)) {
                request.setAttribute("kiemtralop", ValidateRepo.nofiInputClasses(classCheck));
                request.setAttribute("thongtinlop", classCheck);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/updateclass.jsp");
                rd.forward(request, response);
            } else {
                List<Student> listStudent = SchoolRepo.detailClass(classID).getStudents();
                Subject subject = new Subject(subjectID, subjectName);
                Classes classes = new Classes(classID, timeStart, timeEnd, subject, listStudent);
                SchoolRepo.updateClass(classes);

                response.sendRedirect(request.getContextPath() + "/trangchu");
            }
        } catch (Exception e) {
            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
