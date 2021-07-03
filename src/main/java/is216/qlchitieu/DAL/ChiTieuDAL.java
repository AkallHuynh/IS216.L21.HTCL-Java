/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is216.qlchitieu.DAL;

import is216.qlchitieu.DTO.ChiTieuDTO;
import is216.qlchitieu.DBUtils.DBConnect;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author huynh
 */
public class ChiTieuDAL {
    private DBConnect dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    private ResultSet rs = null;
    
    public ArrayList<ChiTieuDTO> getAllChiTieu(){
        ArrayList<ChiTieuDTO> result = new ArrayList<ChiTieuDTO>();
        
        String sqlSelectAll = "select * from thongtinchitieu";
        
        try{
            dbu = new DBConnect();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlSelectAll);
            rs = pres.executeQuery();
            
            while(rs.next()){
                ChiTieuDTO chitieu = new ChiTieuDTO();
                chitieu.setMaChiTieu(rs.getString("machitieu"));
                chitieu.setTenDangNhap(rs.getString("tendangnhap"));
                chitieu.setMaTieuDung(rs.getString("matieudung"));
                chitieu.setLuongTien(rs.getDouble("luongtien"));
                chitieu.setNgayChi(rs.getDate("ngaychi"));
                
                result.add(chitieu);
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
    
    public ArrayList<ChiTieuDTO> getAllChiTieuByMonthUser(int thang, int nam, String tenDangNhap){
        ArrayList<ChiTieuDTO> result = new ArrayList<ChiTieuDTO>();
        
        String strSQL = "select * from thongtinchitieu where tendangnhap = '"+tenDangNhap+"'";
        
        try{
            dbu = new DBConnect();
            conn = dbu.createConn();
            pres = conn.prepareStatement(strSQL);
            rs = pres.executeQuery();
            
            while(rs.next()){
                ChiTieuDTO chitieu = new ChiTieuDTO();
                String[] row = rs.getDate("ngaychi").toString().split("-");
                int namct = Integer.parseInt(row[0]);
                int thangct = Integer.parseInt(row[1]);
                if(thang==thangct && nam==namct){
                    chitieu.setMaChiTieu(rs.getString("machitieu"));
                    chitieu.setTenDangNhap(rs.getString("tendangnhap"));
                    chitieu.setMaTieuDung(rs.getString("matieudung"));
                    chitieu.setLuongTien(rs.getDouble("luongtien"));
                    chitieu.setNgayChi(rs.getDate("ngaychi"));
                    result.add(chitieu);
                }
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
    
    public ArrayList<ChiTieuDTO> getAllChiTieuByUser(String tenDangNhap){
        ArrayList<ChiTieuDTO> result = new ArrayList<ChiTieuDTO>();
        
        String strSQL = "select * from thongtinchitieu where tendangnhap = '"+tenDangNhap+"'";
        
        try{
            dbu = new DBConnect();
            conn = dbu.createConn();
            pres = conn.prepareStatement(strSQL);
            rs = pres.executeQuery();
            
            while(rs.next()){
                ChiTieuDTO chitieu = new ChiTieuDTO();
                chitieu.setMaChiTieu(rs.getString("machitieu"));
                chitieu.setTenDangNhap(rs.getString("tendangnhap"));
                chitieu.setMaTieuDung(rs.getString("matieudung"));
                chitieu.setLuongTien(rs.getDouble("luongtien"));
                chitieu.setNgayChi(rs.getDate("ngaychi"));
                result.add(chitieu);
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
    
    
    public int updateLuongTienById(String machitieu){
        int result = 0;
        double luongTien =0;
        try{
            String strSQL1 = "select maTieuDung from thongtinchitieu where machitieu = '"+machitieu+"'";
            dbu = new DBConnect();
            conn = dbu.createConn();
            pres = conn.prepareStatement(strSQL1);
            rs = pres.executeQuery();
            while(rs.next()){
                String strSQL2 = "select thanhTien from tieudung where matieudung = '"+rs.getString("matieudung")+"'";
                Statement stat = conn.createStatement();
                ResultSet rs2 = stat.executeQuery(strSQL2);
                if(rs2.next()){
                    luongTien+=rs2.getDouble("thanhTien");
                }
            }
            String strSQL3 = "update thongtinchitieu set luongtien = "+luongTien+" where machitieu = '"+machitieu+"'";
            Statement stat = conn.createStatement();
            result = stat.executeUpdate(strSQL3);
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
