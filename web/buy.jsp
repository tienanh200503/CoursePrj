<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@include file="includes/head.jsp" %>
    <title>JSP Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f8f8;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .confirmation-container {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            max-width: 800px;
            width: 100%;
            text-align: center;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .confirmation-container h3 {
            margin-bottom: 20px;
        }

        .button-container {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 20px;
        }

        .confirmation-container button {
            margin: 0 10px;
            padding: 10px 20px;
            font-size: 18px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .confirmation-container button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="confirmation-container">
    <h3>Bạn có chắc chắn muốn thực hiện mua khóa học này?</h3>
    <div class="button-container">
        <%
            int cid = Integer.parseInt(request.getParameter("cid"));
            HttpSession sessions = request.getSession();
            sessions.setAttribute("cid", cid);
        %>
        <form action="PayCourseServlet" method="get">
            <input type="hidden" name="cid" value="<%= cid%>">
            <button type="submit" name="confirm" value="confirm">Xác nhận</button>
        </form>
        <button onclick="window.history.back()">Hủy bỏ</button>
    </div>
</div>
</body>
</html>
