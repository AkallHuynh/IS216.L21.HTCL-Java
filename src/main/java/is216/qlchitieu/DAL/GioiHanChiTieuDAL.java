/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is216.qlchitieu.DAL;

import is216.qlchitieu.DTO.GioiHanChiTieuDTO;
import is216.qlchitieu.DBUtils.DBConnect;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author huynh
 */
public class GioiHanChiTieuDAL {
    private DBConnect dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    private ResultSet rs = null;
    public GioiHanChiTieuDTO getGioiHanChiTieuByTenDangNhap(String tenDangNhap){
        GioiHanChiTieuDTO result = new GioiHanChiTieuDTO();
        String strSQL = "select * from gioihanchitieu where tendangnhap = '"+tenDangNhap+"'";
        try{
            dbu = new DBConnect();
            conn = dbu.createConn();
            pres = conn.prepareStatement(strSQL);
            rs = pres.executeQuery();
            if(rs.next()){
                result.setMaGioiHan(rs.getString("magioihan"));
                result.setTenDangNhap(rs.getString("tendangnhap"));
                result.setGioiHan(rs.getInt("gioihan"));
                result.setTongChiTieuThang(rs.getDouble("tongchitieuthang"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                conn.close();
                pres.close();
                rs.close();

            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }
    public int updateGioiHanChiTieuByTenDangNhap(String tenDangNhap, int gioiHan){
        int result = 0;

        String updateGioiHan = "update gioihanchitieu set gioihan = "+gioiHan+" where tendangnhap = '"+tenDangNhap+"'";
 
        try{
            dbu = new DBConnect();
            conn = dbu.createConn();
            pres = conn.prepareStatement(updateGioiHan);
            result = pres.executeUpdate();

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                conn.close();
                pres.close();
                rs.close();

            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }
}
