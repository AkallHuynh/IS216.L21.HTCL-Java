/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.GioiHanChiTieuDTO;
import Utils.DBUtils;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author huynh
 */
public class GioiHanChiTieuDAL {
    private DBUtils dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    private ResultSet rs = null;
    public GioiHanChiTieuDTO getGioiHanChiTieuByTenDangNhap(String tenDangNhap){
        GioiHanChiTieuDTO result = new GioiHanChiTieuDTO();
        String strSQL = "select * from gioihanchitieu where tendangnhap = '"+tenDangNhap+"'";
        try{
            dbu = new DBUtils();
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
    public int updateGioiHanChiTieuByTenDangNhap(String tenDangNhap, int gioiHan, double mucCanhBao){
        int result = 0;

        String updateGioiHan = "update gioihanchitieu set gioihan = "+gioiHan+", mucCanhBao = "+mucCanhBao
                + " where tendangnhap = '"+tenDangNhap+"'";
 
        try{
            dbu = new DBUtils();
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
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }
    public boolean isOverCanhBao(String tenDangNhap){
        boolean result = false;
        double tongChiTieuThang = 0;
        double mucCanhBao = 0;
        int gioiHan = 0;
        String strSQL = "select * from gioihanchitieu where tendangnhap = '"+tenDangNhap+"'";
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(strSQL);
            rs = pres.executeQuery();
            if(rs.next()){
                gioiHan = rs.getInt("gioihan");
                mucCanhBao = rs.getDouble("muccanhbao");
                tongChiTieuThang = rs.getDouble("tongchitieuthang");
            }
            if(tongChiTieuThang>= gioiHan*mucCanhBao){
                result = true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                conn.close();
                pres.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }
    public int updateTongChiTieuThang(double tongChiTieuThang, String tenDangNhap){
        int result = 0;
        String strSQL = "update gioihanchitieu set tongChiTieuThang = "+tongChiTieuThang
                +" where tendangnhap = '"+tenDangNhap+"'";
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(strSQL);
            result = pres.executeUpdate();

        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                conn.close();
                pres.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }
}
