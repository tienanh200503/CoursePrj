<%-- 
    Document   : editTeacher
    Created on : Mar 17, 2024, 4:32:19?PM
    Author     : Desktop
--%>

<%@page import="DAO.TeacherDAO"%>
<%@page import="model.Teacher"%>
<div id="update-course-form" class="hidden">
    <%
        // Ki?m tra xem request parameter "cid" có t?n t?i hay không
        if (request.getParameter("tid") != null) {
            // N?u t?n t?i, chuy?n ??i "cid" thành s? nguyên và l?y thông tin khóa h?c t? c? s? d? li?u
            int tid = Integer.parseInt(request.getParameter("tid"));
            Teacher teacher = new TeacherDAO().getTeacherById(tid);

            // N?u khóa h?c t?n t?i, ??t nó vào thu?c tính yêu c?u "course"
            if (teacher != null) {

                request.setAttribute("teacher", teacher);
            }
        }
    %>
    <div class="overlay">

        <form class="card card-add-form  mx-auto" style="height: 50%; width: 30%" action="../TeacherController" method="GET">
            <div id="update-course-close" style="width: 20%">
                <i class="add-course-button fas fa-times"></i>
            </div>
            <h3 class="form-heading" style="margin-bottom:  50px; ">Edit teacher</h3>
            <input type="hidden" name="command" value="UPDATE" />
            <input type="hidden" name="tid" value="${teacher.teacher_id}" />

            <div class="form-group">
                <input type="text" name="teacher_name" placeholder="Teacher Name" value="${teacher.teacher_name}" />
            </div>



            <div class="button-choice" style="text-align: center;">
                <button id="done-course-update" style="width: 20%" type="submit" class="save"><i class="fas fa-save"></i></button>
            </div>

        </form>
    </div>

</div>



