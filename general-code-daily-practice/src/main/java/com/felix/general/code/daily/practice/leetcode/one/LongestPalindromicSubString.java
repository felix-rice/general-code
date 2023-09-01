package com.felix.general.code.daily.practice.leetcode.one;

/**
 * Given a string s, return the longest palindromic substring in s.
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2023-08-09
 */
public class LongestPalindromicSubString {
    /**
     * 暴力解法，时间复杂度n^3，空间复杂度1
     *
     * @param s 字符串
     * @return 返回最长回文子串
     */
    private static String violentSolution(String s) {
        int left = 0, right = 0, length = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (judgePalindromic(s, i, j)) {
                    if (length < j - i + 1) {
                        length = j - i + 1;
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }
    private static boolean judgePalindromic(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
    private static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        return dpSolution(s);
    }

    /**
     * 动态规划解法，时间复杂度n^2，空间复杂度n^2
     * p[i,i] = true
     * p[i,i+1] = true s[i] == s[i+1]
     * p[i,j] = true, if p[i + 1, j - 1] && s[i] == s[j]
     * 注意，递归过程中，按照子串的长度开始递归，例如:
     *      step_1: 当子串长度为1，从字符串[0, 0] [1, 1] ... [j, j]，都为true
     *      step_2: 当子串长度为2，从字符串[0, 1] [1, 2] ... [j, j + 1]，判断依据 s[j] == s[j + 1]
     *      step_3: 当子串长度为3，从字符串[0, 2] [1, 3] ... [j, j + 2]，判断依据 [1, 1] [2, 2]... [j + 1, j + 2 - 1] ---> 依据来自step_1
     *      step_4: 当子串长度为4，从字符串[0, 3] [1, 4] ... [j, j + 4]，判断依据 [1, 2] [2, 3]... [j + 1, j + 3 - 1] ---> 依据来自step_2
     *      step_5: 当子串长度为5，从字符串[0, 4] [1, 5] ... [j, j + 5]，判断依据 [1, 3] [2, 4]... [j + 1, j + 5 - 1] ---> 依据来自step_3
     *      ......
     *      step_i: 当子串长度为i，从字符串[0, i] [1, i + 1] ... [j, j+i]，判断依据 [1, i - 1] [2, i]... [j + 1, j + i - 1] ---> ---> 依据来自step_i-2
     */
    private static String dpSolution(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
            }
        }

        for (int i = 2; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                // 子串是回文串，子串左右扩展1个字符，且字符相等，则新串还是回文串
                if (dp[j + 1][j + i - 1] && s.charAt(j) == s.charAt(j + i)) {
                    dp[j][j + i] = true;
                }
            }
        }

        int left = 0, right = 0, length = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (dp[i][j]) {
                    if (j - i + 1 > length) {
                        left = i;
                        right = j;
                        length = j - i + 1;
                    }
                }
            }
        }

        return s.substring(left, right + 1);
    }

    private static String centerSpreadSolution(String s) {
        return null;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
