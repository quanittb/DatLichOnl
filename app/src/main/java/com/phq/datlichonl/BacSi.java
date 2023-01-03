package com.phq.datlichonl;

public class BacSi {
    private int id;
    private String ten , khoa , thongtin ;
    public BacSi(int id, String ten, String khoa, String thongtin) {
        this.id = id;
        this.ten = ten;
        this.khoa = khoa;
        this.thongtin = thongtin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BacSi() {
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getThongtin() {
        return thongtin;
    }

    public void setThongtin(String thongtin) {
        this.thongtin = thongtin;
    }
}
