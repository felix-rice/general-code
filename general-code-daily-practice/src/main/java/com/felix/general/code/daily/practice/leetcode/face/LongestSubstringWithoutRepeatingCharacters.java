package com.felix.general.code.daily.practice.leetcode.face;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-06
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> window = new HashSet<>();
        int left = 0, right = 0, n = s.length(), longest = 0;
        while (left <= right && right < n) {
            char cur = s.charAt(right);
            while (window.contains(cur) && left <= right) {
                if (s.charAt(left++) == cur) {
                    window.remove(cur);
                    break;
                }
                window.remove(cur);
            }
            window.add(cur);
            right++;
            longest = Math.max(longest, right - left);
        }
        return longest;
    }

    public static void main(String[] args) {
        int tmmzuxt = lengthOfLongestSubstring("tmmzuxt");
        System.out.println(tmmzuxt);
    }

}
