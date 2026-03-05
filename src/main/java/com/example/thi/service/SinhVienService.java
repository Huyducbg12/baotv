package com.example.thi.service;

import com.example.thi.entity.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {
    private List<SinhVien> listSV = new ArrayList<>();
    public void addSinhVien(SinhVien sv) {
        if (sv.getMaSV() == null || sv.getMaSV().isBlank() ||
                sv.getTen() == null || sv.getTen().isBlank() ||
                sv.getChuyenNganh() == null || sv.getChuyenNganh().isBlank()) {
            throw new IllegalArgumentException("Các trường không được để trống");
        }
        listSV.add(sv);
    }
    public boolean updateSinhVien(String maSV, SinhVien svMoi) {
        for (int i = 0; i < listSV.size(); i++) {
            if (listSV.get(i).getMaSV().equals(maSV)) {
                listSV.set(i, svMoi);
                return true;
            }
        }
        return false;
    }

    public List<SinhVien> getAll() {
        return listSV;
    }
}