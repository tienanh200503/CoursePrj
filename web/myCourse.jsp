<%-- 
    Document   : myCourse
    Created on : Mar 14, 2024, 11:35:32 AM
    Author     : Zanis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Course</title>
        <%@include file="includes/head.jsp" %>

        <link rel="stylesheet" href="css/home/style.css" type="text/css">
        <link rel="stylesheet" href="css/home/ad.css" type="text/css">
        <link rel="stylesheet" href="css/footer.css" type="text/css">
        <link rel="stylesheet" href="css/nav.css" type="text/css">


    </head>
    <body>
        <style>
            <%@include file="css/myCourse.css" %>
        </style>

        <%@include file="includes/nav.jsp" %>
        <%@include file="includes/left-bar.jsp" %>
        <div id="status">
            <a id="done" href="myCourseServlet?status=1">Đã hoàn thành</a>
            <a id="not" href="myCourseServlet?status=0">Chưa hoàn thành</a>
        </div>
        <div id="list">
            <% boolean st = (boolean)request.getSession().getAttribute("st"); %>
            <c:forEach var="c" items="${sessionScope.listCourse}">
                
                <div id="section">
                    <p>${c.course_name}</p>
                    <img src="${c.course_img}" alt="alt"/>
                    <p>Teacher: ${c.teacher.teacher_name}</p>
                    <a href="#"><%= st?"":"Hoc Tiep" %></a>
                    
                </div>
            </c:forEach>
        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
