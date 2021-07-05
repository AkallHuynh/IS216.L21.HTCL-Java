/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.GioiHanChiTieuDAL;
import DTO.GioiHanChiTieuDTO;

/**
 *
 * @author huynh
 */
public class GioiHanChiTieuBLL {
    GioiHanChiTieuDAL ghctDal = new GioiHanChiTieuDAL();
    public GioiHanChiTieuDTO getGioiHanChiTieuByTenDangNhap(String tendangnhap){
        return ghctDal.getGioiHanChiTieuByTenDangNhap(tendangnhap);
    }
    public int updateGioiHanChiTieuByTenDangNhap(String tenDangNhap, int gioiHan, double mucCanhBao){
        return ghctDal.updateGioiHanChiTieuByTenDangNhap(tenDangNhap, gioiHan, mucCanhBao);
    }
    public boolean isOverCanhBao(String tenDangNhap){
        return ghctDal.isOverCanhBao(tenDangNhap);
    }
    public int updateTongChiTieuThang(double tongChiTieuThang, String tenDangNhap){
        return ghctDal.updateTongChiTieuThang(tongChiTieuThang, tenDangNhap);
    }
}
