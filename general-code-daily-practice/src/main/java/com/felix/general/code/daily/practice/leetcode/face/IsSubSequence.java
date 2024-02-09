package com.felix.general.code.daily.practice.leetcode.face;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

 * Example 1:

 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:

 * Input: s = "axc", t = "ahbgdc"
 * Output: false

 * Constraints:

 * 0 <= s.length <= 100
 * 0 <= t.length <= 104
 * s and t consist only of lowercase English letters.
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-01
 */
public class IsSubSequence {
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        for (char c : s.toCharArray()) {
            boolean find = false;
            while (j < t.length()) {
                if (c == t.charAt(j++)) {
                    find = true;
                    break;
                }
            }
            if (!find) {
                return false;
            }
        }
        return true;
    }
}
