package com.example.thi.service;

import com.example.thi.entity.SinhVien;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinhVienServiceTest {

    SinhVienService service = new SinhVienService();

    @Test
    public void testAddThanhCong() {
        SinhVien sv = new SinhVien("PH01", "Duc", 20, 8.5f, 5, "UDPM");
        service.addSinhVien(sv);
        Assertions.assertEquals(1, service.getAll().size());
    }

    // Test thêm thất bại khi để trống mã SV (Validate)
    @Test
    public void testAddTrongMa() {
        SinhVien sv = new SinhVien("", "Duc", 20, 8.5f, 5, "UDPM");
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.addSinhVien(sv));
    }

    // Test thêm thất bại khi tên là khoảng trắng (Validate)
    @Test
    public void testAddTenKhoangTrang() {
        SinhVien sv = new SinhVien("PH02", "   ", 20, 8.5f, 5, "UDPM");
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.addSinhVien(sv));
    }

    // Test sửa thành công
    @Test
    public void testUpdateThanhCong() {
        service.addSinhVien(new SinhVien("PH03", "Duc", 20, 8f, 5, "IT"));
        SinhVien svMoi = new SinhVien("PH03", "Huy Duc", 21, 9f, 6, "IT");

        boolean result = service.updateSinhVien("PH03", svMoi);
        Assertions.assertTrue(result);
        Assertions.assertEquals("Huy Duc", service.getAll().get(0).getTen());
    }

    // Test sửa khi mã không tồn tại
    @Test
    public void testUpdateMaKhongTonTai() {
        SinhVien svMoi = new SinhVien("PH99", "Update", 21, 9f, 6, "IT");
        boolean result = service.updateSinhVien("PH99", svMoi);
        Assertions.assertFalse(result);
    }
}