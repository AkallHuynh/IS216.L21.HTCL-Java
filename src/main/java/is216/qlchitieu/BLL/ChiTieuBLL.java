/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is216.qlchitieu.BLL;

import is216.qlchitieu.DAL.ChiTieuDAL;
import is216.qlchitieu.DTO.ChiTieuDTO;
import java.util.ArrayList;

/**
 *
 * @author huynh
 */
public class ChiTieuBLL {
    ChiTieuDAL chiTieuDal = new ChiTieuDAL();
    public ArrayList<ChiTieuDTO> getAllChiTieu(){
        return chiTieuDal.getAllChiTieu();
    }
    public ArrayList<ChiTieuDTO> getAllChiTieuByMonthUser(int thang, int nam, String tenDangNhap){
        return chiTieuDal.getAllChiTieuByMonthUser(thang, nam, tenDangNhap);
    }
    public ArrayList<ChiTieuDTO> getAllChiTieuByUser(String tenDangNhap){
        return chiTieuDal.getAllChiTieuByUser(tenDangNhap);
    }
    public int updateLuongTienById(String machitieu){
        return chiTieuDal.updateLuongTienById(machitieu);
    }
}
