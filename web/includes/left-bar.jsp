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
    .overlay {
    background-color: rgba(0, 0, 0, 0.05); /* Màu nền với độ mờ 50% */
    position: fixed;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    z-index: 500; /* Đảm bảo overlay hiển thị phía trên form */
}
.card{
    position: fixed;
    top: 100px;
    bottom: 100px;
    left: 100px;
    right: 100px;
    z-index: 400; /* Đảm bảo overlay hiển thị phía trên form */
}


</style>
<!-- Định nghĩa left-bar -->
<div id="leftBar" class="tab1  flex-column justify-content-center px-0 col-md-3 bg-primary text-center text-decoration-none gap-3" style="height: 600px; display: flex">
    
    <c:if test="${role == 1}">
        <div class="but" ><a style="  color: white; text-decoration:none" href="#" > <i class="fas fa-user-circle"></i> Thông tin cá nhân</a></div>
        <div class="but"> <a style="  color: white; text-decoration:none" href="#" > <i class="fas fa-book"></i> Khóa học của tôi</a></div>
        <div class="but"> <a style="  color: white; text-decoration:none" href="#"> <i class="fas fa-wallet"></i> Nạp Tiền</a></div>
        <div class="but"> <a style="  color: white; text-decoration:none" href="#">Log out</a></div>
    </c:if>
        <c:if test="${role == 2}">
        <div class="but" ><a style="  color: white; text-decoration:none" href="#" > <i class="fas fa-user-circle"></i> Add new course</a></div>
        <div class="but"> <a style="  color: white; text-decoration:none" href="#" > <i class="fas fa-book"></i> Update Course</a></div>
        <div class="but"> <a style="  color: white; text-decoration:none" href="#"> <i class="fas fa-wallet"></i> Delete Course</a></div>
        <div class="but"> <a style="  color: white; text-decoration:none" href="LogoutServlet">Log out</a></div>
    </c:if>
        <c:if test="${ empty auth}">
        <div class="but" style="  margin: 0 50px 0 50px  ">
            <button class="toggleCloseLoginForm" style=" background-color: transparent;border: none; color: white; text-decoration:none; border-radius: 5px" href="#" class="login-link">
                <i  class="fas fa-user"></i> Login
            </button>
        </div>
        <div class="but"><a style="  color: white;text-decoration:none" href="#" class="register-link"><i class="fas fa-user-plus"></i> Đăng ký</a></div>
    </c:if>
</div>
<div id="logInForm" class="container" >

    <div class="overlay">
        <div class="card w-50 mx-auto my-5" >
            <button class="toggleCloseLoginForm"><i class="fas fa-times"></i></button>
            <div class="card-header text-center"> Login Form</div>
            <div class="card-body">
                <form action="LoginServlet" method="post">
                    <div class="form-group">
                        <label>Email Address</label>
                        <input type="name" name="email" class="form-control" placeholder="Email Adress" required="">
                    </div>
                    <div class="form-group">
                        <label>password</label>
                        <input type="password" name="password" class="form-control" placeholder="password" required="">
                    </div>
                    <div class="text-center">
                        <button class="btn btn-primary" type="submit"> Login</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function () {
        // Ẩn left-bar mặc định khi trang được tải
        $("#leftBar").hide();
        $("#logInForm").hide();

        // Xử lý sự kiện click trên nút tắt/bật left-bar
        $("#toggleLeftBarBtn").click(function () {
            $("#leftBar").toggle();
        });
        $(".toggleCloseLoginForm").click(function () {
            $("#logInForm").toggle();
        });
    });
</script>
