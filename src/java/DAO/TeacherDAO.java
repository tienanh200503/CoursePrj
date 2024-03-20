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
                t.setTeacher_name(rs.getString("teacher_name").trim());
                return t;

            }

        } catch (SQLException e) {
            throw e;
        }
        return null;
    }

    public List<Teacher> getAllTeacher() throws ClassNotFoundException, SQLException {
        List<Teacher> teachers = new ArrayList<>();
        try {
            
            sql = "SELECT * FROM [course].[dbo].[teacher]";
                   
            Connection con = this.openConnection();
            st = con.prepareStatement(sql);

            rs = st.executeQuery();

            while (rs.next()) {
                Teacher t = new Teacher();
                t.setTeacher_id(rs.getInt("teacher_id"));
                t.setTeacher_name(rs.getString("teacher_name"));

                teachers.add(t);
            }
            return teachers;
        } catch (SQLException e) {
            throw e;
        }
        
    }

    public void deleteTeacherByid(int teacher_id) throws ClassNotFoundException {
        try {
            con = openConnection();
            sql = "delete From teacher where teacher_id = ?";
            st = con.prepareStatement(sql);
            st.setInt(1, teacher_id);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTeacherById(int teacher_id, Teacher t) throws ClassNotFoundException {
        try {
            con = openConnection();
            sql = "Update teacher set  teacher_name=? where teacher_id = ?";
            st = con.prepareStatement(sql);

            st.setString(1, t.getTeacher_name());
            st.setInt(2, teacher_id);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertTeacher(Teacher t) throws ClassNotFoundException {
        try {
            con = openConnection();
            sql = "insert into teacher values(?)";
            st = con.prepareStatement(sql);

            st.setString(1, t.getTeacher_name());

            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
