package com.felix.general.code.daily.practice.leetcode.face;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-01-23
 */
public class MajorityElementII {
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> ret = new ArrayList<>(2);
        int major1 = Integer.MIN_VALUE, major2 = Integer.MIN_VALUE, count1  = 0, count2 = 0;
        for (int num : nums) {
            if (count1 == 0 && num != major2) {
                major1 = num;
                count1++;
            } else if (count2 == 0 && num != major1) {
                major2 = num;
                count2++;
            } else {
                if (num == major1) {
                    count1++;
                } else if (num == major2) {
                    count2++;
                } else {
                    count1--;
                    count2--;
                }
            }
        }
        int count = 0;
        for (int num : nums) {
            if (num == major1) {
                count++;
            }
        }
        if (count > nums.length / 3) {
            ret.add(major1);
        }
        count = 0;
        for (int num : nums) {
            if (num == major2) {
                count++;
            }
        }
        if (count > nums.length / 3 && major1 != major2) {
            ret.add(major2);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0};
        List<Integer> res = majorityElement(nums);
        System.out.println(res);
    }
}
