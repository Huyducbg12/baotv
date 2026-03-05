package com.example.thi;

public class ArrayUtils {
    public int tinhTong(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Mảng không được null");
        }
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}
