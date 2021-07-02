/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is216.qlchitieu.DAL;


import DTO.TieuDungDTO;
import Utils.DBUtils;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author huynh
 */
public class TieuDungDAL {
    private DBUtils dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    private ResultSet rs = null;
    
    
    public ArrayList<TieuDungDTO> getAlltieudung(){
        
        ArrayList<TieuDungDTO> result = new ArrayList<TieuDungDTO>();
        
        String sqlSelectAll = "select * from tieudung";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlSelectAll);
            rs = pres.executeQuery();
            
            while(rs.next()){
                TieuDungDTO tieudung = new TieuDungDTO();
                tieudung.setMaTieuDung(rs.getString("matieudung"));
                tieudung.setLoaiChiTieu(rs.getInt("loaichitieu"));
                tieudung.setTenHangHoa(rs.getString("tenhanghoa"));
                tieudung.setSoLuong(rs.getInt("soluong"));
                tieudung.setThanhTien(rs.getDouble("thanhtien"));
                
                result.add(tieudung);
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
    
    public TieuDungDTO getTieuDungById(String matieudung){
        
        TieuDungDTO result = new TieuDungDTO();
        
        String sqlSelectAll = "select * from tieudung where matieudung = '"+matieudung+"'";
        
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlSelectAll);
            rs = pres.executeQuery();
            
            if(rs.next()){
                TieuDungDTO tieudung = new TieuDungDTO();
                tieudung.setMaTieuDung(rs.getString("matieudung"));
                tieudung.setLoaiChiTieu(rs.getInt("loaichitieu"));
                tieudung.setTenHangHoa(rs.getString("tenhanghoa"));
                tieudung.setSoLuong(rs.getInt("soluong"));
                tieudung.setThanhTien(rs.getDouble("thanhtien"));
                
                result = tieudung;
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
    public ArrayList<TieuDungDTO> getAllTieuDungByMaChiTieu(String machitieu){
        ArrayList<TieuDungDTO> result = new ArrayList<TieuDungDTO>();
        ArrayList<String> arrMaTieuDung = new ArrayList<String>();
        try{
            dbu = new DBUtils();
            conn = dbu.createConn();
            String strSQL1 = "select matieudung from thongtinchitieu where machitieu = '"+machitieu+"'";
            pres = conn.prepareStatement(strSQL1);
            rs = pres.executeQuery();
            while(rs.next()){
                if(!arrMaTieuDung.contains(rs.getString("matieudung"))){
                    arrMaTieuDung.add(rs.getString("matieudung"));
                }
            }
            for(int i=0;i<arrMaTieuDung.size();i++){
                String strSQL2 = "select * from tieudung where matieudung = '"+arrMaTieuDung.get(i)+"'";
                Statement stat = conn.createStatement();
                ResultSet rs2 = stat.executeQuery(strSQL2);
                while(rs2.next()){
                    TieuDungDTO tieudung = new TieuDungDTO();
                    tieudung.setMaTieuDung(rs2.getString("matieudung"));
                    tieudung.setLoaiChiTieu(rs2.getInt("loaichitieu"));
                    tieudung.setTenHangHoa(rs2.getString("tenhanghoa"));
                    tieudung.setSoLuong(rs2.getInt("soluong"));
                    tieudung.setThanhTien(rs2.getDouble("thanhtien"));
                    result.add(tieudung);
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
}
