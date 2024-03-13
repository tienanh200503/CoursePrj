<%-- 
    Document   : course
    Created on : Mar 2, 2024, 4:09:14 PM
    Author     : Desktop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="includes/head.jsp" %>
    </head>
    <body>
        <%@include file="includes/nav.jsp" %>
        <%@include file="includes/left-bar.jsp" %>
        <div class=" mx-0 px-0" style="width: 100%" >
            <div class="row mx-0 px-0">
                <div class=" d-flex justify-ítems-center px-0" style="overflow: unset; ">


                    <div class="video  "style="width: 80%" ; style="overflow: unset" >
                        <video style="width: 100% ; height: 100%" autoplay="" controls>
                            <source src="video/video1.mp4" type="video/mp4">
                            <!-- Nếu trình duyệt không hỗ trợ định dạng video/mp4 -->

                        </video>
                        <h2> Cơ bản về C</h2>
                    </div>
                    <div class="bg-secondary " style="width: 20%; padding-top: 40px; position: fixed; right: 0; height: 100% ">
                        <div style="margin-top: 1.5rem">
                            <div class="bg-success" style="border:1px ; border-color: black ; border: solid; text-align: center">
                                <h1>
                                    Nội Dung Khóa Học
                                </h1>
                            </div>
                            <div class="ml-2" style="padding-left:1rem ">
                                <p style="border-bottom: 0.5px ; border-bottom-color: white ; border-bottom:  solid">
                                    <a style="color: black; text-decoration: none" href="#">Bài 1: Cơ bản C++ </a>
                                </p>
                                <p style="border-bottom: 0.5px ; border-color: white ; border-bottom:  solid">
                                    <a style="color: black; text-decoration: none" href="#">Bài 2: Các loại toán tử</a>
                                </p>
                                <p style="border-bottom: 0.5px ; border-color: white ; border-bottom:  solid">
                                    <a style="color: black; text-decoration: none" href="#">Bài 3: Loop</a>
                                </p>
                            </div>
                        </div>


                    </div>

                </div>
            </div>
        </div>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
