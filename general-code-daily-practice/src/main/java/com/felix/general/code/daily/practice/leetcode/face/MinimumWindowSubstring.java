package com.felix.general.code.daily.practice.leetcode.face;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-09
 */
public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        Map<Character, Integer> tmap = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (tmap.containsKey(c)) {
                int count = tmap.get(c) + 1;
                tmap.put(c, count);
            } else {
                tmap.put(c, 1);
            }
        }
        int left = 0, right = 0, sum = 0;
        int l = 0, r = 0, minLen = s.length() + 1;
        // 滑动窗口
        while (left <= right && right < s.length()) {
            char c = s.charAt(right);
            // 窗口右移动，统计t字符串中字符在s字符串中出现的次数
            if (tmap.containsKey(c)) {
                int count = tmap.get(c);
                // t字符串中对应字符串需要出现的次数还未满足，此时+1
                if (count > 0) {
                    sum++;
                }
                // 将目标字符数量-1，因为已经出现了一个；注意，当count为负数时，表面目标字符出现次数已经多了，当窗口左移动时，可以继续左移
                count--;
                tmap.put(c, count);
            }
            // t中字符串，在left--right区间全部出现
            if (sum == t.length()) {
                // 满足
                if (right - left + 1 < minLen) {
                    l = left;
                    r = right;
                    minLen = right - left + 1;
                }

                // 窗口左移，减少窗口size
                while (left <= right) {
                    char d = s.charAt(left);
                    // 左移遇到目标字符串中的字符，此时将map中的count+1
                    if (tmap.containsKey(d)) {
                        int temp = tmap.get(d);
                        temp++;
                        // 当目标字符map中的count为0时，表明不能继续左移
                        if (temp > 0) {
                            // 记录左移后的size
                            if (right - left + 1 < minLen) {
                                l = left;
                                r = right;
                                minLen = right - left + 1;
                            }
                            break;
                        }
                        tmap.put(d, temp);
                    }
                    left++;
                }
            }
            right++;
        }
        if (minLen > s.length()) return "";
        return s.substring(l, r + 1);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String ans = minWindow(s, t);
        System.out.println("result: " + ans);
    }
}
