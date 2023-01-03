package com.phq.datlichonl;

public class LichKham {
    private int id ;
    private String taikhoan,tenbenhnhan, tenbs , khoa , gio , ngay ;

    public LichKham() {
    }

    public LichKham(int id,String tenbenhnhan, String tenbs, String khoa, String ngay, String gio,String taikhoan) {
        this.id = id;
        this.tenbenhnhan = tenbenhnhan;
        this.tenbs = tenbs;
        this.khoa = khoa;
        this.gio = gio;
        this.ngay = ngay;
        this.taikhoan = taikhoan;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getTenbenhnhan() {
        return tenbenhnhan;
    }

    public void setTenbenhnhan(String tenbenhnhan) {
        this.tenbenhnhan = tenbenhnhan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenbs() {
        return tenbs;
    }

    public void setTenbs(String tenbs) {
        this.tenbs = tenbs;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }
}
