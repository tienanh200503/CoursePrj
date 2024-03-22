<%-- 
    Document   : listSection
    Created on : Mar 16, 2024, 11:32:37 PM
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

        <link href="../css/StyleNav.css" typetext="text/css" rel="stylesheet"/>


    </head>
    <body>
        <%@include file="../admin/AdminNav.jsp" %>

        <%@include file="../includes/left-bar.jsp" %>
        <table class="table-course" border="1">
            <thead class="thead-form" style="background-color: #0d6efd;">
                <tr>
                    <th>
                        ID
                    </th>
                    <th>
                        Bài
                    </th>
                    <th>
                        C_ID
                    </th>
                    <th>
                        Section name
                    </th>
                    <th>
                        video
                    </th>
                    <th>
                        Action
                    </th>

                </tr>

            </thead>
            <tbody>
                <c:forEach var="s" items="${sectionList}">


                    <c:url var="deleteLink" value="../SectionServlet">
                        <c:param name="command" value="DELETE"></c:param>
                        <c:param name="sid" value="${s.section_id}"></c:param>
                    </c:url>

                    <tr>
                        <td>${s.section_id}</td>
                        <td>${s.section}</td>
                        <td>${s.c_id}</td>

                        <td>${s.section_name}</td>
                        <td>${s.section_video}</td>




                        <td>

                            <a class="update-course-button" href="listSection.jsp?sid=${s.getSection_id()}" onclick="event.handleLinkClick(event);"> <i class="fas fa-edit"></i></a>


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
        <%@include file="addSection.jsp" %>
        <%@include file="editSection.jsp" %>


    </body>
</html>
