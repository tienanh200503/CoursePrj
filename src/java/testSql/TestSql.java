/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testSql;

import DAO.AccountDAO;
import DAO.CourseDAO;
import DAO.SectionDAO;
import java.sql.SQLException;

/**
 *
 * @author Desktop
 */
public class TestSql {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException, Exception {
        
        
        CourseDAO c = new CourseDAO();
        System.out.println(c.getCourse(2).getCourse_price());
        AccountDAO a = new AccountDAO();
        System.out.println(a.getAccountById(2).getMoney());
        
        
        
    }
    
}
