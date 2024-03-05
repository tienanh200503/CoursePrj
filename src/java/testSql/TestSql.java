/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testSql;

import DAO.accountDAO.AccountDAO;
import java.sql.SQLException;

/**
 *
 * @author Desktop
 */
public class TestSql {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        AccountDAO account = new AccountDAO();
        System.out.println(account.getAccount("user", "123"));
    }
    
}
