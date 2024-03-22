<%-- 
    Document   : course
    Created on : Mar 2, 2024, 4:09:14 PM
    Author     : Desktop
--%>

<%@page import="DAO.CourseDAO"%>
<%@page import="model.Section"%>
<%@page import="model.Course"%>
<%@page import="DAO.SectionDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="includes/head.jsp" %>
        <link rel="stylesheet" href="css/footer.css" type="text/css">
        <link rel="stylesheet" href="css/course/course.css" type="text/css">
        <link rel="stylesheet" href="css/course/course1.css" type="text/css">
    </head>
    <body>
        <%
            SectionDAO sdao = new SectionDAO();
            int cid = Integer.parseInt(request.getParameter("cid"));
            String sid = request.getParameter("sid");


        %>

        <%@include file="includes/nav.jsp" %>
        <%@include file="includes/left-bar.jsp" %>
        <div>

            <div class="">
                <div class="contain" style="overflow: unset;">
                    <div class="video" style="width: 70%; overflow: unset;">
                        <video id="myVideo" style="width: 100%; height: 100%;" autoplay="" controls>
                            <c:choose>
                                <c:when test="${sCurrent == null}">
                                    <source src="${c.sections.get(0).section_video}" type="video/mp4"/>
                                </c:when>
                                <c:otherwise>
                                    <source src="${sCurrent.section_video}" type="video/mp4"/>
                                </c:otherwise>
                            </c:choose>
                        </video>
                        <c:choose>
                            <c:when test="${sCurrent == null}">
                                <h2>${c.sections.get(0).section_name}</h2>
                            </c:when>
                            <c:otherwise>
                                <h2>${sCurrent.section_name}</h2>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="list-section">
                        <div>
                            <div class="s-heading">
                                <h3 style="margin-bottom: 0">Nội Dung Khóa Học</h3>
                            </div>
                            <div class="s-details" >
                                <c:forEach var="s" items="${c.sections}">

                                    <c:choose>
                                        <c:when test="${s.status == true}">
                                            <div class="lesson" style="display:flex ; background-color: ${sCurrent.section_id== s.section_id ?"rgba(231, 76, 60, 0.5)":""}">
                                                <div  style="width: 70%">
                                                    <a style=" font-size: 1rem;color: black; text-decoration: none; text-wrap: nowrap" href="StudyServlet?sid=${s.section_id}&cid=<%=cid%>" >${s.section}: ${s.section_name}</a>

                                                </div>
                                                <span class="success-icon" style="color: white; background-color: #008000; position: absolute; /* Màu xanh */
                                                      font-size: 16px; border-radius: 100%; /* Kích thước */">&#10004;</span>
                                                      
                                            </div>
                                        </c:when>
                                        <c:otherwise >
                                            <div style=" background-color: ${sCurrent.section_id== s.section_id ?"rgba(231, 76, 60, 0.5)":""}; text-wrap: none" class="lesson"><a style=" font-size: 1rem ;color: black; text-decoration: none" href="StudyServlet?sid=${s.section_id}&cid=<%=cid%>">${s.section}: ${s.section_name}</a></div>

                                        </c:otherwise>
                                    </c:choose>


                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
            var video = document.getElementById("myVideo");
            var status = false;
            console.log(video.currentTime);
            console.log("Thời gian hiện tại của video: " + video.currentTime);
// Đợi cho video chạy ít nhất 10 giây rồi thay đổi trạng thái
            video.addEventListener('timeupdate', function () {
                console.log("Thời gian hiện tại của video: " + video.currentTime);
                if (video.currentTime >= 3 && status != true) { // Kiểm tra khi nào video đã chạy ít nhất 10 giây và trạng thái vẫn là false
                    var xhr = new XMLHttpRequest();
                    var params ='cid='+getParameterByName('cid')+ '&sid=' + getParameterByName('sid') + '&currentTime=' + video.currentTime + '&status=' + status;
                    xhr.open('GET', 'StudyServlet?' + params, true);

                    xhr.onreadystatechange = function () {
                        if (xhr.readyState === 4) {

                            status = true;
                            console.log('Trạng thái từ server: ' + status);
                            if (status) {
                                console.log('Video đã được chạy ít nhất 10 giây và trạng thái từ server là true.');
                                // Thực hiện các hành động khác nếu cần thiết
                            }
                        } else {
                            console.log('Yêu cầu AJAX không thành công.');
                        }
                    };
                    xhr.send();
                }
            }); // Dấu ngoặc ở đây không cần thiết
            function getParameterByName(name, url) {
                if (!url)
                    url = window.location.href;
                name = name.replace(/[\[\]]/g, '\\$&');
                var regex = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)'),
                        results = regex.exec(url);
                if (!results)
                    return null;
                if (!results[2])
                    return '';
                return decodeURIComponent(results[2].replace(/\+/g, ' '));
            }

            // Lấy giá trị của tham số "sid" từ URL
            var sectionId = getParameterByName('sid');

            // In ra console để kiểm tra
            console.log("Giá trị của tham số 'sid': " + sectionId);
        </script>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
