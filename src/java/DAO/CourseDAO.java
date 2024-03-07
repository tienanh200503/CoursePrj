/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dal.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Course;
import model.Teacher;

/**
 *
 * @author Desktop
 */
public class CourseDAO extends ConnectDB {

    private String sql;
    private Connection con;
    private PreparedStatement st;
    private ResultSet rs;

    public List<Course> getAllCourse() throws Exception {
        List<Course> listCourse = new ArrayList<>();
        try {
            TeacherDAO teacherDAO = new TeacherDAO();
            SectionDAO sectionDAO = new SectionDAO();

            sql = "SELECT TOP (1000) [course_id]\n"
                    + "      ,[course_name]\n"
                    + "      ,[course_time]\n"
                    + "      ,[teacher_id]\n"
                    + "      ,[course_price]\n"
                    + "      ,[course_describe]\n"
                    + "      ,[course_picture]\n"
                    + "  FROM [course].[dbo].[course]";
            Connection con = this.openConnection();
            st = con.prepareStatement(sql);

            rs = st.executeQuery();

            while (rs.next()) {
                Course a = new Course();

                Teacher t = new Teacher();
                a.setId(rs.getInt("course_id"));
                a.setCourse_name(rs.getString("course_name"));
                a.setCourse_time(rs.getInt("course_time"));
                a.setCourseDescribe(rs.getString("course_describe"));
                a.setCourse_price(rs.getDouble("course_price"));
                a.setTeacher(teacherDAO.getTeacherById(rs.getInt("teacher_id")));
                a.setSections(sectionDAO.getSectionByCid(rs.getInt("course_id")));
                a.setCourse_img(rs.getString("course_picture"));
                listCourse.add(a);

            }

        } catch (Exception e) {
            throw e;
        }
        return listCourse;
    }
}
