/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is216.qlchitieu.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import is216.qlchitieu.DTO.User;
import is216.qlchitieu.DBUtils.DBConnect;
/**
 *
 * @author dangk
 */
public class UserDAL {
    private DBConnect dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    private ResultSet rs = null;
    
    public User getUserByID(User user){
        User result = null;
        String sqlStm = "select tenDangNhap, matKhau from NguoiDung where tenDangNhap = ?";
        try{
            dbu = new DBConnect();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlStm);
            pres.setString(1, user.getUsername());
            rs = pres.executeQuery();
            if(rs.next()){
                result = new User();
                result.setUsername(rs.getString("tenDangNhap"));
                result.setPassword(rs.getString("matKhau"));
               
            }
        } catch(SQLException e){
            System.out.println(e);
        } finally{
            try{
                conn.close();
                pres.close();
            } catch(Exception e){
                System.out.println(e);
            }
        }
        return result;
    }
    public int insertUser(User user){
        int result = 0;
        String sqlStm = "insert into NguoiDung values(?, ?)";
        try{
            dbu = new DBConnect();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlStm);
            pres.setString(1, user.getUsername());
            pres.setString(2, user.getPassword());
            result = pres.executeUpdate();
        } catch(SQLException e){
            System.out.println(e);
        } finally{
            try{
                conn.close();
                pres.close();
            } catch(Exception e){
                System.out.println(e);
            }
            
        }
        return result;
    }
    public int updatePassword(User user){
        int result = 0;
        String sqlStm = "update NguoiDung set matKhau = ? where tenDangNhap = ?";
        try{
            dbu = new DBConnect();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlStm);
            pres.setString(2, user.getUsername());
            pres.setString(1, user.getPassword());
            result = pres.executeUpdate();
        } catch(SQLException e){
            System.out.println(e);
        } finally{
            try{
                conn.close();
                pres.close();
            } catch(Exception e){
                System.out.println(e);
            }
            
        }
        return result;
    }
}