package com.felix.general.code.learning.zone.sort;

import java.util.Arrays;

/**
 * O(n^2)
 * 冒泡排序，从前到后如果后面的元素值小于前面的元素，交换二者
 * 类似于水中的泡泡，不断向上冒出
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2023-10-05
 */
public class BubbleSort {
    public int[] sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }

    private void swap(int[] nums, int x, int y) {
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
