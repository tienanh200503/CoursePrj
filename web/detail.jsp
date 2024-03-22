<%-- 
    Document   : detail
    Created on : Mar 2, 2024, 8:55:10 PM
    Author     : BIN
--%>

<%@page import="model.Course"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="DAO.OrderDAO"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="includes/head.jsp" %>

          <link rel="stylesheet" href="css/footer.css" type="text/css">

        <link rel="stylesheet" href="css/footer.css" type="text/css">

        <title>JSP Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f8f8f8;
            }

            .container {
                display: flex;
                justify-content: center;
                align-items: flex-start;
                padding: 20px;
            }

            .course-detail {
                background-color: #fff;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                padding: 20px;
                max-width: 800px;
                width: 100%;
            }

            .course-detail h1 {
                font-size: 50px;
                margin-bottom: 10px;
                text-align: center;
                margin-top: 5px;
                padding-top: 20px;
            }


            .course-detail img {
                display: block;
                margin: 0 auto 20px;
                max-width: 100%;
                border-radius: 5px;
            }

            .sessions {
                background-color: #f0f0f0;
                border-radius: 5px;
                padding: 10px;
                margin-bottom: 20px;
            }

            .session {
                margin: 0;
                padding: 0;
                list-style: none;
            }

            .session-link {
                display: block;
                padding: 5px 10px;
                margin-bottom: 5px;
                background-color: #e0e0e0;
                border-radius: 5px;
                text-decoration: none;
                color: #333;
                transition: background-color 0.3s ease;
            }

            .session-link:hover {
                background-color: #ccc;
            }

            .details {
                padding: 20px;
                background-color: #f8f8f8;
                border-radius: 5px;
            }

            .details h2 {
                font-size: 20px;
                margin-bottom: 10px;
                text-align: center;
            }

            .details dl {
                display: grid;
                grid-template-columns: auto 1fr;
                gap: 10px;
            }

            .details dt {
                font-weight: bold;
            }

            .details dd {
                margin: 0;
            }

            .buy-button {
                display: flex;
                justify-content: center;
                margin-top: 10px;
            }

            .buy-button button a {
                color: black; /* Đặt màu chữ thành đen */
                text-decoration: none; /* Loại bỏ gạch chân */
            }

            .buy-button button {
                padding: 10px 20px;
                font-size: 18px;
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            .buy-button button:hover {
                background-color: #0056b3;
            }

            @media only screen and (max-width: 768px) {
                .container {
                    flex-direction: column;
                    align-items: center;
                }

                .course-detail {
                    width: 90%;
                }
            }
        </style>

    </head>
    
    <%@include file="includes/nav.jsp" %>
    <%@include file="includes/left-bar.jsp" %>
    <body>

        <div class="container">
            <%
                int uid = 0;
                String uidString = request.getParameter("uid");
                if (uidString != null && !uidString.isEmpty()) {
                    uid = Integer.parseInt(uidString);
                }
                HttpSession sessions = request.getSession();
                sessions.setAttribute("uid", uid);
            %>
            <c:set var="amount" value="${detail.course_price}"/>
            <%
                NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
                String price = formatter.format((double) pageContext.getAttribute("amount"));
            %>
            <div class="course-detail">
                <h1>${detail.getCourse_name()}</h1>
                <img src="${detail.getCourse_img()}" alt="Course Image"/>

                <div class="sessions">
                    <h2>Section</h2>
                    <ul class="session">
                        <c:forEach var="section" items="${detail.sections}">
                            <li class="session-link"> ${section.section} : ${section.section_name}</li>
                            </c:forEach>
                    </ul>
                </div>

                <div class="details">
                    <h2>Details</h2>
                    <dl>
                        <dt>Heading:</dt>
                        <dd>${detail.getCourse_name()}</dd>

                        <dt>Mô tả:</dt>
                        <dd>${detail.getCourseDescribe()}</dd>

                        <dt>Tên giáo viên:</dt>
                        <dd>${detail.getTeacher().getTeacher_name()}</dd>

                        <dt>Thời lượng:</dt>
                        <dd>${detail.getCourse_time()}h</dd>

                        <dt>Số bài học:</dt>
                        <dd>${detail.getSections().size()}</dd>

                        <dt>Giá:</dt>
                        <dd><%= price%></dd>
                    </dl>
                </div>

                <div class="buy-button">
                    <c:set var="id" value="${detail.id}"/>
                    <%
                        int id = Integer.parseInt(String.valueOf(pageContext.findAttribute("id")));
                        OrderDAO odao = new OrderDAO();
                        List<Course> course = odao.getCourseId(uid);
                        boolean bought = false; // Biến để kiểm tra xem người dùng đã mua hay chưa
                        for (Course i : course) {
                            if (i.getId() == id) {
                                bought = true;
                                break; // Người dùng đã mua, không cần kiểm tra các khóa học khác
                            }
                        }
                        if (bought) {
                    %>
                    <button type="submit" class="buy-button-link"><a href="StudyServlet?cid=${detail.getId()}">Học Ngay</a></button>
                    <%
                    } else {
                        if (uid == 0) {
                    %>
                    <button type="button" class="buy-button-link" onclick="window.location.href = 'login.jsp'">Buy now</button>
                    <%
                    } else {
                    %>
                    <button type="submit" class="buy-button-link"><a href="buy.jsp?uid=${uid}&cid=${detail.getId()}">Buy now</a></button>
                    <%
                            }
                        }
                    %>
                </div>

            </div>
        </div>

        <%@include file="includes/footer.jsp" %>
    </body>
</html>
