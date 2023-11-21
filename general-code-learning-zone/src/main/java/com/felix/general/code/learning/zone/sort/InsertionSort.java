package com.felix.general.code.learning.zone.sort;

import java.util.Arrays;

/**
 * O(n^2)
 * 每次找到最大或最小元素，插入到对应位置
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2023-10-05
 */
public class InsertionSort {
    public int[] sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIdx = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[minIdx]) {
                    minIdx = j;
                }
            }
            swap(nums, minIdx, i);
        }
        return nums;
    }

    private void swap(int[] nums, int x, int y) {
        if (x == y) return;
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8,6,5,4,3,9,1,0};
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println(Arrays.toString(bubbleSort.sort(nums)));
    }
}
