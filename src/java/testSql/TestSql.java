/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testSql;

import DAO.AccountDAO;
import DAO.CourseDAO;
import DAO.OrderDAO;
import DAO.SectionDAO;
import DAO.TeacherDAO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.Course;
import model.Order;
import model.Section;
import model.Teacher;

/**
 *
 * @author Desktop
 */
public class TestSql {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException, Exception {

      
        TeacherDAO t = new TeacherDAO();
        System.out.println(t.getAllTeacher());
        
        

      

       
    }
       
    
    
}
