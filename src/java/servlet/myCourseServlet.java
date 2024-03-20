/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import DAO.CourseDAO;
import DAO.OrderDAO;
import DAO.SectionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Course;
import model.Section;

/**
 *
 * @author Zanis
 */
public class myCourseServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet myCourseServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet myCourseServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int status = Integer.parseInt(request.getParameter("status"));
        int uid = Integer.parseInt(request.getParameter("uid"));
        int count = 0;
        OrderDAO ord = new OrderDAO();
        CourseDAO cou = new CourseDAO();
        SectionDAO sec = new SectionDAO();
        List<Course> listNot = new ArrayList<>();
        List<Course> listDone = new ArrayList<>();
        List<Course> list = new ArrayList<>();
        if (status == 0) {
            list = ord.getCourseId(uid);
            for (Course course : list) {
                List<Section> secList = course.getSections();
                for (Section section : secList) {
                    if (section.isStatus() == false) {
                        count++;
                    }
                }
                if (count == 0) {
                    listDone.add(course);
                } else {
                    listNot.add(course);
                    count = 0;
                }
            }
            request.getSession().setAttribute("st", false);
            request.getSession().setAttribute("listCourse", listNot);
            response.sendRedirect("myCourse.jsp");
        } else {
            list = ord.getCourseId(1);
            for (Course course : list) {
                List<Section> secList = course.getSections();
                for (Section section : secList) {
                    if (section.isStatus() == false) {
                        count++;
                    }
                }
                if (count == 0) {
                    listDone.add(course);
                } else {
                    listNot.add(course);
                    count = 0;
                }
            }
            request.getSession().setAttribute("st", true);
            request.getSession().setAttribute("listCourse", listDone);
            response.sendRedirect("myCourse.jsp");
        }
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
