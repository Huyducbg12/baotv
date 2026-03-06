package com.example.thi.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class SanPham {
    //Tạo class SanPham gồm các thuộc tính ma - String , ten - String,
    //namBaoHanh - int, gia - float, soLuong - int, danhMuc - String 
    String ma;
    String ten;
    int namBaohanh;
    float gia;
    int soLuong;
    String danhMuc;

    public SanPham() {
    }

    public SanPham(String ma, String ten, int namBaohanh, float gia, int soLuong, String danhMuc) {
        this.ma = ma;
        this.ten = ten;
        this.namBaohanh = namBaohanh;
        this.gia = gia;
        this.soLuong = soLuong;
        this.danhMuc = danhMuc;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getNamBaohanh() {
        return namBaohanh;
    }

    public void setNamBaohanh(int namBaohanh) {
        this.namBaohanh = namBaohanh;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }
}
