package com.felix.general.code.daily.practice.leetcode.one;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-01-06
 */
public class RotateArray {
    /**
     * 输入: nums = [1,2,3,4,5,6,7], k = 3 输出: [5,6,7,1,2,3,4] 解释:
     * 向右轮转 1 步: [7,1,2,3,4,5,6]
     * 向右轮转 2 步: [6,7,1,2,3,4,5]
     * 向右轮转 3 步: [5,6,7,1,2,3,4]
     */
    public static void rotate1(int[] nums, int k) {
        int step = k % nums.length;
        // 翻转整个数组
        reverse(nums, 0, nums.length - 1);
        // 翻转前半部分
        reverse(nums, 0, step - 1);
        // 翻转后半部分
        reverse(nums, step, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (end > start) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    /**
     * 1. 从一个数开始，移动多少次能回到原点：
     *      an = kb (走了a圈，走了b个点)
     *      an 是n的倍数也是k的倍数，第一次到起点就停止了，因此a要足够下，即an是（n， k）的最小公倍数
     *      lcm(n, k) = kb
     *      b = lcm(n, k) / k
     *      圈数： n / b  --- nk / lcm(n, k) --- gcd(n, k) 【两数乘积 / 两数最小公倍数 = 两数最大公约数】
     */
    public static void rotate(int[] nums, int k) {
        int step = k % nums.length;
        int count = gcd(nums.length, step);
        for (int start = 0; start < count; start++) {
            int prev = nums[start];
            int current = start;
            do {
                int next = (current + step) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }


    private static int gcd(int dividend, int divisor) {
        if (divisor == 0) return dividend;
        int mod = dividend % divisor;
        return gcd(divisor, mod);
    }
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5,6,7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
