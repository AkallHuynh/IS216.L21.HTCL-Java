/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author huynh
 */
public class GioiHanChiTieuDTO {
    private String maGioiHan, tenDangNhap;
    private int gioiHan;
    private double tongChiTieuThang;

    public void setMaGioiHan(String maGioiHan) {
        this.maGioiHan = maGioiHan;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public void setGioiHan(int gioiHan) {
        this.gioiHan = gioiHan;
    }

    public void setTongChiTieuThang(double tongChiTieuThang) {
        this.tongChiTieuThang = tongChiTieuThang;
    }

    public String getMaGioiHan() {
        return maGioiHan;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public int getGioiHan() {
        return gioiHan;
    }

    public double getTongChiTieuThang() {
        return tongChiTieuThang;
    }
}
