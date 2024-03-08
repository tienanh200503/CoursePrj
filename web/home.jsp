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
        <script>
            function formatCurrency(amount) {
                // Định dạng số tiền
                var formattedAmount = new Intl.NumberFormat('vi-VN', {style: 'currency', currency: 'VND'}).format(amount);

                return formattedAmount;
            }
        </script>
    </head>

    <body>

        <%@include file="includes/nav.jsp" %>
        <%@include file="includes/left-bar.jsp" %>
        <div class="contain" style="margin-top: 100px">


            <h2>
                Khóa học nổi bật
            </h2>

            <div class="featuredCourse" style="">
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
                            <h3><a href="#">${c.course_name}</a></h3>


                            <div class="sub-details">


                                <p style="color: #333;opacity: 0.5; margin: 0"> By ${c.teacher.teacher_name}</p>

                                <p  class="price"style="color: #f05123"> <%= formattedAmount%></p>




                            </div>
                            <button class="buy-button" type="submit" >MUA NGAY</button>
                        </div>

                    </div>

                </c:forEach>

            </div>
            
           
        </div>




        <%@include file="includes/footer.jsp" %>

    </body>
</html>
