/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Desktop
 */
public class IsLoginFilter implements Filter {

    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public IsLoginFilter() {
    }

    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("IsLoginFilter:DoBeforeProcessing");
        }

        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log items on the request object,
        // such as the parameters.
        /*
	for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    String values[] = request.getParameterValues(name);
	    int n = values.length;
	    StringBuffer buf = new StringBuffer();
	    buf.append(name);
	    buf.append("=");
	    for(int i=0; i < n; i++) {
	        buf.append(values[i]);
	        if (i < n-1)
	            buf.append(",");
	    }
	    log(buf.toString());
	}
         */
    }

    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("IsLoginFilter:DoAfterProcessing");
        }

        // Write code here to process the request and/or response after
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log the attributes on the
        // request object after the request has been processed. 
        /*
	for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    Object value = request.getAttribute(name);
	    log("attribute: " + name + "=" + value.toString());

	}
         */
        // For example, a filter might append something to the response.
        /*
	PrintWriter respOut = new PrintWriter(response.getWriter());
	respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
         */
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        if (debug) {
            log("IsLoginFilter:doFilter()");
        }

        doBeforeProcessing(request, response);
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        //kiểm tra có session hay không
        HttpSession session = httpRequest.getSession(false);
        boolean isLoggedIn = (session != null && session.getAttribute("auth") != null);
        String registerURI = httpRequest.getContextPath() + "/signupTest.jsp"; // Đường dẫn đến trang đăng nhập
        String registerServletURI = httpRequest.getContextPath() + "/signUp"; // Đường dẫn đến trang đăng nhập
        String loginURI = httpRequest.getContextPath() + "/loginForm.jsp"; // Đường dẫn đến trang đăng nhập
        String homeURI = httpRequest.getContextPath() + "/HomeServlet"; // Đường dẫn đến trang home
        String homeURIJsp = httpRequest.getContextPath() + "/home.jsp"; // Đường dẫn đến trang home
        String detailURI = httpRequest.getContextPath() + "/DetailServlet"; // Đường dẫn đến trang detail
        String loginServletURI = httpRequest.getContextPath() + "/LoginServlet";
        String searchURI = httpRequest.getContextPath() + "/search.jsp";
        String searchServlet = httpRequest.getContextPath() + "/SearchServlet";
        // Kiểm tra nếu người dùng đã đăng nhập hoặc đang yêu cầu vào trang đăng nhập,
        // trang home hoặc trang detail
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean isHomeServlet = httpRequest.getRequestURI().equals(homeURI);
        boolean isRegister = httpRequest.getRequestURI().equals(registerURI);
        boolean isRegisterServlet = httpRequest.getRequestURI().equals(registerServletURI);
        boolean isDetailPage = httpRequest.getRequestURI().startsWith(detailURI);
        boolean isHomeURIJsp = httpRequest.getRequestURI().equals(homeURIJsp);
        boolean isCSSRequest = httpRequest.getRequestURI().endsWith(".css");
        boolean isLoginServlet = httpRequest.getRequestURI().equals(loginServletURI);
        boolean isSearch = httpRequest.getRequestURI().equals(searchURI);
        boolean isSearchServlet = httpRequest.getRequestURI().equals(searchServlet);

        if (isLoggedIn || isLoginRequest || isHomeServlet || isDetailPage || isHomeURIJsp || isCSSRequest || isLoginServlet || isSearch || isSearchServlet || isRegister || isRegisterServlet) {
            // Nếu người dùng đã đăng nhập hoặc đang yêu cầu vào trang đăng nhập,
            // trang home hoặc trang detail, chuyển tiếp yêu cầu tới servlet tiếp theo
            chain.doFilter(request, response);
        } else {
            // Nếu không, chuyển hướng đến trang đăng nhập
            httpResponse.sendRedirect(loginURI);
        }

        doAfterProcessing(request, response);

    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {
                log("IsLoginFilter:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("IsLoginFilter()");
        }
        StringBuffer sb = new StringBuffer("IsLoginFilter(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }

    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);

        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
                pw.print(stackTrace);
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }

    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }

    public void log(String msg) {
        filterConfig.getServletContext().log(msg);
    }

}
