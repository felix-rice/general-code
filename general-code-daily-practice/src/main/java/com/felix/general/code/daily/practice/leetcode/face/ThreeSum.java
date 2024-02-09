package com.felix.general.code.daily.practice.leetcode.face;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-07
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum0(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            List<Integer> idx;
            if (map.containsKey(target)) {
                idx = map.get(target);
            } else {
                idx = new ArrayList<>();
            }
            idx.add(i);
            map.put(target, idx);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j - 1 >= i + 1 && nums[j] == nums[j - 1]) continue;
                int target = nums[i] + nums[j];
                if (map.containsKey(target)) {
                    List<Integer> idxList = map.get(target);
                    for (int idx : idxList) {
                        if (idx > j) {
                            List<Integer> r = new ArrayList<>(3);
                            r.add(nums[i]);
                            r.add(nums[j]);
                            r.add(nums[idx]);
                            res.add(r);
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }


    /**
     * 相等情况
     * 1. a + b + c = 0
     * 2. a + b' + c' = 0
     * 3. b' > b ===> c' < c 只能向中间移动
     * 不等情况
     * 1. a + b + c > 0
     * 2. a + b + c' < 0 此时c不能再左移动，越向左和越小，达不到等于0的目标
     * 3. a + b' + c > 0 此时b必须向右移动变为b'   b' > b； 那么c能向再向右移动呢，显然不行，因为 3等式结果大于1等式 > 0，故c必须不能向右移动
     * 4. a + b' + c'
     * 结论：只能从两边向中间移动
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            int third = nums.length - 1;
            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) continue;
                int target = -nums[first];

                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                if (second == third) break;
                if (nums[third] + nums[second] + nums[first] == 0) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[first]);
                    cur.add(nums[second]);
                    cur.add(nums[third]);
                    res.add(cur);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = new int[] {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}
