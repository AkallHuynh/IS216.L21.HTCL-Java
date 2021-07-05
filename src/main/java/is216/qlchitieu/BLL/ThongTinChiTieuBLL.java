/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DTO.ThongTinChiTieuDTO;
import DAL.ThongTinChiTieuDAL;

/**
 *
 * @author HP
 */
public class ThongTinChiTieuBLL {

    ThongTinChiTieuDAL TTCTDAL = new ThongTinChiTieuDAL();

    public ThongTinChiTieuBLL() {
    }

    public int insertHangHoa(ThongTinChiTieuDTO TTCT) {
        return this.TTCTDAL.insertHangHoa(TTCT);
    }

    public int deleteHangHoa(ThongTinChiTieuDTO TTCT) {
        return this.TTCTDAL.deleteHangHoa(TTCT);
    }

    public int insertTTCT(ThongTinChiTieuDTO TTCT) {
        return this.TTCTDAL.insertTTCT(TTCT);
    }
}
