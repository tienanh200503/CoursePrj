/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.accountDAO;

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

    public Account addAccount(Account a) throws SQLException, ClassNotFoundException {
        try {
            
            sql = "INSERT INTO [dbo].[user]\n"
                + "           ([password]\n"
                + "           ,[user_name]\n"
                + "           ,[user_date]\n"
                + "           ,[email]\n"
                + "           ,[role]\n"
                + "           ,[ATM])\n"
                + "     VALUES\n"
                + "           (<?, nchar(50),>\n"
                + "           ,<?, nchar(50),>\n"
                + "           ,<?, date,>\n"
                + "           ,<?, nchar(50),>\n"
                + "           ,<?, nchar(20),>\n"
                + "           ,<?, nchar(10),>)";
            
            con = openConnection();
            st = con.prepareStatement(sql);
            st.setString(1, a.getPassword());
            st.setString(2, a.getUsername());
            st.setString(3, a.getUserDate());
            st.setString(4, a.getEmail());
            st.setInt(5, a.getRole());
            st.setDouble(6, a.getMoney());
            
            rs = st.executeQuery();
            return a;
        }catch (SQLException e) {
            throw e;
        }
            
    }
 public boolean checkValid(Account a) throws SQLException, ClassNotFoundException
 {
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
            if(rs.next())
            {
                return true;
            }
            
            
        } catch (SQLException e) {
            throw e;
        }
     return false;
 }
}
