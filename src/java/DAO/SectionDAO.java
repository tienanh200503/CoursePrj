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
public class SectionDAO extends ConnectDB{

    private String sql;
    private Connection con;
    private PreparedStatement st;
    private ResultSet rs;

     List<Section> listSections = new ArrayList<>();
    public List<Section> getSectionByCid(int cid) throws SQLException, ClassNotFoundException {
        try {
            List<Section> listSections = new ArrayList<>();
            sql = "SELECT TOP (1000) [section_id]\n"
                + "      ,[course_id]\n"
                + "      ,[section]\n"
                + "      ,[section_name]\n"
                + "      ,[section_video]\n"
                + "  FROM [course].[dbo].[section]"
                + "Where course_id=? ";
            
            con= openConnection();
            st= con.prepareStatement(sql);
            st.setInt(1, cid);
            
            rs = st.executeQuery();
            
            while(rs.next())
            {
                Section s = new Section();
                s.setC_id(rs.getInt("course_id"));
                s.setSection_id(rs.getInt("section_id"));
                s.setSection_name(rs.getString("section_name"));
                s.setSection_video(rs.getString("section_video"));
                listSections.add(s);
            }
            
            
        } catch (SQLException e) {
            throw e;
        }
        return listSections;
    }
}
