<%-- 
    Document   : detail
    Created on : Mar 2, 2024, 8:55:10 PM
    Author     : BIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            margin: 0;
            padding: 0;
        }

        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f8f8f8;
        }

        .form-container {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            text-align: center;
        }

        .form-container h1 {
            font-size: 24px;
            margin-bottom: 20px;
        }

        .form-container input[type="text"] {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-right: 10px;
            width: 200px;
        }

        .form-container button {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .form-container button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <%@include file="includes/nav.jsp" %>
    <%@include file="includes/left-bar.jsp" %>
    
    <div class="container">
        <div class="form-container">
            <h1>Nạp Tiền</h1>
            <div>
                <input type="text" name="atm" placeholder="Nhập số tiền cần nạp">
                <button>Nạp</button>
            </div>
        </div>
    </div>

    <%@include file="includes/footer.jsp" %>
</body>
</html>
