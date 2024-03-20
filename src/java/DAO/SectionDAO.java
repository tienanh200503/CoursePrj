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
import model.Section;

/**
 *
 * @author Desktop
 */
public class SectionDAO extends ConnectDB {

    private String sql;
    private Connection con;
    private PreparedStatement st;
    private ResultSet rs;

    public List<Section> getSectionByStatus(int status) throws SQLException, ClassNotFoundException {
        List<Section> list = new ArrayList<>();
        try {

            sql = "SELECT * FROM [course].[dbo].[section] WHERE status=" + status;
            con = openConnection();
            st = con.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                Section s = new Section();
                s.setC_id(rs.getInt("course_id"));
                s.setSection(rs.getString("section"));
                s.setSection_id(rs.getInt("section_id"));
                s.setSection_name(rs.getString("section_name"));
                s.setSection_video(rs.getString("section_video"));
                s.setStatus(rs.getBoolean("status"));
                list.add(s);
            }

        } catch (SQLException e) {
            throw e;
        }
        return list;

    }

    public List<Section> getAllSections() throws SQLException, ClassNotFoundException {
        List<Section> list = new ArrayList<>();
        try {

            sql = "SELECT *\n"
                    + "FROM [course].[dbo].[section]\n"
                    + "ORDER BY course_id;";
            con = openConnection();
           

            st = con.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                Section s = new Section();
                s.setC_id(rs.getInt("course_id"));
                s.setSection(rs.getString("section"));
                s.setSection_id(rs.getInt("section_id"));
                s.setSection_name(rs.getString("section_name"));
                s.setSection_video(rs.getString("section_video"));
                s.setStatus(rs.getBoolean("status"));
                list.add(s);
            }

        } catch (SQLException e) {
            throw e;
        }
        return list;

    }

    public List<Section> getSectionByCid(int cid) throws SQLException, ClassNotFoundException {
        List<Section> listSections = new ArrayList<>();
        try {

            sql = "SELECT [section_id]\n"
                    + "      ,[course_id]\n"
                    + "      ,[section]\n"
                    + "      ,[section_name]\n"
                    + "      ,[section_video]\n"
                    + "      ,[status]\n"
                    + "  FROM [dbo].[section]"
                    + "Where course_id=? ";

            con = openConnection();
            st = con.prepareStatement(sql);
            st.setInt(1, cid);

            rs = st.executeQuery();

            while (rs.next()) {
                Section s = new Section();
                s.setC_id(rs.getInt("course_id"));
                s.setSection(rs.getString("section"));
                s.setSection_id(rs.getInt("section_id"));
                s.setSection_name(rs.getString("section_name"));
                s.setSection_video(rs.getString("section_video"));
                s.setStatus(rs.getBoolean("status"));
                listSections.add(s);
            }

        } catch (SQLException e) {
            throw e;
        }
        return listSections;
    }

    public Section getSectionById(int sid) throws ClassNotFoundException {
        try {
            Section s = new Section();
            sql = "SELECT * from section where section_id=?";
            Connection con = this.openConnection();
            st = con.prepareStatement(sql);
            st.setInt(1, sid);

            rs = st.executeQuery();

            while (rs.next()) {

                s.setSection_id(rs.getInt("section_id"));
                s.setC_id(rs.getInt("course_id"));
                s.setSection(rs.getString("section"));
                s.setSection_name(rs.getString("section_name"));
                s.setSection_video(rs.getString("section_video"));
                s.setStatus(rs.getBoolean("status"));
                return s;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateSection(Section s, int sid) throws ClassNotFoundException {
        try {
            con = openConnection();
            sql = "Update section set  course_id=?,section=?, section_name=?,section_video=?, status=?   where section_id = ?";
            st = con.prepareStatement(sql);

            st.setInt(1, s.getC_id());
            st.setString(2, s.getSection());
            st.setString(3, s.getSection_name());
            st.setString(4, s.getSection_video());
            st.setBoolean(5, s.isStatus());
            st.setInt(6, sid);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSectionById(int sid) throws ClassNotFoundException {
        try {
            con = openConnection();
            sql = " delete from section where section_id = ?";
            st = con.prepareStatement(sql);

            st.setInt(1, sid);

            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertSection(Section s) throws ClassNotFoundException {
        try {
            con = openConnection();
            sql = "insert into section(course_id,section,section_name,section_video, status) values(?,?,?,?,?)";
            st = con.prepareStatement(sql);
            st.setInt(1, s.getC_id());
            st.setString(2, s.getSection());
            st.setString(3, s.getSection_name());
            st.setString(4, s.getSection_video());
            st.setBoolean(5, s.isStatus());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
