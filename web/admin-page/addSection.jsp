<%-- 
    Document   : addSection
    Created on : Mar 17, 2024, 1:09:56?PM
    Author     : Desktop
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="DAO.CourseDAO"%>
<% 
    CourseDAO cdao = new CourseDAO();
    request.getSession().setAttribute("courses", cdao.getAllCourse());
%>
<div id="add-course-form" class="hidden" >
    <div class="overlay">
        <form class="card card-add-form mx-auto" action="../SectionServlet" method="GET">
            <i id="add-course-close" class="fas fa-times"></i>
            <h3 class="form-heading">Add New section</h3>
            <input type="hidden" name="command" value="ADD" />
            <input type="hidden" name="status" value="false" />
            <div class="form-group">
                <input type="text" name="section" placeholder="Bài" value="" />
            </div>

            <div class="form-group">
                <input type="text" name="section_name" placeholder="Tên bài" value="" />
            </div>
            <div class="form-group">
                <select class="form-group" name="c_id">
                <c:forEach var="c" items="${courses}">
                    <option value="${c.id}">${c.course_name}</option>
                </c:forEach>
                

            </select>
            </div>
           
            <div class="form-upload">
                <input type="file" name="video" id="course_picture" class="upload-input" placeholder="Ch?n file này">
                
            </div>
             
            <div class="button-choice" style="text-align: center;">
                <button style="width: 20%" type="submit" class="save"><i class="fas fa-save"></i></button>
            </div>
        </form>
    </div>
</div>
