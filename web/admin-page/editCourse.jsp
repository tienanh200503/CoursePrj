<%-- 
    Document   : editCourse
    Created on : Mar 9, 2024, 12:17:32?PM
    Author     : Desktop
--%>

<%@page import="DAO.CourseDAO"%>
<%@page import="model.Course"%>
<%@page import="model.Course"%>
<div id="update-course-form" class="hidden">
    <%
        // Ki?m tra xem request parameter "cid" có t?n t?i hay không
        if (request.getParameter("cid") != null) {
            // N?u t?n t?i, chuy?n ??i "cid" thành s? nguyên và l?y thông tin khóa h?c t? c? s? d? li?u
            int courseId = Integer.parseInt(request.getParameter("cid"));
            Course course = new CourseDAO().getCourseById(courseId);

            // N?u khóa h?c t?n t?i, ??t nó vào thu?c tính yêu c?u "course"
            if (course != null) {
                request.setAttribute("course", course);
            }
        }
    %>
    <div class="overlay">

        <form class="card card-add-form  mx-auto" action="../CourseController" method="GET">
            <div id="update-course-close" style="width: 20%">
                <i class="add-course-button fas fa-times"></i>
            </div>
            <h3 class="form-heading" style="margin-bottom:  0">EditCourse</h3>
            <input type="hidden" name="command" value="UPDATE" />
            <input type="hidden" name="cid" value="${course.getId()}" />
            <div class="form-group">
                <input type="text" name="course_name" placeholder="Course Name" value="${course.course_name}" />
            </div>
            <div class="form-group">
                <input type="text" name="course_time" placeholder="Course Time" value="${course.course_time}" />
            </div>
            <div class="form-group">
                <input type="text" name="teacher_id" placeholder="Teacher_Id" value="${course.teacher.teacher_id}" />
            </div>
            <div class="form-group">
                <input type="text" name="course_price" placeholder="Price" value="${course.course_price}" />
            </div>
            <div class="form-group">
                <textarea name="course_describe" placeholder="Describe"></textarea>
            </div>
            <div class="form-upload">
                <input type="file" name="course_picture" id="course_picture" />
            </div>
            <div class="button-choice" style="text-align: center;">

                <button id="done-course-update" style="width: 20%" type="submit" class="save"><i class="fas fa-save"></i></button>
            </div>

        </form>
    </div>
            
</div>
