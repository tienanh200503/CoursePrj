<%-- 
    Document   : payATM
    Created on : Mar 3, 2024, 1:39:03 AM
    Author     : BIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="includes/head.jsp" %>

        <link href="../css/StyleNav.css" typetext="text/css" rel="stylesheet"/>

        <link rel="stylesheet" href="css/footer.css" type="text/css">


        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f8f8f8;
                margin: 0;
                padding: 0;
            }

            .container {
                margin-top: 100px;


                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                background-color: #f8f8f8;
            }

            .content {
                background-color: #fff;
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                padding: 20px;
                text-align: center;
                max-width: 600px;
                margin: 20px;

            }

            .content h2 {
                font-size: 24px;
                margin-top: 100px;
                color: #333;
            }

            .content h3 {
                font-size: 18px;
                margin-bottom: 10px;
                color: #666;
            }

            .content p {
                font-size: 16px;
                margin-bottom: 10px;
                color: #888;
            }

            .content img {
                max-width: 100%;
                height: auto;
                margin-bottom: 10px;
                border-radius: 5px;
            }
        </style>
    </head>
    <body>
        <%@include file="includes/nav.jsp" %>
        <%@include file="includes/left-bar.jsp" %>
        <form action="payATMServlet">
            <div class="container">
                <div class="content">
                    <h2>Hệ thống tự động 24/24.</h2>
                    <h3>Quý khách vui chuyển khoản với nội dung đúng tài khoản </h3>
                    <p>Sau 15 phút nếu không nhận được tiền tại web liên hệ zalo 00000000 để được hỗ trợ!.<p>
                    <p>Nếu nạp sai cú pháp sẽ xử lý trong vòng 24h.</p>
                    <img src="image/pay.jpg" alt="Payment Instructions"/>
                </div>
            </div>
        </form>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
