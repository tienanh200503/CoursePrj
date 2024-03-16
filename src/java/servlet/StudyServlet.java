/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import DAO.CourseDAO;
import DAO.SectionDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author Desktop
 */
public class StudyServlet extends HttpServlet {

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
            out.println("<title>Servlet StudyServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudyServlet at " + request.getContextPath() + "</h1>");
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
            int cid = 2;
            CourseDAO cdao = new CourseDAO();
            Course c = cdao.getCourseById(cid);
            SectionDAO sdao = new SectionDAO();
            request.getSession().setAttribute("c", c);
            if (request.getParameter("sid") == null) {
                Section s = c.getSections().get(0);
                request.getSession().setAttribute("sCurrent", s);
                if (s.isStatus() == false) {
                    boolean status = Boolean.parseBoolean(request.getParameter("status"));
                    if (status) {
                        Section ss = sdao.getSectionById(s.getSection_id());
                        Section updateSection = new Section(ss.getSection_id(), ss.getC_id(), ss.getSection_name(), ss.getSection_video(), ss.getSection(), status);
                        sdao.updateSection(updateSection, s.getSection_id());

                    }
                }
                response.sendRedirect("course.jsp?sid=" + s.getSection_id() + "&cid=" + c.getId());
            } else {

                Section ss = sdao.getSectionById(Integer.parseInt(request.getParameter("sid")));
                request.getSession().setAttribute("sCurrent", ss);
                response.sendRedirect("course.jsp?sid=" + ss.getSection_id() + "&cid=" + c.getId());
                if (ss.isStatus() == false) {
                    boolean status = Boolean.parseBoolean(request.getParameter("status"));
                    if (status) {
                        
                        Section updateSection = new Section(ss.getSection_id(), ss.getC_id(), ss.getSection_name(), ss.getSection_video(), ss.getSection(), status);
                        sdao.updateSection(updateSection, ss.getSection_id());

                    }
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(StudyServlet.class.getName()).log(Level.SEVERE, null, ex);
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
