<%-- 
    Document   : left-bar
    Created on : Mar 2, 2024, 2:38:57 PM
    Author     : Desktop
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Thêm một nút để tắt/bật left-bar -->


<!-- Định nghĩa left-bar -->
<div id="leftBar" class="tab1  flex-column justify-content-center px-0 col-md-3 bg-primary text-center text-decoration-none gap-3" style="height: 600px; display: flex">
    <c:if test="${ empty auth}">
        <h4><a href="#" class="text-dark text-decoration-none">login</a></h4>
        <h4><a href="#" class="text-dark">Register</a></h4>
    </c:if>
    <c:if test="${auth != null}">
        <h4><a href="#" class="text-dark text-decoration-none">Thông tin cá nhân</a></h4>
        <h4> <a href="#" class="text-dark text-decoration-none">Khóa học của tôi</a></h4>
        <h4> <a href="#"class="text-dark text-decoration-none">Nạp Tiền</a></h4>
        <h4> <a href="#"class="text-dark text-decoration-none">Log out</a></h4>
    </c:if>
</div>
        

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function(){
    // Ẩn left-bar mặc định khi trang được tải
    $("#leftBar").hide();
    
    // Xử lý sự kiện click trên nút tắt/bật left-bar
    $("#toggleLeftBarBtn").click(function(){
        $("#leftBar").toggle();
    });
});
</script>
