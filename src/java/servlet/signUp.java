/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import DAO.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author admin
 */
public class signUp extends HttpServlet {

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
            out.println("<title>Servlet signUp</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet signUp at " + request.getContextPath() + "</h1>");
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
        response.sendRedirect("signupTest.jsp");
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
        AccountDAO adao = new AccountDAO();
        String user = request.getParameter("name");
        String pass = request.getParameter("pass");
        String re_pass = request.getParameter("repass");
        String email = request.getParameter("email");
        Account a = new Account();
        a.setUsername(user);
        a.setPassword(pass);
        a.setEmail(email);
        a.setRole(1);
        
        try {
            boolean isValid = adao.checkValid(a);
            if (isValid ) {
                request.getSession().setAttribute("mess", "Tai khoan da ton tai");
                request.getRequestDispatcher("signupTest.jsp").forward(request, response);

            } else {
                if (pass.equals(re_pass)) {

                    adao.addAccount(a);
                    

                } else {
                    request.getSession().setAttribute("mess", "Password khong trung khop");
                    request.getRequestDispatcher("signupTest.jsp").forward(request, response);

                }
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(signUp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(signUp.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("loginForm.jsp");

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


    private static final long serialVersionUID = 1L;
//@Override 
//     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Lấy dữ liệu từ form
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String email = request.getParameter("email");
//
//        // Kiểm tra tính hợp lệ của dữ liệu (bạn có thể thêm logic kiểm tra ở đây)
//
//        // Tạo đối tượng Account
//        Account account = new Account();
//        account.setUsername(username);
//        account.setPassword(password);
//        account.setEmail(email);
//        // Đặt các thuộc tính khác của Account (nếu có)
//
//        try {
//            // Tạo đối tượng AccountDAO
//            AccountDAO accountDAO = new AccountDAO();
//
//            // Kiểm tra tài khoản đã tồn tại hay chưa
//            if (accountDAO.checkValid(account)) {
//                request.setAttribute("errorMessage", "Tài khoản đã tồn tại");
//                request.getRequestDispatcher("signUpForm.jsp").forward(request, response);
//                return;
//            }
//
//            // Thêm tài khoản mới vào cơ sở dữ liệu
//            accountDAO.addAccount(account);
//
//            // Chuyển hướng đến trang thành công 
//            response.sendRedirect("loginForm.jsp"); // Cần sửa thêm ở đây
//        } catch (Exception e) {
//            e.printStackTrace();
//            request.setAttribute("errorMessage", "Đã xảy ra lỗi trong quá trình đăng ký");
//            request.getRequestDispatcher("signUpForm.jsp").forward(request, response);
//        }
//    }

}
