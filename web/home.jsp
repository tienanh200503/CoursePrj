<%-- 
    Document   : home
    Created on : Mar 2, 2024, 1:39:13 PM
    Author     : Desktop
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="container mx-0 px-0">
            <div class="row mx-0 px-0">
                <div class=" d-flex col-md-12">
                    <%@include file="includes/left-bar.jsp" %>
                    <div class="tab2 col-md-8">
                        <h1>
                            All courses
                        </h1>
                    </div>
                </div>
            </div>
        </div>




        <%@include file="includes/footer.jsp" %>
    </body>
</html>
