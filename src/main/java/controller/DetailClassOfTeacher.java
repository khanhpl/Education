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
@WebServlet(name = "danhsachlopcuagv", urlPatterns = {"/danhsachlopcuagv"})
public class DetailClassOfTeacher extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String teacherID = request.getParameter("magv");
//        System.out.println("ma giao vien cua DetailClassTeacher sau khi nhan quay lai la " + teacherID);
        try {
            request.setAttribute("thongtingv", SchoolRepo.detailTeacher(teacherID));
            request.setAttribute("danhsachlop", SchoolRepo.detailTeacher(teacherID).getListClasses());
            request.setAttribute("magv", teacherID);
            

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/detailclassofteacher.jsp");

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
