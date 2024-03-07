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
import model.Account;
import model.Teacher;

/**
 *
 * @author Desktop
 */
public class TeacherDAO extends ConnectDB {

    private String sql;
    private Connection con;
    private PreparedStatement st;
    private ResultSet rs;

    public Teacher getTeacherById(int id) throws ClassNotFoundException, SQLException {
        try {
            Teacher t = new Teacher();
            sql = "SELECT TOP (1000) [teacher_id]\n"
                    + "      ,[teacher_name]\n"
                    + "  FROM [course].[dbo].[teacher]"
                    + "Where teacher_id = ? ";
            Connection con = this.openConnection();
            st = con.prepareStatement(sql);
            st.setInt(1, id);
            

            rs = st.executeQuery();

            while (rs.next()) {
                t.setTeacher_id(rs.getInt("teacher_id"));
                t.setTeacher_name(rs.getString("teacher_name"));
                return t;

            }

        } catch (SQLException e) {
            throw e;
        }
        return null;
    }
}
