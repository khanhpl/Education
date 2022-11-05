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
import repository.SchoolRepo;

/**
 *
 * @author nhn19
 */
@WebServlet(name = "chitietlop", urlPatterns = {"/chitietlop"})
public class DetailClasses extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String classID = request.getParameter("malop");
        String teacherID = request.getParameter("magv");
        String subjectID = request.getParameter("mamon");
        try {
            request.setAttribute("thongtinlop", SchoolRepo.detailClass(teacherID, classID, subjectID));
            request.setAttribute("magv", teacherID);
            request.setAttribute("mamon", subjectID);
            request.setAttribute("malop", classID);

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/detailclass.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            Logger.getLogger(IndexServlet.class.getName()).log(Level.SEVERE, null, e);            
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
