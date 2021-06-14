/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is216.qlchitieu.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import is216.qlchitieu.DBUtils.DBConnect;
/**
 *
 * @author 18520
 */
public abstract class AbstractDAL<T> {
    PreparedStatement pres;
    ResultSet rs;
    Connection conn;
    DBConnect dbu;
            
    public abstract ArrayList<T> getAll();
    public abstract T getByID(T arg);
    public abstract int update(T arg);
    public abstract int delete(T arg);
}
