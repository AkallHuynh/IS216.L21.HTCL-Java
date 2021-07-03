/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is216.qlchitieu.BLL;

import is216.qlchitieu.DAL.GioiHanChiTieuDAL;
import is216.qlchitieu.DTO.GioiHanChiTieuDTO;

/**
 *
 * @author huynh
 */
public class GioiHanChiTieuBLL {
    GioiHanChiTieuDAL ghctDal = new GioiHanChiTieuDAL();
    public GioiHanChiTieuDTO getGioiHanChiTieuByTenDangNhap(String tendangnhap){
        return ghctDal.getGioiHanChiTieuByTenDangNhap(tendangnhap);
    }
    public int updateGioiHanChiTieuByTenDangNhap(String tenDangNhap, int gioiHan){
        return ghctDal.updateGioiHanChiTieuByTenDangNhap(tenDangNhap, gioiHan);
    }
}
