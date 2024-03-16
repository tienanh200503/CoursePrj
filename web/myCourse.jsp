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
            <a id="done" href="myCourseServlet?status=1" >Đã hoàn thành</a>
            <a id="not" href="myCourseServlet?status=0">Chưa hoàn thành</a>
        </div>

        <div id="list">
            <c:forEach var="c" items="${sessionScope.listSection}">
                <div id="section">
                    <p>${c.section_name}</p>
                    <video width="320" height="240" controls>
                        <source src="${c.section_video}" type="video/mp4">
                    </video>
                    <p>${c.section}</p>
                    <p>Course ${c.c_id}</p>
                    <a href="#">${c.status?"":"Go on"}</a>
                </div>
            </c:forEach>
        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
