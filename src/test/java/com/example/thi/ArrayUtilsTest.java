package com.example.thi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {

    ArrayUtils arrayUtils = new ArrayUtils();

    @Test
    public void testTongSoDuong() {
        int[] arr = {1, 2, 3, 4, 5};
        int expected = 15;
        Assertions.assertEquals(expected, arrayUtils.tinhTong(arr));
    }

    @Test
    public void testTongCoSoAm() {
        int[] arr = {-1, -2, 3};
        int expected = 0;
        Assertions.assertEquals(expected, arrayUtils.tinhTong(arr));
    }

    @Test
    public void testMangRong() {
        int[] arr = {};
        int expected = 0;
        Assertions.assertEquals(expected, arrayUtils.tinhTong(arr));
    }

    @Test
    public void testMangMotPhanTu() {
        int[] arr = {10};
        int expected = 10;
        Assertions.assertEquals(expected, arrayUtils.tinhTong(arr));
    }

    @Test
    public void testMangGiaTriBien() {
        int[] arr = {Integer.MAX_VALUE, 0};
        int expected = Integer.MAX_VALUE;
        Assertions.assertEquals(expected, arrayUtils.tinhTong(arr));
    }
}