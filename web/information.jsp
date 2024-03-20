<%-- 
    Document   : information
    Created on : Mar 2, 2024, 10:20:24 PM
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
        <link rel="stylesheet" href="css/information/styleInfor.css" type="text/css">

    </head>
    <body>
        <%@include file="includes/nav.jsp" %>
        <%@include file="includes/left-bar.jsp" %>
        <form action="InforServlet">

            <div class="avatar">
                <img src="image/1.png">
            </div>
            <div class="con">

                <div class="tab-infor">
                    <div>
                        <h3>
                            Xin chào: ${acc.username}
                        </h3>
                    </div>
                    <div>
                        <h3> 
                            Email: ${acc.money}VNĐ
                        </h3>
                    </div>
                    <div>
                        <h3>Số dư hiện có : ${acc.money}VNĐ</h3>
                    </div>

                </div>
                <div class="tab2">
                    <h1>Khóa học đã tham gia</h1>
                    <c:forEach var="i" items="${course}">
                        <div class="card-infor">
                            <div class="sub-card1">
                                <img src="${i.course_img}">
                            </div>
                            <div class="sub-card2">
                                <h4>${i.course_name}</h4>
                                ${i.courseDescribe}
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>
        </form>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
