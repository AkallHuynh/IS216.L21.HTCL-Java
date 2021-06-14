/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is216.qlchitieu.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 18520
 */
public class DBConnect {
    
    private Connection conn;
    
    public Connection createConn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/qlsp?useSSL=false",
                "root",
                "0502"
            );
            if (this.conn == null)
                System.out.println("Ket noi that bai");
            else
                System.out.println("Ket not thanh cong");
        } catch(ClassNotFoundException | SQLException e){
            System.out.println(e);
        }
        return conn;
    }
}
