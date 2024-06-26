<%-- 
    Document   : left-bar
    Created on : Mar 2, 2024, 2:38:57 PM
    Author     : Desktop
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Thêm một nút để tắt/bật left-bar -->

<style>
    #leftBar {
        position: fixed;
        top: 60px;
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
        background-color: rgba(0, 0, 0, 0.5); /* Màu nền với độ mờ 50% */
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
        <div class="but" ><a style="  color: white; text-decoration:none" href="InforServlet?uid=${auth.id}"> <i class="fas fa-user-circle"></i> Thông tin cá nhân</a></div>

        <div class="but"> <a style="  color: white; text-decoration:none" href="myCourseServlet?status=0&uid=${auth.id}" > <i class="fas fa-book"></i> Khóa học của tôi</a></div>

        <div class="but"> <a style="  color: white; text-decoration:none" href="atm.jsp?uid=${auth.id}"> <i class="fas fa-wallet"></i> Nạp Tiền</a></div>
        <div class="but"> <a style="  color: white; text-decoration:none" href="http://localhost:8080/PRJProjectFinal/LogoutServlet">Log out</a></div>
    </c:if>
    <c:if test="${role == 2}">
        <div class="but" ><a style="  color: white; text-decoration:none" href="http://localhost:8080/PRJProjectFinal/CourseController" > <i class="fas fa-user-circle"></i> Course</a></div>
        <div class="but"> <a style="  color: white; text-decoration:none" href="http://localhost:8080/PRJProjectFinal/SectionServlet" > <i class="fas fa-book"></i> Section</a></div>
        <div class="but"> <a style="  color: white; text-decoration:none" href="http://localhost:8080/PRJProjectFinal/TeacherController"> <i class="fas fa-wallet"></i> Teacher</a></div>

        <div class="but"> <a style="  color: white; text-decoration:none" href="http://localhost:8080/PRJProjectFinal/LogoutServlet">Log out</a></div>
    </c:if>
    <c:if test="${ empty auth}">
        <div class="but" style="  margin: 0 50px 0 50px  ">
            <button class="toggleCloseLoginForm" style=" background-color: transparent;border: none; color: white; text-decoration:none; border-radius: 5px" href="#" class="login-link">
                <i  class="fas fa-user"></i> Login
            </button>
        </div>
        <div class="but"><a style="  color: white;text-decoration:none" href="signUp" class="register-link"><i class="fas fa-user-plus"></i> Đăng ký</a></div>
    </c:if>
</div>
<div id="logInForm" class="container" style="display: none" >

    <div class="overlay">
        <div class="card mx-auto my-5"  style="width: 25%">
            
            <div class="card-header text-center"> Login Form</div>
            <div class="card-body">
                <form action="LoginServlet" method="post">
                    <div class="form-group" style="display: flex; justify-items: center ;justify-content: center;margin-bottom: 20px">

                        <div style="background-color: rgb(233, 236, 239); padding: 0 10px 0 10px"><i class="fas fa-user" style="line-height: 50px; color: #333"></i></div> <input type="text" name="username" class="form-control" placeholder="UserName" required="">
                    </div>
                    <div class="form-group" style="display: flex; margin-bottom: 20px" >

                        <div style="background-color: rgb(233, 236, 239); padding: 0 10px 0 10px">                        
                            <i class="fas fa-lock"style="line-height: 50px; color: #333"></i>
                        </div>
                        <input type="password" name="password" class="form-control" placeholder="password" required="">
                    </div>
                    <div class="text-center">
                        <button class="btn btn-primary" type="submit"> Login</button>
                        <button class="toggleCloseLoginForm btn btn-primary"> Cancel</button>
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
//       
        if (localStorage.getItem('updateCourseFormVisible') === 'true') {
            $("#update-course-form").show();
        } else {
            $("#update-course-form").hide();
        }

        // Function to toggle update course form visibility
        function toggleUpdateCourseForm() {
            $("#update-course-form").toggle();
            localStorage.setItem('updateCourseFormVisible', $("#update-course-form").is(":visible"));
        }


        // Xử lý sự kiện click trên nút cập nhật khóa học

        // Function to toggle left bar visibility
        function toggleLeftBar() {
            $("#leftBar").toggle();
        }
//
        // Function to toggle login form visibility
        function toggleLoginForm() {
            $("#logInForm").toggle();
        }
//
//        // Function to toggle add course form visibility
        function toggleAddCourseForm() {
            $("#add-course-form").toggle();
        }
//
//
//        // Xử lý sự kiện click trên nút tắt/bật left-bar
        $("#toggleLeftBarBtn").click(function () {
            toggleLeftBar();
        });
//
//        // Xử lý sự kiện click trên nút tắt/bật login form
        $(".toggleCloseLoginForm").click(function () {
            toggleLoginForm();
        });
//
//        // Xử lý sự kiện click trên nút thêm khóa học
        $("#add-course-button").click(function () {
            toggleAddCourseForm();
        });
        $("#add-course-close").click(function () {
            toggleAddCourseForm();
        });
//
        $(".update-course-button").click(function () {
            toggleUpdateCourseForm();
        });
        $("#update-course-close").click(function () {
            toggleUpdateCourseForm();
        });
        $("#done-course-update").click(function () {
            toggleUpdateCourseForm();
        });
//
    });




</script>
