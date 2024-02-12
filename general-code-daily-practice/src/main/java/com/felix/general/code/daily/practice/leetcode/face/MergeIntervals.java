package com.felix.general.code.daily.practice.leetcode.face;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-10
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> ans = new ArrayList<>();
        int row = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        int begin = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < row; i++) {
            if (intervals[i][0] <= end) {
                end = intervals[i][1];
            } else {
                List<Integer> cur = new ArrayList<>();
                cur.add(begin);
                cur.add(end);
                ans.add(cur);
                begin = intervals[i][0];
                end = intervals[i][1];
            }
        }
        List<Integer> cur = new ArrayList<>();
        cur.add(begin);
        cur.add(end);
        ans.add(cur);
        int[][] ansArray = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            ansArray[i][0] = ans.get(i).get(0);
            ansArray[i][1] = ans.get(i).get(1);
        }
        return ansArray;
    }
}
