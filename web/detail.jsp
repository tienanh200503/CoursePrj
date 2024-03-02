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
<body>
    <%@include file="includes/nav.jsp" %>
    <%@include file="includes/left-bar.jsp" %>
    
    <div class="container">
        <div class="course-detail">
            <h1>Course Name</h1>
            <img src="image/image1.jpg" alt="Course Image"/>

            <div class="sessions">
                <h2>Sessions</h2>
                <ul class="session">
                    <li><a href="#" class="session-link">Bài 1: Cơ bản C++</a></li>
                    <li><a href="#" class="session-link">Bài 2: Các loại toán tử</a></li>
                    <li><a href="#" class="session-link">Bài 3: Loop</a></li>
                </ul>
            </div>

            <div class="details">
                <h2>Details</h2>
                <dl>
                    <dt>Heading:</dt>
                    <dd>Heading content</dd>

                    <dt>Mô tả:</dt>
                    <dd>Mô tả content</dd>

                    <dt>Tên giáo viên:</dt>
                    <dd>Tên giáo viên content</dd>

                    <dt>Thời lượng:</dt>
                    <dd>Thời lượng content</dd>

                    <dt>Số bài học:</dt>
                    <dd>Số bài học content</dd>
                </dl>
            </div>

            <div class="buy-button">
                <button>Buy now</button>
            </div>
        </div>
    </div>

    <%@include file="includes/footer.jsp" %>
</body>
</html>
