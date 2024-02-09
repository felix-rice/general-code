package com.felix.general.code.daily.practice.leetcode.face;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-08
 */
public class FactorialTrailingZeroes {
    // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    // 5 * 偶数 = 0 10 自带0

    /**
     * 10因子个数 --> 2 * 5 质数因子，即5因子的个数
     *
     */
    public int trailingZeroes(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num % 10 == 0) {
                count++;
                num = num / 10;
            }
            while (num % 5 == 0) {
                count++;
                num = num / 5;
            }
        }
        return count;
    }
}
