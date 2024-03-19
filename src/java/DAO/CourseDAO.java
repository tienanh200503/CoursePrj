/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dal.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Course;
import model.Section;
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

    public Course getCourse(int cid) throws Exception {
        Course a = null;
        List<Section> sections = new ArrayList<>();
        try {

            sql = "SELECT TOP (1000) \n"
                    + "      [course_name]\n"
                    + "      ,[course_time]\n"
                    + "      ,[teacher_name]\n"
                    + "      ,[course_price]\n"
                    + "      ,[course_describe]\n"
                    + "      ,[course_picture]\n"
                    + "	  ,[section]\n"
                    + "	  ,[section_name]\n"
                    + "  FROM [course].[dbo].[course]\n"
                    + "  JOIN [dbo].[section] ON section.course_id = course.course_id\n"
                    + "  JOIN [dbo].[teacher] ON teacher.teacher_id = course.teacher_id\n"
                    + "  WHERE [dbo].[course].course_id =?";
            Connection con = this.openConnection();
            st = con.prepareStatement(sql);
            st.setInt(1, cid);

            // Thực thi câu lệnh SQL và gán kết quả cho biến rs
            rs = st.executeQuery();

            while (rs.next()) {
                if (a == null) { // Chỉ khởi tạo đối tượng Course một lần
                    a = new Course();
                    a.setId(cid);
                    a.setCourse_name(rs.getString("course_name"));
                    a.setCourse_time(rs.getInt("course_time"));
                    a.setCourseDescribe(rs.getString("course_describe"));
                    a.setCourse_price(rs.getDouble("course_price"));
                    a.setCourse_img(rs.getString("course_picture"));

                    Teacher teacher = new Teacher();
                    teacher.setTeacher_name(rs.getString("teacher_name"));
                    a.setTeacher(teacher);
                }

                // Khởi tạo và thiết lập thông tin cho đối tượng Section cho mỗi bản ghi
                Section section = new Section();
                section.setSection(rs.getString("section"));
                section.setSection_name(rs.getString("section_name"));
                sections.add(section);
            }

            if (a != null) {
                // Đảm bảo đối tượng Section được thêm vào danh sách sections của Course nếu có
                a.setSections(sections);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw e;
            }

        }
        return a;
    }

    public Course getCourseById(int cid) throws Exception {
        Course a = new Course();
        List<Section> sections = new ArrayList<>();
        TeacherDAO teacherDAO = new TeacherDAO();
        SectionDAO sectionDAO = new SectionDAO();
        try {

            sql = "SELECT TOP (1000) [course_id]\n"
                    + "      ,[course_name]\n"
                    + "      ,[course_time]\n"
                    + "      ,[teacher_id]\n"
                    + "      ,[course_price]\n"
                    + "      ,[course_describe]\n"
                    + "      ,[course_picture]\n"
                    + "  FROM [course].[dbo].[course]"
                    + "  WHERE [dbo].[course].course_id =?";
            Connection con = this.openConnection();
            st = con.prepareStatement(sql);
            st.setInt(1, cid);

            // Thực thi câu lệnh SQL và gán kết quả cho biến rs
            rs = st.executeQuery();

            while (rs.next()) {

                Teacher t = new Teacher();
                a.setId(rs.getInt("course_id"));
                a.setCourse_name(rs.getString("course_name"));
                a.setCourse_time(rs.getInt("course_time"));
                a.setCourseDescribe(rs.getString("course_describe"));
                a.setCourse_price(rs.getDouble("course_price"));
                a.setTeacher(teacherDAO.getTeacherById(rs.getInt("teacher_id")));
                a.setSections(sectionDAO.getSectionByCid(rs.getInt("course_id")));
                a.setCourse_img(rs.getString("course_picture"));
                return a;
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw e;
            }

        }
        return a;
    }

    public void deleteCourse(int id) throws ClassNotFoundException {
        try {
            con = openConnection();
            sql = "DELETE FROM course WHERE course_id=?";
            st = con.prepareStatement(sql);
            st.setInt(1, id);
//            được sử dụng để thực thi các câu lệnh SQL không trả về kết quả, trả về số hàng bị ảnh hưởng
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCourse(Course c, int id) throws SQLException, ClassNotFoundException {
        try {
            con = openConnection();
            sql = "update course set course_name=?, course_time=?, teacher_id=?, course_price=?, course_describe=?, course_picture=? where course_id=?";
            st = con.prepareStatement(sql);
            st.setString(1, c.getCourse_name());
            st.setInt(2, c.getCourse_time());
            st.setInt(3, c.getTeacher().getTeacher_id());
            st.setDouble(4, c.getCourse_price());
            st.setString(5, c.getCourseDescribe());
            st.setString(6, c.getCourse_img());
            st.setInt(7, id);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCourse(Course c) throws SQLException, ClassNotFoundException {
        try {
            con = openConnection();
            sql = "insert into course(course_name, course_time, teacher_id, course_price, course_describe, course_picture)"
                    + "values(?,?,?,?,?,?)";
            st = con.prepareStatement(sql);
            st.setString(1, c.getCourse_name());
            st.setInt(2, c.getCourse_time());
            st.setInt(3, c.getTeacher().getTeacher_id());
            st.setDouble(4, c.getCourse_price());
            st.setString(5, c.getCourseDescribe());
            st.setString(6, c.getCourse_img());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Course> getCourseByName(String course_name) throws Exception {
        List<Course> listCourse = new ArrayList<>();
        Course a = null;
        try {

            sql = "SELECT TOP (1000)[dbo].[course].[course_id]\n"
                    + "      ,[course_name]\n"
                    + "      ,[course_time]\n"
                    + "      ,[teacher_name]\n"
                    + "      ,[course_price]\n"
                    + "      ,[course_describe]\n"
                    + "      ,[course_picture]\n"
                    + "  FROM [course].[dbo].[course]\n"
                    + "  JOIN [dbo].[teacher] ON teacher.teacher_id = course.teacher_id\n"
                    + "  WHERE [dbo].[course].course_name like ?";
            Connection con = this.openConnection();
            st = con.prepareStatement(sql);
            st.setString(1, "%" + course_name + "%");

            // Thực thi câu lệnh SQL và gán kết quả cho biến rs
            rs = st.executeQuery();

            while (rs.next()) {
                a = new Course();
                a.setId(rs.getInt("course_id"));
                a.setCourse_name(rs.getString("course_name"));
                a.setCourse_time(rs.getInt("course_time"));
                a.setCourseDescribe(rs.getString("course_describe"));
                a.setCourse_price(rs.getDouble("course_price"));
                a.setCourse_img(rs.getString("course_picture"));

                Teacher teacher = new Teacher();
                teacher.setTeacher_name(rs.getString("teacher_name"));
                a.setTeacher(teacher);

                listCourse.add(a);
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw e;
            }

        }
        return listCourse;
    }
}
