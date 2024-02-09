package com.felix.general.code.daily.practice.leetcode.face;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-01
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
            if (minLen == 0) {
                return "";
            }
        }
        for (int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);
            boolean allEquals = true;
            for (String str : strs) {
                if (str.charAt(i) != c) {
                    allEquals = false;
                    break;
                }
            }
            if (!allEquals) {
                break;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
