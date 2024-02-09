package com.felix.general.code.daily.practice.leetcode.face;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

 * Find two lines that together with the x-axis form a container, such that the container contains the most water.

 * Return the maximum amount of water a container can store.
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-02
 */
public class ContainerWithMostWater {
    // O(n^2)
    public int maxArea0(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int w = Math.min(height[i], height[j]);
                int y = j - i;
                max = Math.max(max, w * y);
            }
        }
        return max;
    }

    public int maxArea1(int[] height) {
        int left = height[0], right = height[height.length - 1];
        int max = 0;
        while (left < right) {
            int width = right - left;
            int len = Math.min(height[left], height[right]);
            max = Math.max(max, width * len);

        }
        return 0;
    }
}
