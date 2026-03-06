package com.example.thi.service;


import com.example.thi.entity.SanPham;

import java.util.ArrayList;
import java.util.List;

public class SanPhamService {
    private List<SanPham> list = new ArrayList<>();

    public void add(SanPham sp) {
        list.add(sp);
    }

    public void update(SanPham sp, String ma) {
        if (sp == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMa().equals(ma)) {
                list.set(i, sp);
                return;
            }
        }
    }

    public List<SanPham> getAll() {
        return list;
    }
}