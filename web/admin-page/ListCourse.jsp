<%-- 
    Document   : ListCourse
    Created on : Mar 9, 2024, 3:40:56 AM
    Author     : Desktop
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="../includes/head.jsp" %>
        <link href="../css/admin/AdminStyle.css" typetext="text/css" rel="stylesheet"/>
    </head>
    <body>
        <%@include file="../includes/nav.jsp" %>
        <%@include file="../includes/left-bar.jsp" %>
        <table class="table-course" border="1">
            <thead class="thead-form" style="background-color: #0d6efd;">
                <tr>
                    <th>
                        ID
                    </th>
                    <th>
                        Name
                    </th>
                    <th>
                        time
                    </th>
                    <th>
                        Teacher
                    </th>
                    <th>
                        price
                    </th>

                    <th>
                        Describe
                    </th>
                    <th>
                        picture
                    </th>
                    <th>
                        Action
                    </th>
                </tr>

            </thead>
            <tbody>
                <c:forEach var="c" items="${courseList}">
                    <c:url var="tempLink" value="../CourseController">
                        <c:param name="command" value="LOAD"></c:param>
                        <c:param name="cid" value="${c.getId()}"></c:param>
                    </c:url>

                    <c:url var="deleteLink" value="../CourseController">
                        <c:param name="command" value="DELETE"></c:param>
                        <c:param name="cid" value="${c.getId()}"></c:param>
                    </c:url>

                    <tr>
                        <td>${c.id}</td>
                        <td>${c.course_name}</td>
                        <td>${c.course_time}</td>
                        <td>${c.teacher.teacher_name}</td>
                        <td>${c.course_price}</td>
                        <td>${c.courseDescribe}</td>
                        <td>${c.course_img}</td>


                        <td>

                            <a class="update-course-button" href="ListCourse.jsp?cid=${c.getId()}" onclick="event.handleLinkClick(event);"> <i class="fas fa-edit"></i></a>


                            <c:if test="${not empty deleteLink}">
                                <a href="${deleteLink}" onclick="if (!(confirm('Sure?')))
                                            return false"><i class="fas fa-trash-alt"></i></a>
                                </c:if>

                        </td>

                    </tr>
                </c:forEach>
                <tr>
                    <td>
                        <i id="add-course-button"  class=" fas fa-plus"></i>
                    </td>
                </tr>





            </tbody>

        </table>
        <%@include file="addCourse.jsp" %>
        <%@include file="editCourse.jsp" %>
        <%@include file="../includes/footer.jsp" %>
        
    </body>
</html>
