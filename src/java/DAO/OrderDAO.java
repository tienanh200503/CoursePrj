package DAO;

import dal.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException; // Thêm thư viện để xử lý SQLException
import model.Order;

/**
 *
 * @author BIN
 */
public class OrderDAO extends ConnectDB {

    private String sql;
    private Connection con;
    private PreparedStatement st;

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
