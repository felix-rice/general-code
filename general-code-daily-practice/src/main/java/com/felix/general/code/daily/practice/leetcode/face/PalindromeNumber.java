package com.felix.general.code.daily.practice.leetcode.face;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-08
 */
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int newNum = 0, oldNum = x;
        while (oldNum > 0) {
            int digit = oldNum % 10;
            newNum *= 10;
            newNum += digit;
            oldNum /= 10;
        }
        return newNum == x;
    }

    public static void main(String[] args) {
        isPalindrome(121);
    }
}
