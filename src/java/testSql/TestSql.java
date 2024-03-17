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

       SectionDAO s = new SectionDAO();
       s.getSectionById(3);

        
        
        CourseDAO c = new CourseDAO();
        System.out.println(c.getCourseByName("cơ"));

//        System.out.println(c.getCourse(2).getCourse_price());
//        AccountDAO a = new AccountDAO();
//        System.out.println(a.getAccountById(2).getMoney());
//
//        
//
//        System.out.println(s.getSectionById(3).isStatus());
       
        
       
    }
    
}
