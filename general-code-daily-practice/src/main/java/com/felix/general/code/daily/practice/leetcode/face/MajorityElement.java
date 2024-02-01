package com.felix.general.code.daily.practice.leetcode.face;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-01-23
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == major) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    major = nums[i];
                    count = 1;
                }
            }
        }
        return major;
    }
}
