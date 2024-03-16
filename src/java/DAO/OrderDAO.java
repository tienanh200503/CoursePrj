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

    public List<Course> getCourseId(int userId, int status) {
        List<Course> list = new ArrayList<>();
        try {

            sql = "  SELECT   c.course_id\n"
                    + ",c.[course_name]\n"
                    + ",c.[course_time]\n"
                    + ",c.[course_price]\n"
                    + ",c.[teacher_id]\n"
                    + ",t.teacher_name\n"
                    + ",c.[course_describe]\n"
                    + ",c.[course_picture]\n"
                    + "FROM [order] o\n"
                    + "JOIN course c ON o.course_id = c.course_id \n"
                    + "JOIN teacher t ON t.teacher_id = c.teacher_id\n"
                    + "JOIN section s ON s.course_id = c.course_id\n"
                    + "where user_id = " + userId + "AND s.status = "+status
                    + "GROUP BY c.course_id ,c.[course_name]"
                    + ",c.[course_time]"
                    + ",c.[course_price]"
                    + ",c.[teacher_id]"
                    + ",t.teacher_name"
                    + ",c.[course_describe]"
                    + ",c.[course_picture]";
            con = openConnection();
            st = con.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getInt(1));
                c.setCourse_name(rs.getString(2));
                c.setCourse_time(rs.getInt(3));
                c.setCourse_price(rs.getDouble(4));
                c.setTeacher(new Teacher(rs.getInt(5), rs.getString(6)));
                c.setCourseDescribe(rs.getString(7));
                c.setCourse_img(rs.getString(8));
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
}
