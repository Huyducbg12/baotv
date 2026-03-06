package com.example.thi.service;

import com.example.thi.entity.SanPham;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SanPhamServiceTest {
    SanPhamService service;

    @BeforeEach
    void setup() {
        service = new SanPhamService();
    }

    @Test
    void testUpdateValid() {
        SanPham sp = new SanPham("SP1", "Laptop", 2, 1000, 10, "DT");
        service.add(sp);
        SanPham spMoi = new SanPham("SP1", "Laptop Pro", 3, 1500, 5, "DT");
        service.update(spMoi, "SP1");
        assertEquals("Laptop Pro", service.getAll().get(0).getTen());
    }

    @Test
    void testUpdateNull() {
        assertThrows(IllegalArgumentException.class, () -> service.update(null, "SP1"));
    }

    @Test
    void testUpdateWithAm() {
        SanPham sp = new SanPham("SP1", "Laptop", 2, 1000, 10, "DT");
        service.add(sp);
        SanPham spMoi = new SanPham("SP1", "Laptop", -1, 1000, 10, "DT");
        service.update(spMoi, "SP1");
        assertEquals(-1, service.getAll().get(0).getNamBaohanh());
    }
    @Test
        void testUpdateWithSL0() {
            SanPham sp = new SanPham("SP1", "Laptop", 2, 1000, 10, "DT");
            service.add(sp);
            SanPham spMoi = new SanPham("SP1", "Laptop", 2, 1000, 0, "DT");
            service.update(spMoi, "SP1");
            assertEquals(0, service.getAll().get(0).getSoLuong());
        }
    @Test
    void testUpdateWith() {
         SanPham sp = new SanPham("SP100", "Laptop", 2, 1000, 10, "");
         service.update(sp,"SP100");
         assertTrue(service.getAll().isEmpty());
    }
}