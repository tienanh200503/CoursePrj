<%-- 
    Document   : addCourse
    Created on : Mar 9, 2024, 9:32:09?AM
    Author     : Desktop
--%>


<div id="add-course-form">

    <div class="overlay">

        <form class="card card-add-form  mx-auto" action="../CourseController" method="GET">
            <i id="add-course-close" class="close fas fa-times"  />
            <h3> Add New Course</h3>
            <input type="hidden" name="command" value="ADD" />

            <table border="0">
                <tbody>
                    <tr>

                        <td> <input type="text" name="course_name" placeholder="Course Name" value="" /></td>
                    </tr>

                    <tr>

                        <td><input type="text" name="course_time" placeholder="Course Time" value="" /></td>
                    </tr>
                    <tr>

                        <td><input type="text" name="teacher_id" placeholder="Teacher_Id" value="" /></td>
                    </tr>
                    <tr>

                        <td><input type="text" name="course_price" placeholder="Price" value="" /></td>
                    </tr>
                    <tr>
                        <td><textarea name="course_describe" placeholder="Describe"></textarea></td>
                    </tr>
                    <tr>
                        <td>
                            <input type="file" name="course_picture" id="course_picture">
                        </td>

                    </tr>

                </tbody>

            </table>
            <div class="button-choice" style="text-align: center;">

                <button style="width: 20%" type="submit" class="save"><i class="fas fa-save"></i></button>
            </div>

        </form>
    </div>
</div>


