<%-- 
    Document   : information
    Created on : Mar 2, 2024, 10:20:24 PM
    Author     : Desktop
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="includes/head.jsp" %>
        
        <link rel="stylesheet" href="css/nav.css" type="text/css">

        <link rel="stylesheet" href="css/information/styleInfor.css" type="text/css">
        <link rel="stylesheet" href="css/footer.css" type="text/css">


        <style>


            .con{
                padding: 4rem 0 4rem 0;
                display: flex;
                gap: 3rem;
                color: black;
                background-color: rgba(255, 255, 255, 0.9);
            }
            .infor
            {
                display: flex;
                margin: 5px 5px 5px 5px;
                justify-items: center;
                flex-direction: column;
                /*    border: 1px black solid;*/
                box-shadow: 1px 1px 3px gray;
                border-radius: 1rem;

                background-color: white;
                height: 40%;
                width: 40%;

            }
            .tab2
            {
                padding: 20px;
                box-shadow: 1px 1px 3px gray;
                width: 60%;
                border-radius: 20px;
            }
            .card div
            {
                width: 50%;
            }
            .card-infor
            {
                display: flex;
                gap: 5px;
                margin-bottom: 10px;
                background-color:honeydew ;
                border-radius: 1rem;

            }
            .card-infor div img
            {
                width: 100%;
                height: 20vh;

                border-radius: 1rem;
            }
            .tab-infor
            {
                margin-top: 4rem;
                width: 300px;

            }
            .tab-infor div
            {
                margin: 5px 5px 5px 5px;
                justify-items: center;
                /*    border: 1px black solid;*/
                box-shadow: 1px 1px 3px gray;
                border-radius: 1rem;
            }

            .sub-infor
            {
                margin-top: 10px;
                margin-left: 10px
            }

            body::before {
                content: "";
                position: absolute;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background-color: rgba(0, 0, 0, 0.05); /* Màu nền với độ mờ 50% */
                z-index: -1;
            }
            .sub-card1
            {
                width: 40%;
                padding: 5px 0 5px 5px;

            }
            .sub-card2
            {
                width: 60%;
                border-left: 0.5px goldenrod solid;
                border-radius: 10px;

            }
            .sub-card2 p ,h4
            {
                margin-left: 20px;
            }
            .sub-card2 h4{
                margin-top: 10px;
                font-family: Verdana, Geneva, sans-serif;
            }
            .sub-card2 a{
                text-decoration: none;
                color: black;
            }



            .con
            {
                border-radius: 20px;
                margin: 100px 100px 0 100px;

            }
        </style>
    </head>
    <body>
        <%@include file="includes/nav.jsp" %>
        <%@include file="includes/left-bar.jsp" %>



        <div class="con">

            <div class="infor" >
                <div class="sub-infor">
                    <h6>
                        Thông tin cá nhân
                    </h6>
                    <p> 
                        <i style="color: #0d6efd" class="fas fa-user"></i> ${acc.username}
                    </p>
                    <p> <i class="fas fa-envelope fa-lg" style="color: #0d6efd;"></i> ${acc.email}</p>
                    <c:set var="amount" value="${acc.money}" /> 
                    <%
                        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
                        String formattedAmount = formatter.format((double) pageContext.getAttribute("amount"));
                    %>
                    <div style="display: flex; gap: 5px">
                        <p><i style="color: #0d6efd;" class="fas fa-money-bill"></i>
                        </p>
                        <p><%= formattedAmount%></p>
                    </div>
                </div>




            </div>
            <div class="tab2">
                <h3 style="font-family: sans-serif">Khóa học đã tham gia</h3>
                <c:forEach var="i" items="${course}">
                    <div class="card-infor">
                        <div class="sub-card1">
                            <img src="${i.course_img}">
                        </div>
                        <div class="sub-card2">
                            <h4><a href="StudyServlet?uid=${acc.id}&cid=${i.id}">${i.course_name}</a></h4>
                            <p>${i.courseDescribe}</p>
                        </div>
                    </div>
                </c:forEach>

            </div>
        </div>

        <%@include file="includes/footer.jsp" %>
    </body>
</html>
