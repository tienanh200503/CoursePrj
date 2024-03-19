/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CourseDAO;
import DAO.SectionDAO;
import DAO.TeacherDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Course;
import model.Section;
import model.Teacher;

/**
 *
 * @author Desktop
 */
public class SectionController extends HttpServlet {

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
            out.println("<title>Servlet SectionServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SectionServlet at " + request.getContextPath() + "</h1>");
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
                        ListSection(request, response);
                        break;
                    case "ADD":
                         addSection(request, response);
                        break;
                    case "LOAD":
                        loadCourse(request, response);
                        break;
                    case "UPDATE":
                        updateSection(request, response);
                        break;
                    case "DELETE":
                        deleteSection(request, response);
                        break;
                    default:
                        ListSection(request, response);
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
    
     private void ListSection(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, Exception {
        SectionDAO sdao = new SectionDAO();
        List<Section> sections= sdao.getAllSections();
        request.getSession().setAttribute("sectionList", sections);
        response.sendRedirect("admin-page/listSection.jsp");

    }

    private void loadCourse(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        //read student id from the form data
        int sectionId = Integer.parseInt(request.getParameter("sid"));

//get student from the database
        Section section = new SectionDAO().getSectionById(sectionId );
//place student in the request attribute
//        Course c = (Course) course;
        request.setAttribute("course", section);
        //send to jsp page: update-student-form.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin-page/listSection.jsp");
        dispatcher.forward(request, response);

    }

    private void addSection(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, SQLException, Exception {
       SectionDAO sdao = new SectionDAO();
       

        
        String section = request.getParameter("section");
        int c_id = Integer.parseInt(request.getParameter("c_id"));
        
        String section_name = request.getParameter("section_name");
        String section_video = "video/"+request.getParameter("video");
        Boolean status = Boolean.parseBoolean(request.getParameter("status"));
          

       Section s = new Section(c_id, section_name, section_video, section, true);
        sdao.insertSection(s);
        ListSection(request, response);

    }

    private void updateSection(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, SQLException, Exception {

        SectionDAO sdao = new SectionDAO();
        int sid = Integer.parseInt(request.getParameter("sid"));
        
      
        String section = request.getParameter("section");
        int c_id = Integer.parseInt(request.getParameter("c_id"));
        
        String section_name = request.getParameter("section_name");
        String section_video = "video/"+request.getParameter("video");
        Boolean status = Boolean.parseBoolean(request.getParameter("status"));
          

       Section s = new Section(c_id, section_name, section_video, section, true);
        sdao.updateSection(s, sid);
        ListSection(request, response);
        
    }

    private void deleteSection(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, Exception {
        int cid = Integer.parseInt(request.getParameter("sid"));;
        new SectionDAO().deleteSectionById(cid);
        ListSection(request, response);
    }
}
