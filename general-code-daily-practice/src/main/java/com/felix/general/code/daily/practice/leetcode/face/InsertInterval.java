package com.felix.general.code.daily.practice.leetcode.face;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-10
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int begin = newInterval[0];
        int end = newInterval[1];
        // 0未找到， 1找到，2结束
        int status = 0;
        for(int i = 0; i < intervals.length; i++) {
            if (status == 2) {
                ans.add(intervals[i]);
                continue;
            }
            if (status == 0) {
                // i位置全部小于new
                if (intervals[i][1] < newInterval[0]) {
                    ans.add(intervals[i]);
                    continue;
                }
                // i位置全部大于new，且i-1位置全部小于new，插入new即可；[1,2] [7,8]  new [3,4]    [1,2][3,4][7,8]
                if (intervals[i][0] > newInterval[1]) {
                    ans.add(newInterval);
                    ans.add(intervals[i]);
                    status = 2;
                    continue;
                }
                // [[1,2],[3,5],[6,7],[8,10],[12,16]]   [4,8]
                // new [1, 4] [7, 13]new位置和i位置部分相交，1: [6, 9]  2:[6, 99] 3:[8, 9] 4:[8:99]
                // 1,3 一组 2，4一组
                if (intervals[i][1] >= newInterval[1]) {
                    begin = Math.min(newInterval[0], intervals[i][0]);
                    end = intervals[i][1];
                    int[] cur = new int[]{begin, end};
                    ans.add(cur);
                    status = 2;
                    continue;
                } else {
                    begin = Math.min(newInterval[0], intervals[i][0]);
                    end = newInterval[1];
                    status = 1;
                    continue;
                }
            }
            if (status == 1) {
                if (intervals[i][0] > end) {
                    int[] cur = new int[]{begin, end};
                    ans.add(cur);
                    ans.add(intervals[i]);
                    status = 2;
                } else if (intervals[i][1] >= end) {
                    end = intervals[i][1];
                    int[] cur = new int[]{begin, end};
                    ans.add(cur);
                    status = 2;
                }
            }
        }
        if (status != 2) {
            int[] cur = new int[]{begin, end};
            ans.add(cur);
        }
        int[][] ansArray = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            ansArray[i][0] = ans.get(i)[0];
            ansArray[i][1] = ans.get(i)[1];
        }
        return ansArray;
    }
}
