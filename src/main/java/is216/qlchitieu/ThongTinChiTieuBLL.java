/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is216.qlchitieu.BLL;

import is216.qlchitieu.DTO.ThongTinChiTieuDTO;
import is216.qlchitieu.DAL.ThongTinChiTieuDAL;

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
