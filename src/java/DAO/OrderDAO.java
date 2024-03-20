package DAO;

import dal.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; // Thêm thư viện để xử lý SQLException
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import model.Course;
import model.Order;
import model.Section;
import model.Teacher;

/**
 *
 * @author BIN
 */
public class OrderDAO extends ConnectDB {

    private String sql;
    private Connection con;
    private PreparedStatement st;
    private ResultSet rs;

    public List<Course> getCourseId(int userId) {
        SectionDAO sec = new SectionDAO();
        List<Course> list = new ArrayList<>();
        try {

            sql = "  SELECT   c.course_id ,c.[course_name]\n"
                    + "      ,c.[course_time]\n"
                    + "      ,c.[teacher_id]\n"
                    + "	  ,t.teacher_name\n"
                    + "      ,c.[course_price]\n"
                    + "      ,c.[course_describe]\n"
                    + "      ,c.[course_picture]\n"
                    + "FROM [order] o\n"
                    + "JOIN course c ON o.course_id = c.course_id\n"
                    + "JOIN teacher t ON c.teacher_id = t.teacher_id\n"
                    + "where user_id = " + userId;
            con = openConnection();
            st = con.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                List<Section> secList = sec.getSectionByCid(rs.getInt(1));
                Course c = new Course();
                c.setId(rs.getInt(1));
                c.setCourse_name(rs.getString(2));
                c.setCourse_time(rs.getInt(3));
                c.setTeacher(new Teacher(rs.getInt(4), rs.getString(5)));
                c.setCourse_price(rs.getDouble(6));
                c.setCourseDescribe(rs.getString(7));
                c.setCourse_img(rs.getString(8));
                c.setSections(secList);
                list.add(c);
            }

        } catch (Exception e) {
        }
        return list;
    }

    public void insertOrder(Order o) throws ClassNotFoundException, SQLException {
        try {
            con = openConnection();
            sql = "  insert into [dbo].[order](user_id, course_id, order_date) values(?,?,?)";
            st = con.prepareStatement(sql);
            st.setInt(1, o.getUid());
            st.setInt(2, o.getCid());
            st.setString(3, o.getOrder_date());
            st.executeUpdate();
        } finally {
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public List<Course> getTop4BestOfCourse() {
        SectionDAO sec = new SectionDAO();
        CourseDAO cdao = new CourseDAO();
        List<Course> list = new ArrayList<>();
        try {

            sql = "  Select top 4 course_id from [order]\n"
                    + "group by course_id\n"
                    + "order by count(*) desc";
            con = openConnection();
            st = con.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                List<Section> secList = sec.getSectionByCid(rs.getInt("course_id"));
                Course c = cdao.getCourseById(rs.getInt("course_id"));
                list.add(c);
            }

        } catch (Exception e) {
        }
        return list;
    }
}
