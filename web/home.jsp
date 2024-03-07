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
        <link rel="stylesheet" href="css/home/home.css" type="text/css">
    </head>
    <body>
        <%@include file="includes/nav.jsp" %>
        <%@include file="includes/left-bar.jsp" %>
        <div class="contain mx-10 px-0">
            
            
            <div class="featuredCourse">
                <c:forEach items="${sessionScope.listCourse}" var="c">
                    
                    <div class="course-Card">
                        <div class="course-picture">
                            <img src="${c.course_img}">
                        </div>
                        <div class="course-details">
                            <h4>${c.course_name}</h4>
                            <p>${c.teacher.teacher_name}</p>
                            <div class="sub-details">
                                <p>${c.sections.size()}</p>
                                <p>
                                    ${c.course_price}
                                </p>
                            </div>
                                <p>${c.course_time}</p>
                        </div>
                        <button type="submit" value="MUA NGAY"></button>
                    </div>
                </c:forEach>
            </div>
        </div>




        <%@include file="includes/footer.jsp" %>
    </body>
</html>
