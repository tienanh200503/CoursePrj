<%-- 
    Document   : addCourse
    Created on : Mar 9, 2024, 9:32:09?AM
    Author     : Desktop
--%>

<%@page import="DAO.TeacherDAO"%>
<% 
    TeacherDAO tdao = new TeacherDAO();
    request.getSession().setAttribute("teachers", tdao.getAllTeacher());
%>
<div id="add-course-form" class="hidden" >
    <div class="overlay">
        <form class="card card-add-form mx-auto" action="../CourseController" method="GET" style="transition: ease-in 0.5s">
            <i id="add-course-close" class="fas fa-times"></i>
            <h3 class="form-heading">Add New Course</h3>
            <input type="hidden" name="command" value="ADD" />

            <div class="form-group">
                <input type="text" name="course_name" placeholder="Course Name" value="" />
            </div>

            <div class="form-group">
                <input type="text" name="course_time" placeholder="Course Time" value="" />
            </div>

            <div class="form-group">
                <select class="form-group" name="teacher_id">
                <c:forEach var="t" items="${teachers}">
                    <option value="${t.teacher_id}">${t.teacher_name}</option>
                </c:forEach>
                

            </select>
                </div>
            <div class="form-group">
                <input type="text" name="course_price" placeholder="Price" value="" />
            </div>

            <div class="form-group">
                <textarea name="course_describe" placeholder="Describe"></textarea>
            </div>
            <div class="form-upload">
                <input type="file" name="course_picture" id="course_picture" class="upload-input" placeholder="Ch?n file này">
                
            </div>
             
            <div class="button-choice" style="text-align: center;">
                <button style="width: 20%" type="submit" class="save"><i class="fas fa-save"></i></button>
            </div>
        </form>
    </div>
</div>



