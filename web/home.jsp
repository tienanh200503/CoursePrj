<%-- 
    Document   : home
    Created on : Mar 2, 2024, 1:39:13 PM
    Author     : Desktop
--%>
<%@ page import="java.text.NumberFormat,java.util.Locale" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="includes/head.jsp" %>
        <link rel="stylesheet" href="css/home/home.css" type="text/css">
        <link rel="stylesheet" href="css/home/style.css" type="text/css">

    </head>

    <body>

        <%@include file="includes/nav.jsp" %>
        <%@include file="includes/left-bar.jsp" %>
        <div class="contain" style="margin-top: 100px">


            <h2 class="title-course">
                <i class="fas fa-book"></i> Khóa học nổi bật <i class="fas fa-fire fa-xs" style="color: red;"></i>
            </h2>

            <div class="featuredCourse" style="margin-bottom: 3rem ">
                <c:forEach begin="0" end="7" var="c" items="${sessionScope.listCourse}">
                    <c:set var="amount" value="${c.course_price}" />
                    <%
                        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
                        String formattedAmount = formatter.format((double) pageContext.getAttribute("amount"));
                    %>
                    <div class="course-Card">
                        <div class="course-picture">
                            <img src="${c.course_img}">
                        </div>
                        <div class="course-details">
                            <h3><a href="DetailServlet?cid=${c.id}">${c.course_name}</a></h3>


                            <div class="sub-details">


                                <p style="color: #333;opacity: 0.5; margin: 0"> By ${c.teacher.teacher_name}</p>

                                <p  class="price"style="color: #f05123"> <%= formattedAmount%></p>




                            </div>
                            <button class="buy-button" type="submit" ><a href="DetailServlet?cid=${c.id}">MUA NGAY</a></button>
                        </div>

                    </div>

                </c:forEach>

            </div>
            <h2 class="title-course" >

                <i class="fas fa-book"></i>  Khóa học Hiện có   <i class="fas fa-badge" style="color: gold;"></i>

            </h2>

            <div class="featuredCourse" style="">
                <c:forEach begin="0" end="7" var="c" items="${sessionScope.listCourse}">
                    <c:set var="amount2" value="${c.course_price}" />
                    <%
                        NumberFormat formatter2 = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
                        String formattedAmount2 = formatter2.format((double) pageContext.getAttribute("amount2"));
                    %>
                    <div class="course-Card">
                        <div class="course-picture">
                            <img src="${c.course_img}">
                        </div>
                        <div class="course-details">
                            <h3><a href="DetailServlet?cid=${c.id}">${c.course_name}</a></h3>
                            <div class="sub-details">
                                <p style="color: #333; opacity: 0.5; margin: 0"> By ${c.teacher.teacher_name}</p>
                                <p class="price" style="color: #f05123"> <%= formattedAmount2%></p>
                            </div>
                            <button class="buy-button" type="submit" ><a href="DetailServlet?cid=${c.id}">MUA NGAY</a></button>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>



    </div>

</div>




<%@include file="includes/footer.jsp" %>

</body>
</html>
