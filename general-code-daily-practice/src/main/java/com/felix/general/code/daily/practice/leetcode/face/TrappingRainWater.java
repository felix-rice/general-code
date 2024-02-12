package com.felix.general.code.daily.practice.leetcode.face;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-01-30
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length + 1];
        int[] rightMax = new int[height.length + 1];
        for (int i = 1; i <= height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int cur = Math.min(leftMax[i], rightMax[i]) - height[i];
            sum = cur > 0 ? sum + cur : sum;
        }
        return sum;
    }
    public static void main(String[] args) {
        char c = 'a';

        System.out.println(c);
    }
}
