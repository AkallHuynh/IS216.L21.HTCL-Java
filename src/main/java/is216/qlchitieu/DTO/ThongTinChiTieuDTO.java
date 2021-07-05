/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is216.qlchitieu.DTO;

/**
 *
 * @author HP
 */
public class ThongTinChiTieuDTO {

    //Table gioihanchitieu
    private double tongChiTieuThang;

    public double gettongChiTieuThang() {
        return tongChiTieuThang;
    }

    public void settongChiTieuThang(double tongChiTieuThang) {
        this.tongChiTieuThang = tongChiTieuThang;
    }

    //Table TieuDung
    private String maTieuDung, tenHangHoa;
    private int soLuong, loaiChiTieu;
    private double thanhTien;

    public String getmaTieuDung() {
        return maTieuDung;
    }

    public void setmaTieuDung(String maTieuDung) {
        this.maTieuDung = maTieuDung;
    }

    public String getTenHangHoa() {
        return tenHangHoa;
    }

    public void setTenHangHoa(String tenHangHoa) {
        this.tenHangHoa = tenHangHoa;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getLoaiChiTieu() {
        return loaiChiTieu;
    }

    public void setLoaiChiTieu(int loaiChiTieu) {
        this.loaiChiTieu = loaiChiTieu;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    //------------table ThongTinChiTieu--------------
    private String maChiTieu, ngayChi, tenDangNhap;
    private double luongTien;

    public String getMaChiTieu() {
        return maChiTieu;
    }

    public void setMaChiTieu(String maChiTieu) {
        this.maChiTieu = maChiTieu;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public double getLuongTien() {
        return luongTien;
    }

    public void setLuongTien(double luongTien) {
        this.luongTien = luongTien;
    }

    public String getNgayChi() {
        return ngayChi;
    }

    public void setNgayChi(String ngayChi) {
        this.ngayChi = ngayChi;
    }

    public ThongTinChiTieuDTO() {

    }

    /*public ThongTinChiTieuDTO(String maTieuDung, String tenHH, int SL, int LCT, double TT) {
        this.maTieuDung = maTieuDung;
        this.tenHangHoa = tenHH;
        this.soLuong = SL;
        this.loaiChiTieu = LCT;
        this.thanhTien = TT;*
    }*/
}
