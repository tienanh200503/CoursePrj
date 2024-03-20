/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.CourseDAO;
import DAO.TeacherDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import javax.servlet.http.Part;
import model.Course;
import model.Teacher;

/**
 *
 * @author Desktop
 */
public class CourseController extends HttpServlet {

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
            out.println("<title>Servlet CourseController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CourseController at " + request.getContextPath() + "</h1>");
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
                        ListCourse(request, response);
                        break;
                    case "ADD":
                        addCourse(request, response);
                        break;
                    case "LOAD":
                        loadCourse(request, response);
                        break;
                    case "UPDATE":
                        updateCourse(request, response);
                        break;
                    case "DELETE":
                        deleteCourse(request, response);
                        break;
                    default:
                        ListCourse(request, response);
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    

    

    private void ListCourse(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, Exception {
        CourseDAO cdao = new CourseDAO();
        List<Course> courses = cdao.getAllCourse();
        request.getSession().setAttribute("courseList", courses);
        response.sendRedirect("admin-page/ListCourse.jsp");

    }

    private void loadCourse(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        //read student id from the form data
        int courseId = Integer.parseInt(request.getParameter("cid"));

//get student from the database
        Course course = new CourseDAO().getCourse(courseId);
//place student in the request attribute
        Course c = (Course) course;
        request.setAttribute("course", c);
        //send to jsp page: update-student-form.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin-page/editCourse.jsp");
        dispatcher.forward(request, response);

    }

    private void addCourse(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, SQLException, Exception {
        CourseDAO courseDAO = new CourseDAO();
        TeacherDAO teacherDAO = new TeacherDAO();

        String name = request.getParameter("course_name");
        int course_time = Integer.parseInt(request.getParameter("course_time"));
        int teacher_id = Integer.parseInt(request.getParameter("teacher_id"));
        double course_price = Double.parseDouble(request.getParameter("course_price"));
        String course_describe = request.getParameter("course_describe");
        String course_picture = "image/"+request.getParameter("course_picture");

        Teacher t = teacherDAO.getTeacherById(teacher_id);

        Course c = new Course(name, course_time, course_price, t, course_describe, course_picture);
        courseDAO.insertCourse(c);

        ListCourse(request, response);

    }

    private void updateCourse(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, SQLException, Exception {

        int cid = Integer.parseInt(request.getParameter("cid"));
        String name = request.getParameter("course_name");

        int course_time = Integer.parseInt(request.getParameter("course_time"));
        int teacher_id = Integer.parseInt(request.getParameter("t_id"));
        double course_price = Double.parseDouble(request.getParameter("course_price"));
        String course_describe = request.getParameter("course_describe");
        String course_picture = "image/"+request.getParameter("course_picture");
        Teacher t = new TeacherDAO().getTeacherById(teacher_id);
        Course c = new Course(name, course_time, course_price, t, course_describe, course_picture);
        new CourseDAO().updateCourse(c, cid);
        ListCourse(request, response);
    }

    private void deleteCourse(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, Exception {
        int cid = Integer.parseInt(request.getParameter("cid"));;
        new CourseDAO().deleteCourse(cid);
        ListCourse(request, response);
    }
}
