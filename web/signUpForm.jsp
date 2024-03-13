<%-- 
    Document   : signUpForm
    Created on : 2 thg 3, 2024, 21:27:31
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up Form</title>
        <%@include file="includes/head.jsp" %>
    </head>
    <body>
        <%@include file="includes/nav.jsp" %>
        <%@include file="includes/left-bar.jsp" %>
        
        <div class="container">
            <div class="card w-50 mx-auto my-10">
                <div class="card-header text-center"> Sign Up Form</div>
                <div class="card-body">
                    <form action="LoginServlet" method="post">
                        <div class="form-group">
                            <label>Enter your email</label>
                            <input type="email" name="email" class="form-control" placeholder="Enter your email" required="">
                        </div>
                        <div class="form-group">
                            <label>Create a password</label>
                            <input type="password" name="password" class="form-control" placeholder="Create a password" required="">
                        </div>
                        <div class="form-group">
                            <label>Confirm password</label>
                            <input type="password" name="password" class="form-control" placeholder="Confirm password" required="">
                        </div>
                        <div class="form-group">
                            <label>Enter a user name</label>
                            <input type="name" name="name" class="form-control" placeholder="Enter a user name" required="">
                        </div>
                        <div class="text-center">
         
                            <button class="btn btn-primary" type="submit"> Sign up</button>
                            
                        </div>
                    </form>
                </div>
            </div>
        </div>
        
        
        
        
        
        
        
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
