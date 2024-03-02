<%-- 
    Document   : left-bar
    Created on : Mar 2, 2024, 2:38:57 PM
    Author     : Desktop
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Thêm một nút để tắt/bật left-bar -->

<style>
    #leftBar {
        position: fixed;
        top: 0;
        left: 0;
        bottom: 0;
        z-index: 900; /* Đảm bảo left-bar nằm trên các phần tử khác */
        width: 250px; /* Điều chỉnh độ rộng của left-bar */
        background-color: #007bff; /* Màu nền của left-bar */
        padding: 20px; /* Khoảng cách giữa các phần tử trong left-bar */
        overflow-y: auto; /* Cho phép cuộn nếu nội dung quá dài */
    }
    #leftBar p{
        font-size: 1rem;
        font-family: sans-serif;
        
    }

    
    
    .but a:hover
    {
        background-color: gray;
        opacity: 0.8;
    }
    #leftBar
    {
        border-radius: 1rem;
    }



</style>
<!-- Định nghĩa left-bar -->
<div id="leftBar" class="tab1  flex-column justify-content-center px-0 col-md-3 bg-primary text-center text-decoration-none gap-3" style="height: 600px; display: flex">
    <c:if test="${ empty auth}">
        <div class="but" style="  margin: 0 50px 0 50px  ">
            <a style="  color: white; text-decoration:none" href="#" class="login-link">
                <i  class="fas fa-user"></i> Login
            </a>
        </div>
        <div class="but"><a style="  color: white;text-decoration:none" href="#" class="register-link"><i class="fas fa-user-plus"></i> Đăng ký</a></div>
    </c:if>
    <c:if test="${auth != null}">
        <div class="but" ><a style="  color: white; text-decoration:none" href="#" > <i class="fas fa-user-circle"></i> Thông tin cá nhân</a></div>
        <div class="but"> <a style="  color: white; text-decoration:none" href="#" > <i class="fas fa-book"></i> Khóa học của tôi</a></div>
        <div class="but"> <a style="  color: white; text-decoration:none" href="#"> <i class="fas fa-wallet"></i> Nạp Tiền</a></div>
        <div class="but"> <a style="  color: white; text-decoration:none" href="#">Log out</a></div>
    </c:if>
</div>


<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function () {
        // Ẩn left-bar mặc định khi trang được tải
        $("#leftBar").hide();

        // Xử lý sự kiện click trên nút tắt/bật left-bar
        $("#toggleLeftBarBtn").click(function () {
            $("#leftBar").toggle();
        });
    });
</script>
