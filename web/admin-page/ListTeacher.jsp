<%-- 
    Document   : ListTeacher
    Created on : Mar 17, 2024, 3:46:02 PM
    Author     : Desktop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="../includes/head.jsp" %>
        <link href="../css/admin/sectionAdmin.css" typetext="text/css" rel="stylesheet"/>
        <link rel="stylesheet" href="css/my-course/footer.css" type="text/css">
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
                        Teacher Name
                    </th>
                    <th>
                        Action
                    </th>

                </tr>

            </thead>
            <tbody>
                <c:forEach var="t" items="${teacherList}">


                    <c:url var="deleteLink" value="../TeacherController">
                        <c:param name="command" value="DELETE"></c:param>
                        <c:param name="tid" value="${t.teacher_id}"></c:param>
                    </c:url>

                    <tr>
                         <td>${t.teacher_id}</td>
                        <td>${t.teacher_name}</td>





                        <td>

                            <a class="update-course-button" href="ListTeacher.jsp?tid=${t.teacher_id}" onclick="event.handleLinkClick(event);"> <i class="fas fa-edit"></i></a>


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
        <%@include file="addTeacher.jsp" %>
        <%@include file="editTeacher.jsp" %>
        <%@include file="../includes/footer.jsp" %>

    </body>
</html>

