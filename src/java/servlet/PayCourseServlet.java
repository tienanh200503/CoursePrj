/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import DAO.AccountDAO;
import DAO.CourseDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Course;

/**
 *
 * @author BIN
 */
public class PayCourseServlet extends HttpServlet {

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
            out.println("<title>Servlet PayCourseServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PayCourseServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
    try {
        HttpSession session = request.getSession();
        String confirm = request.getParameter("confirm");
        if (confirm != null && confirm.equals("confirm")) {
            // Lấy thông tin tài khoản từ session
            AccountDAO adao = new AccountDAO();
            Double account = adao.getAccountById(2).getMoney();
            // Lấy thông tin khóa học
            CourseDAO cdao = new CourseDAO();
            Double course = cdao.getCourse(2).getCourse_price(); // Thay thế 2 bằng ID của khóa học

            // Kiểm tra xem tài khoản có đủ tiền để mua khóa học không
            if (account < course) {
                request.setAttribute("notification", "Vui lòng nạp thêm tiền");
                request.getRequestDispatcher("HomeServlet").forward(request, response);
            } else {
                Double total = account - course;
                adao.updateAccountATM(2, total);
                request.getRequestDispatcher("LoginServlet").forward(request, response);
            }
        } else {
            // Nếu không có xác nhận, chuyển hướng đến trang "buy.jsp"
            response.sendRedirect("buy.jsp");
        }
    } catch (Exception ex) {
        Logger.getLogger(PayCourseServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
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
