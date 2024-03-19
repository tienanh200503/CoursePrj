/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dal.ConnectDB;
import model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Desktop
 */
public class AccountDAO extends ConnectDB {

    private String sql;
    private Connection con;
    private PreparedStatement st;
    private ResultSet rs;

    public Account getAccount(String username, String password) throws ClassNotFoundException, SQLException {
        try {
            Account a = new Account();
            sql = "SELECT [user_id]\n"
                    + "      ,[password]\n"
                    + "      ,[user_name]\n"
                    + "      ,[user_date]\n"
                    + "      ,[email]\n"
                    + "      ,[role]\n"
                    + "      ,[ATM]\n"
                    + "  FROM [dbo].[user]"
                    + "where user_name =? and password=? ";
            Connection con = this.openConnection();
            st = con.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);

            rs = st.executeQuery();

            while (rs.next()) {

                a.setId(rs.getInt("user_id"));
                a.setUsername(rs.getString("user_name"));
                a.setPassword(rs.getString("password"));
                a.setRole(rs.getInt("role"));
                a.setMoney(rs.getDouble("ATM"));
                a.setUserDate(rs.getString("user_date"));
                a.setEmail(rs.getString("email"));
                return a;

            }

        } catch (SQLException e) {
            throw e;
        }
        return null;
    }

    public Account getAccountById(int course_id) throws ClassNotFoundException, SQLException {
        try {
            Account a = new Account();
            sql = "SELECT TOP (1000) [user_id]\n"
                    + "      ,[password]\n"
                    + "      ,[user_name]\n"
                    + "      ,[user_date]\n"
                    + "      ,[email]\n"
                    + "      ,[role]\n"
                    + "      ,[ATM]\n"
                    + "  FROM [course].[dbo].[user]\n"
                    + "  where user_id =?";
            Connection con = this.openConnection();
            st = con.prepareStatement(sql);
            st.setInt(1, course_id);

            rs = st.executeQuery();

            while (rs.next()) {

                a.setId(rs.getInt("user_id"));
                a.setUsername(rs.getString("user_name"));
                a.setPassword(rs.getString("password"));
                a.setRole(rs.getInt("role"));
                a.setMoney(rs.getDouble("ATM"));
                a.setUserDate(rs.getString("user_date"));
                a.setEmail(rs.getString("email"));
                return a;

            }

        } catch (SQLException e) {
            throw e;
        }
        return null;
    }

    public Account addAccount(Account a) throws SQLException, ClassNotFoundException {
        try {

            sql = "INSERT INTO [dbo].[user]\n"
                    + "    ([password]\n"
                    + "    ,[user_name]\n"
                    + "    ,[email]\n"
                    + "    ,[role])\n" +
            "VALUES (?, ?, ?, ?)";
                    
                    
                   

            con = openConnection();
            st = con.prepareStatement(sql);
            st.setString(1, a.getPassword());
            st.setString(2, a.getUsername());
            st.setString(3, a.getEmail());
            st.setInt(4, a.getRole());

            rs = st.executeQuery();
            return a;
        } catch (SQLException e) {
            throw e;
        }

    }

    public boolean checkValid(Account a) throws SQLException, ClassNotFoundException {
        try {

            sql = "SELECT [user_id]\n"
                    + "      ,[password]\n"
                    + "      ,[user_name]\n"
                    + "      ,[user_date]\n"
                    + "      ,[email]\n"
                    + "      ,[role]\n"
                    + "      ,[ATM]\n"
                    + "  FROM [dbo].[user]"
                    + "where user_name =? ";
            Connection con = this.openConnection();
            st = con.prepareStatement(sql);
            st.setString(1, a.getUsername());

            rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            throw e;
        }
        return false;
    }

    public void updateAccountATM(int user_id, double newATM) throws ClassNotFoundException, SQLException {
        try {
            // Tạo câu lệnh SQL để cập nhật cột ATM cho tài khoản có user_id tương ứng
            String sql = "UPDATE [course].[dbo].[user] SET ATM = ? WHERE user_id = ?";

            // Mở kết nối đến cơ sở dữ liệu
            Connection con = this.openConnection();

            // Tạo prepared statement với câu lệnh SQL đã chuẩn bị
            PreparedStatement st = con.prepareStatement(sql);

            // Đặt giá trị mới cho cột ATM
            st.setDouble(1, newATM);

            // Đặt user_id cho điều kiện WHERE
            st.setInt(2, user_id);

            // Thực thi câu lệnh SQL để cập nhật dữ liệu
            st.executeUpdate();

            // Đóng kết nối và tài nguyên
            st.close();
            con.close();

        } catch (SQLException e) {
            throw e;
        }
    }

}
