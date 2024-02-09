package com.felix.general.code.daily.practice.leetcode.face;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-09
 */
public class WordBreak {
    /**
     * 超时
     */
    public static boolean wordBreak0(String s, List<String> wordDict) {
        if (Objects.equals(s, "")) return true;
        boolean ans = false;
        for (int i = 0; i < wordDict.size(); i++) {
            String cur = wordDict.get(i);
            boolean wordMatch = true;
            if (s.length() < cur.length()) {
                wordMatch = false;
            } else {
                for (int j = 0; j < cur.length(); j++) {
                    if (cur.charAt(j) != s.charAt(j)) {
                        wordMatch = false;
                        break;
                    }
                }
            }
            if (wordMatch) {
                ans = wordBreak0(s.substring(cur.length()), wordDict);
            }

        }
        return ans;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (Objects.equals(s, "")) return true;
        // 存所有word
        Set<String> wordSet = new HashSet<>();
        // 统计word length
        Set<Integer> wordLenSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
            wordLenSet.add(word.length());
        }

        // dp[i]表示从首字符到当前字符，长度i的字符串能够由word组成
        int[] dp = new int[s.length() + 1];
        // 0表示空字符串，必定可以构成
        dp[0] = 1;
        // 遍历s上全部字符
        for (int i = 1; i < dp.length; i++) {
            // 从s当前字符，向前切割字符串，判断wordSet中是否存在
            for (Integer len : wordLenSet) {
                // 切片的起点
                int begin = i - len;
                // 向前不够切片word长度，跳过
                if (begin < 0) continue;
                // 向前虽然切出word长度字符串，但是前一个位置字符串不能由word构成，跳过
                if (dp[begin] != 1) continue;
                // 切出字符
                String piece = s.substring(begin, i);
                // 包含字符串
                if (wordSet.contains(piece)) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[s.length()] == 1;
    }


    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        boolean b = wordBreak(s, wordDict);
        System.out.println("result: " + b);
    }
}
