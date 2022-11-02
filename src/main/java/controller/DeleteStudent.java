/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "xoasinhvien", urlPatterns = {"/xoasinhvien"})
public class DeleteStudent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String classID = request.getParameter("malop");
        String studentID = request.getParameter("masinhvien");
        String teacherID = request.getParameter("magv");
        SchoolRepo.deleteStudent(teacherID, classID, studentID);

        response.sendRedirect(request.getContextPath() + "/chitietlop?malop=" + classID + "&magv=" + teacherID);
    }

}
