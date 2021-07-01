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
}
