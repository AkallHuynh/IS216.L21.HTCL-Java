/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is216.qlchitieu.DTO;

import java.util.Date;

/**
 *
 * @author huynh
 */
public class ChiTieuDTO {
    private String maChiTieu, tenDangNhap, maTieuDung;
    private double luongTien;
    private java.util.Date ngayChi;

    public void setMaChiTieu(String maChiTieu) {
        this.maChiTieu = maChiTieu;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public void setMaTieuDung(String maTieuDung) {
        this.maTieuDung = maTieuDung;
    }

    public void setLuongTien(double luongTien) {
        this.luongTien = luongTien;
    }

    public void setNgayChi(Date ngayChi) {
        this.ngayChi = ngayChi;
    }

    public String getMaChiTieu() {
        return maChiTieu;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public String getMaTieuDung() {
        return maTieuDung;
    }

    public double getLuongTien() {
        return luongTien;
    }

    public Date getNgayChi() {
        return ngayChi;
    }
}
