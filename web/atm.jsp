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
            .container {
                max-width: 400px;
                margin: 20px auto;
                padding: 20px;
                margin-top: 80px;
                border: 1px solid #ccc;
                border-radius: 5px;
                background-color: #f9f9f9;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            .form-container {
                text-align: center;
               
            }

            .form-container h1 {
                font-size: 24px;
                margin-bottom: 20px;
            }

            .form-container input[type="text"] {
                width: 100%;
                padding: 10px;
                margin-bottom: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
                box-sizing: border-box;
            }

            .form-container button {
                padding: 10px 20px;
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s;
            }

            .form-container button:hover {
                background-color: #45a049;
            }

            /* Định dạng nút khi được nhấn */
            .form-container button:active {
                background-color: #3e8e41;
            }

            .instruction-container {
                margin-top: 20px;
                text-align: justify;
            }

            .instruction-container h2 {
                font-size: 20px;
                margin-bottom: 10px;
            }

            .instruction-container p {
                font-size: 16px;
                line-height: 1.6;
                margin-bottom: 10px;
            }
        </style>
    </head>
    <body>
        <%@include file="includes/nav.jsp" %>
        <%@include file="includes/left-bar.jsp" %>
        <form action="PayServlet" method="POST">
            <div class="container">
                <div class="form-container">
                    <h1>Nạp Tiền</h1>
                    <div>
                        <input type="text" name="atm" placeholder="Nhập số tiền cần nạp">
                        <button>Nạp</button>
                    </div>
                </div>
            </div>


<div class="container">
    <div class="instruction-container">
        <h2>Hướng dẫn nạp tiền:</h2>
        <p>Để nạp tiền vào tài khoản của bạn, vui lòng nhập số tiền bạn muốn nạp vào ô trống bên trên. Sau đó, nhấn vào nút "Nạp".</p>
        <p>Hệ thống sẽ chuyển bạn đến trang thanh toán để hoàn tất giao dịch. Hãy làm theo hướng dẫn trên màn hình để hoàn tất giao dịch nạp tiền.</p>
        <p>Nếu bạn cần hỗ trợ, vui lòng liên hệ tổng đài 24/7 theo số điện thoại )0866715667 hoặc gửi email tới Codecuchuoi.com.</p>
    </div>
</div>

    <%@include file="includes/footer.jsp" %>
</body>

</html>
