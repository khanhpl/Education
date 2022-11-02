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
        String teacherID = request.getParameter("magv");
        String subjectID = request.getParameter("mamon");
        request.setAttribute("thongtinlop", SchoolRepo.detailClass(teacherID, classID));
        request.setAttribute("mamoncu", subjectID);
        System.out.println(subjectID + " day la ma mon cua doget");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/updateclass.jsp?malop=" + classID + "&magv=" + teacherID);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String teacherID = request.getParameter("magv");
            String classID = request.getParameter("malop");
            String subjectID = request.getParameter("mamon");
            String subjectName = request.getParameter("tenmon");
            String timeStart = request.getParameter("batdau");
            String timeEnd = request.getParameter("ketthuc");

            System.out.println(timeStart+"day la gio bat dau ");
//            String sub = request.getParameter("mamoncu");
//
//            System.out.println(sub + "day la mamon cu cua dopost ma mon can sua updateclass");
//            System.out.println(teacherID + "day la magv cua dopost ma mon can sua updateclass");
//            System.out.println(classID + "day la malop cua dopost ma mon can sua updateclass");
            System.out.println(subjectID + "day la mamon moi cua dopost ma mon can sua updateclass");
//            System.out.println(teacherID + " ma giao vien cua uppdateClasss");
            Subject sbCheck = new Subject(subjectID, subjectName);
            Classes classCheck = new Classes(classID, timeStart, timeEnd, sbCheck);

            if (!ValidateRepo.checkInputClasses(subjectID, classCheck)) {
                request.setAttribute("kiemtralop", ValidateRepo.nofiInputClasses(classCheck, subjectID));
                request.setAttribute("thongtinlop", classCheck);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/updateclass.jsp");
                rd.forward(request, response);
            } else {

                SchoolRepo.updateClass(teacherID, classID, subjectID, classCheck);

                response.sendRedirect(request.getContextPath() + "/danhsachlopcuagv?magv=" + teacherID);
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
