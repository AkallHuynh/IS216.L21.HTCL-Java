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

import is216.qlchitieu.DTO.ThongTinChiTieuDTO;
import is216.qlchitieu.DBUtils.DBConnect;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class ThongTinChiTieuDAL {

    private DBConnect dbu = null;
    private Connection conn = null;
    private PreparedStatement pres = null;
    private ResultSet rs = null;

    public int insertHangHoa(ThongTinChiTieuDTO HangHoa) {
        int result = 0;
        String sqlInsert = "INSERT INTO TIEUDUNG (maTieuDung, loaiChiTieu, tenHangHoa, soLuong, thanhTien)"
                + " VALUES (?, ?, ?, ?, ?)";

        try {

            dbu = new DBConnect();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlInsert);
            pres.setString(1, HangHoa.getmaTieuDung());
            pres.setInt(2, HangHoa.getLoaiChiTieu());
            pres.setString(3, HangHoa.getTenHangHoa());
            pres.setInt(4, HangHoa.getSoLuong());
            pres.setDouble(5, HangHoa.getThanhTien());

            result = pres.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                pres.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public int deleteHangHoa(ThongTinChiTieuDTO HangHoa) {
        int result = 0;
        String sqlDelete = "delete from TIEUDUNG where maTieuDung = ?";
        try {
            dbu = new DBConnect();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlDelete);
            pres.setString(1, HangHoa.getmaTieuDung());
            result = pres.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                pres.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public int insertTTCT(ThongTinChiTieuDTO TTCT) {
        int result = 0;
        String sqlInsert = "INSERT INTO THONGTINCHITIEU (maChiTieu, tenDangNhap, luongTien, ngayChi, maTieuDung)"
                + " VALUES (?, ?, ?, ?, ?)";

        try {

            dbu = new DBConnect();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlInsert);
            pres.setString(1, TTCT.getMaChiTieu());
            pres.setString(2, TTCT.getTenDangNhap());
            pres.setDouble(3, TTCT.getLuongTien());
            pres.setString(4, TTCT.getNgayChi());
            pres.setString(5, TTCT.getmaTieuDung());

            result = pres.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                pres.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    
    public int updateTongChiTieuThang(ThongTinChiTieuDTO TTCT) {
        int result = 0;
        String sqlUpdate = "UPDATE gioihanchitieu SET tongChiTieuThang = ? WHERE tenDangNhap = ?";
                try {

            dbu = new DBConnect();
            conn = dbu.createConn();
            pres = conn.prepareStatement(sqlUpdate);
            pres.setDouble(1, TTCT.gettongChiTieuThang());
            pres.setString(2, TTCT.getTenDangNhap());


            result = pres.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                pres.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
