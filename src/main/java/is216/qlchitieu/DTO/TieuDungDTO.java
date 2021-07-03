/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is216.qlchitieu.DTO;

/**
 *
 * @author huynh
 */
public class TieuDungDTO {
    private String maTieuDung, tenHangHoa;
    private int loaiChiTieu, soLuong;
    private double thanhTien;

    public void setMaTieuDung(String maTieuDung) {
        this.maTieuDung = maTieuDung;
    }

    public void setTenHangHoa(String tenHangHoa) {
        this.tenHangHoa = tenHangHoa;
    }

    public void setLoaiChiTieu(int loaiChiTieu) {
        this.loaiChiTieu = loaiChiTieu;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getMaTieuDung() {
        return maTieuDung;
    }

    public String getTenHangHoa() {
        return tenHangHoa;
    }

    public int getLoaiChiTieu() {
        return loaiChiTieu;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getThanhTien() {
        return thanhTien;
    }
}
