package com.example.thi;

import com.example.thi.entity.SanPham;
import com.example.thi.service.SanPhamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {
    MathUtils mathUtils = new MathUtils();

    @Test
    void testCalculateSumWithPositiveN() {
        assertEquals(9, mathUtils.calculateSumOfOdds(5));
    }

    @Test
    void testCalculateSumWithNIsOne() {
        assertEquals(1, mathUtils.calculateSumOfOdds(1));
    }

    @Test
    void testCalculateSumWithNIsZero() {
        assertEquals(0, mathUtils.calculateSumOfOdds(0));
    }

    @Test
    void testCalculateSumWithNegativeN() {
        assertEquals(0, mathUtils.calculateSumOfOdds(-5));
    }

    @Test
    void testCalculateSumWithLargeN() {
        assertEquals(25, mathUtils.calculateSumOfOdds(10));
    }

    static class SanPhamServiceTest {
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
        void testUpdateWithInvalidWarranty() {
            SanPham sp = new SanPham("SP1", "Laptop", 2, 1000, 10, "DT");
            service.add(sp);
            SanPham spMoi = new SanPham("SP1", "Laptop", -1, 1000, 10, "DT");
            service.update(spMoi, "SP1");
            assertEquals(-1, service.getAll().get(0).getNamBaohanh());
        }

        @Test
        void testUpdateWithZeroQuantity() {
            SanPham sp = new SanPham("SP1", "Laptop", 2, 1000, 10, "DT");
            service.add(sp);
            SanPham spMoi = new SanPham("SP1", "Laptop", 2, 1000, 0, "DT");
            service.update(spMoi, "SP1");
            assertEquals(0, service.getAll().get(0).getSoLuong());
        }

        @Test
        void testUpdateNonExistent() {
            SanPham spMoi = new SanPham("SP99", "No", 1, 100, 1, "No");
            service.update(spMoi, "SP99");
            assertTrue(service.getAll().isEmpty());
        }
    }
}