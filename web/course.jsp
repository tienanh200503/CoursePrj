<%-- 
    Document   : course
    Created on : Mar 2, 2024, 4:09:14 PM
    Author     : Desktop
--%>

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
    </head>
    <body>
        <%
            if (request.getParameter("sid") != null) {
                // Nếu sid được truyền qua request
                int sid = Integer.parseInt(request.getParameter("sid"));
                SectionDAO sdao = new SectionDAO();
                request.setAttribute("sCurrent", sdao.getSectionById(sid));
            } else {
                // Nếu sid không được truyền qua request, chọn phần tử đầu tiên trong danh sách các phần tử của khóa học
                SectionDAO sdao = new SectionDAO();
                Course c = (Course) request.getAttribute("c");
                if (c != null && c.getSections().size() > 0) {
                    request.setAttribute("sCurrent", c.getSections().get(0));
                } else {
                    // Xử lý trường hợp không có phần tử trong danh sách phần tử của khóa học
                    // Có thể hiển thị một thông báo hoặc thực hiện các hành động khác tùy thuộc vào yêu cầu của ứng dụng.
                    // Ví dụ:
                    // out.println("Không có phần tử nào cho khóa học này.");
                }
            }
        %>
        <%
    // Lấy trạng thái từ session hoặc cơ sở dữ liệu
    int sid = Integer.parseInt(request.getParameter("sid"));
    SectionDAO sdao = new SectionDAO();
    boolean status = sdao.getSectionById(sid).g;
    // Trả về trạng thái dưới dạng một chuỗi JSON
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write("{\"status\": " + status + "}");
%>
        <%@include file="includes/nav.jsp" %>
        <%@include file="includes/left-bar.jsp" %>
        <div  >
            <c:set var="c" value="${c}" />
            <div class="">
                <div class="contain " style="overflow: unset; ">


                    <div class="video"style="width: 80%" ; style="overflow: unset" >
                        <video style="width: 100% ; height: 100%" autoplay="" controls>
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
                                <h2> ${c.sections.get(0).section_name}</h2>

                            </c:when>
                            <c:otherwise>
                                <h2> ${sCurrent.section_name}</h2>

                            </c:otherwise>
                        </c:choose>

                    </div>
                    <div class="list-section" >
                        <div >
                            <div class="s-heading">
                                <h1>
                                    Nội Dung Khóa Học
                                </h1>
                            </div>
                            <div class="s-details">
                                <c:forEach var="s" items="${c.sections}" >
                                    <p>
                                        <a style="color: black; text-decoration: none" href="course.jsp?sid=${s.section_id}">${s.section}: ${s.section_name} </a>
                                    </p>

                                </c:forEach>
                                </p>
                            </div>
                        </div>


                    </div>

                </div>
            </div>
        </div>
        <script>
            var video = document.getElementById('myVideo');
            var status = false;

            // Đợi cho video chạy 5 phút rồi thay đổi trạng thái
            video.addEventListener('timeupdate', function () {
                if (video.currentTime >= 300 && !status) { // 300 giây = 5 phút
                    // Gửi yêu cầu AJAX để lấy trạng thái từ trang JSP
                    var xhr = new XMLHttpRequest();
                    xhr.open('GET', 'course.jsp', true);
                    xhr.onreadystatechange = function () {
                        if (xhr.readyState === 4 && xhr.status === 200) {
                            var response = JSON.parse(xhr.responseText);
                            status = response.status;
                            console.log('Trạng thái từ server: ' + status);
                            // Thực hiện hành động khi video đã xem đủ 5 phút và trạng thái từ server là true
                            if (status) {
                                console.log('Video đã được xem 5 phút và trạng thái từ server là true.');
                            }
                        }
                    };
                    xhr.send();
                }
            });
        </script>
        <%@include file="includes/footer.jsp" %>
    </body>
</html>
