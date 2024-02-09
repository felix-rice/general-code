package com.felix.general.code.daily.practice.leetcode.face;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-08
 */
public class LongestIncreasingSubsequence {
    /**
     * Example 1:
     * Input: nums = [10,9,2,5,3,7,101,18]
     * Output: 4
     * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
     * 1 <= nums.length <= 2500
     * -104 <= nums[i] <= 104
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int[] max = new int[nums.length];

        return 0;
    }
}
