<%-- 
    Document   : editSection
    Created on : Mar 17, 2024, 2:05:24?PM
    Author     : Desktop
--%>

<%@page import="DAO.CourseDAO"%>
<%@page import="DAO.SectionDAO"%>
<%@page import="model.Section"%>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<div id="update-course-form" class="hidden" >
    <%
        // Ki?m tra xem request parameter "cid" có t?n t?i hay không
        if (request.getParameter("sid") != null) {
            // N?u t?n t?i, chuy?n ??i "cid" thành s? nguyên và l?y thông tin khóa h?c t? c? s? d? li?u
            int sid = Integer.parseInt(request.getParameter("sid"));
            Section section = new SectionDAO().getSectionById(sid);
            
           
            
            // N?u khóa h?c t?n t?i, ??t nó vào thu?c tính yêu c?u "course"
            if (section != null) {
                request.setAttribute("course", new CourseDAO().getCourseById(section.getC_id()));
                request.setAttribute("section", section);
            }
        }
    %>
    <div class="overlay">

        <form class="card card-add-form  mx-auto" style="height: 50%; width: 30%" action="../SectionServlet" method="GET">
            <div id="update-course-close" style="width: 20%">
                <i class="add-course-button fas fa-times"></i>
            </div>
            <h3 class="form-heading" style="margin-bottom:  0">Edit Section</h3>
            <input type="hidden" name="command" value="UPDATE" />
            <input type="hidden" name="sid" value="${section.section_id}" />
            <input type="hidden" name="status" value="${section.status}" />
            <div class="form-group">
                <input type="text" name="section" placeholder="Bài" value="${section.section}" />
            </div>

            <div class="form-group">
                <input type="text" name="section_name" placeholder="Tên bài" value="${section.section_name}" />
            </div>
            <div class="form-group">
                <select class="form-group" name="c_id">
                    <c:forEach var="c" items="${courses}">
                        <option value="${c.id}" <c:if test="${c.id == course.id}">selected</c:if>   >${c.course_name}</option>
                    </c:forEach>


                </select>
            </div>

            <div class="form-upload">
                <input type="file" name="video" id="course_picture" class="upload-input" placeholder="Ch?n file này" >

            </div>

            <div class="button-choice" style="text-align: center;">
                <button id="done-course-update" style="width: 20%" type="submit" class="save"><i class="fas fa-save"></i></button>
            </div>

        </form>
    </div>

</div>
