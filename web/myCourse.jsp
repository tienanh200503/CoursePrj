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
        <h2 class="title-course">
                <i class="fas fa-book"></i> My Courses 
            </h2>
        <div id="status">
            <a id="done" href="myCourseServlet?status=1">Đã hoàn thành</a>
            <a id="not" href="myCourseServlet?status=0">Chưa hoàn thành</a>
        </div>
        <br>
        <div class="featuredCourse" style="margin-top: 1rem">
            <% boolean st = (boolean) request.getSession().getAttribute("st");%>
            <c:forEach  var="c" items="${sessionScope.listCourse}">

                <div class="course-Card">
                    <div class="course-picture">
                        <img src="${c.course_img}">
                    </div>
                    <div class="course-details">
                        <h3>${c.course_name}</h3>
                        <div class="sub-details">
                            <p style="color: #333;opacity: 0.5; margin: 0"> By ${c.teacher.teacher_name}</p>
                        </div>
                        <a href="StudyServlet?cid=${c.id}"><%= st ? "" : "Hoc Tiep"%></a
                    </div>

                </div>
                    </div>
            </c:forEach>

        
    </div >  
        
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
