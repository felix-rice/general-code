package com.felix.general.code.daily.practice.leetcode.face;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-17
 */
public class MinNumArrow2BurstBalloon {
    public static int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> {
            return a[1] - b[1];
        });
        int rightMin = points[0][1];
        int ans = 1;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] > rightMin) {
                rightMin = points[i][1];
                ++ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}};
        // int[][] points = new int[][]{{-2,-3},{1,2}, {3, 0}};
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        System.out.println(Arrays.deepToString(points));
    }
}
