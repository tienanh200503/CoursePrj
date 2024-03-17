/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.TeacherDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Teacher;

/**
 *
 * @author Desktop
 */
public class TeacherController extends HttpServlet {

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
            out.println("<title>Servlet TeacherController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TeacherController at " + request.getContextPath() + "</h1>");
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
        try {

            String theCommand = request.getParameter("command");
            if (theCommand == null) {
                theCommand = "LIST";
            }
            switch (theCommand) {
                case "LIST":
                    ListTeacher(request, response);
                    break;
                case "ADD":
                    addTeacher(request, response);
                    break;

                case "UPDATE":
                    updateTeacher(request, response);
                    break;
                case "DELETE":
                    deleteTeacher(request, response);
                    break;
                default:
                    ListTeacher(request, response);
            }

        } catch (Exception ex) {

            Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
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

    private void ListTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, Exception {
        TeacherDAO tdao = new TeacherDAO();
        List<Teacher> teachers = tdao.getAllTeacher();
        request.getSession().setAttribute("teacherList", teachers);
        response.sendRedirect("admin-page/ListTeacher.jsp");

    }

    private void addTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, Exception {
        TeacherDAO tdao = new TeacherDAO();

        String name = request.getParameter("teacher_name");

        Teacher t = new Teacher();
        t.setTeacher_name(name);
        tdao.insertTeacher(t);
        ListTeacher(request, response);

    }

    private void updateTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, Exception {

        TeacherDAO tdao = new TeacherDAO();
        int tid = Integer.parseInt(request.getParameter("tid"));

        String name = request.getParameter("teacher_name");

        Teacher t = new Teacher(tid, name);
        
        tdao.updateTeacherById(tid, t);
        ListTeacher(request, response);

    }

    private void deleteTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, Exception {
        int tid = Integer.parseInt(request.getParameter("tid"));;
        new TeacherDAO().deleteTeacherByid(tid);
        ListTeacher(request, response);
    }

}
