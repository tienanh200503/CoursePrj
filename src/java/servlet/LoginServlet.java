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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author Desktop
 */
public class LoginServlet extends HttpServlet {

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
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
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
       String username = this.get("username", request);
       String password = this.get("password", request);
        if (username != null && !username.equals("")) {
            
           try {
               AccountDAO adao = new AccountDAO();
               Account ac = adao.getAccount(username, password);
               request.getSession().setAttribute("auth", ac);
               request.getSession().setAttribute("username",username );
               request.getSession().setAttribute("password",password );
               request.getSession().setAttribute("role",ac.getRole() );
               
               request.getRequestDispatcher("HomeServlet").forward(request, response);
               return;
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
               Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        
        response.sendRedirect("login.jsp");
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
        AccountDAO udao = new AccountDAO();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            Account user = udao.getAccount(username, password);
            if(user!=null)
            {
                request.getSession().removeAttribute("error");
                request.getSession().setAttribute("auth", user);
                request.getSession().setAttribute("role", user.getRole());
                this.add("username", username, 2, response);
                this.add("password", password, 2, response);
                response.sendRedirect("home.jsp");
            }else
            {
                request.getSession().setAttribute("auth", null);
                request.getSession().setAttribute("error", "invalid Account");
                response.sendRedirect("login.jsp");
            }
        } catch (SQLException e) {
            try {
                throw e;
            } catch (SQLException ex) {
                Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
     public static String get(String name, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equalsIgnoreCase(name)) {
                    return c.getValue();
                }
            }

        }
        return null;
    }
    public static Cookie add(String name, String value, int hours, HttpServletResponse response)
    {
        Cookie cookie = new Cookie(name,value);
        cookie.setMaxAge(60*60*hours);
        cookie.setPath("/");
        response.addCookie(cookie);
        return cookie;
    }
}
