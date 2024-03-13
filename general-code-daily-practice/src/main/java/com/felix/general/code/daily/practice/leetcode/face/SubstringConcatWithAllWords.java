package com.felix.general.code.daily.practice.leetcode.face;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-03-12
 */
public class SubstringConcatWithAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length(), m = words.length, l = words[0].length();
        for (int i = 0; i < n; i++) {
            if (i + m * l > n + 1) {
                break;
            }
            Map<String, Integer> wordCountMap = new HashMap<>();
            // 取words长度字符串
            for (int j = 1; j <= m; j++) {
                String cur = s.substring(i, j * l);
                wordCountMap.put(cur, wordCountMap.getOrDefault(cur, 0) + 1);
            }
            // 抵消word
            for (int j = 0; j < m; j++) {
                wordCountMap.put(words[j], wordCountMap.getOrDefault(words[j], 0) - 1);
            }
            for (int j = i; j < n - m * l + 1; j += l) {
                if (j != i) {
                    String rightWord = s.substring(j + l * m, j + (m + 1) * l);
                    wordCountMap.put(rightWord, wordCountMap.getOrDefault(rightWord, 0) + 1);
                    String leftWord = s.substring(j, j + l);
                    wordCountMap.put(leftWord, wordCountMap.getOrDefault(leftWord, 0) - 1);
                }
                if (wordCountMap.isEmpty()) {
                    ans.add(j);
                }
            }
        }
        return ans;
    }
}
