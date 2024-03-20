<%-- 
    Document   : addTeacher
    Created on : Mar 17, 2024, 4:27:50?PM
    Author     : Desktop
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="DAO.CourseDAO"%>

<div id="add-course-form" class="hidden" >
    <div class="overlay">
        <form class="card card-add-form mx-auto" action="../TeacherController" method="GET">
            <i id="add-course-close" class="fas fa-times"></i>
            <h3 class="form-heading" style="margin-bottom:  50px; ">Add New Teacher</h3>
            <input type="hidden" name="command" value="ADD" />
            <div class="form-group">
                <input type="text" name="teacher_name" placeholder="Teacher name" value="" />
            </div>




            <div class="button-choice" style="text-align: center;">
                <button style="width: 20%" type="submit" class="save"><i class="fas fa-save"></i></button>
            </div>
        </form>
    </div>
</div>
