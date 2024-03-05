<%-- 
    Document   : login
    Created on : Mar 1, 2024, 10:24:32 AM
    Author     : Desktop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login page</title>
        <%@include file="includes/head.jsp" %>
    </head>
    <body>
         <%@include file="includes/nav.jsp" %>
        <div class="container">
            <div class="card w-50 mx-auto my-5">
                <div class="card-header text-center"> Login Form</div>
                <div class="card-body">
                    <form action="LoginServlet" method="post">
                        <div class="form-group">
                            <label>Email Address</label>
                            <input type="text" name="email" class="form-control" placeholder="Email Adress" required="">
                        </div>
                        <div class="form-group">
                            <label>password</label>
                            <input type="password" name="password" class="form-control" placeholder="password" required="">
                        </div>
                        <div class="text-center">
                            <button class="btn btn-primary" type="submit"> Login</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
