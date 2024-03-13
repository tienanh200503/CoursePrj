<%-- 
    Document   : loginForm
    Created on : 2 thg 3, 2024, 21:03:11
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
         <%@include file="includes/head.jsp" %>
    </head>
    <body>
        <%@include file="includes/nav.jsp" %>
        <%@include file="includes/left-bar.jsp" %>
        
        <div class="container">
            <div class="card w-50 mx-auto my-10">
                <div class="card-header text-center"> Login Form</div>
                <div class="card-body">
                    <form action="LoginServlet" method="post">
                        <div class="form-group">
                            <label>Email Address</label>
                            <input type="email" name="email" class="form-control" placeholder="Email Address" required="">
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" name="password" class="form-control" placeholder="Password" required="">
                        </div>
                        <div class="text-center">
                            <button class="btn btn-primary" type="submit"> Sign in</button>
                            <button class="btn btn-primary" type="submit"> Sign up</button>
                            
                        </div>
                    </form>
                </div>
            </div>
        </div>
        
        
        
        
        
        
        
        <%@include file="includes/footer.jsp" %>
        
    </body>
</html>
