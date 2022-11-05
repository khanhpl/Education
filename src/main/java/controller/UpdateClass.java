/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import models.Classes;
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
        request.setAttribute("thongtinlop", SchoolRepo.detailClass(teacherID, classID, subjectID));
        request.setAttribute("magv", teacherID);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/updateclass.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
try {
            String teacherID = request.getParameter("magv");
            String classID = request.getParameter("malop");
            String subjectID = request.getParameter("mamon");
            String subIDNew = request.getParameter("mamonmoi");
            String subjectNameNew = request.getParameter("tenmon");
            String timeStartNew = request.getParameter("batdau");
            String timeEndNew = request.getParameter("ketthuc");
            request.setAttribute("magv", teacherID);

            Subject sbCheck = new Subject(subIDNew, subjectNameNew);
            Classes classCheck = new Classes(classID, timeStartNew, timeEndNew, sbCheck);

            if (!ValidateRepo.checkInputClasses(classCheck)) {
                request.setAttribute("kiemtralop", ValidateRepo.nofiInputClasses(classCheck));
                request.setAttribute("thongtinlop", classCheck);

                RequestDispatcher rd = getServletContext().getRequestDispatcher("/updateclass.jsp");
                rd.forward(request, response);
            } else {
                if (!ValidateRepo.checkClassID(classCheck.getClassID(), classCheck.getSubject().getSubjectID())) {
                    request.setAttribute("kiemtralop", ValidateRepo.nofiInputClasses(classCheck));
                    request.setAttribute("thongtinlop", classCheck);

                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/updateclass.jsp");
                    rd.forward(request, response);
                } else {
                    SchoolRepo.updateClass(teacherID, classID, subjectID, classCheck);
                    response.sendRedirect(request.getContextPath() + "/danhsachlopcuagv?magv=" + teacherID);
                }
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
