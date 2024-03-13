package com.felix.general.code.daily.practice.leetcode.face;

import java.util.Arrays;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-28
 */
public class KthLargestInArray {
    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSort(nums, 0, n - 1, n - k);
    }

    private static int buildMaxHeap(int[] nums, int k) {
        int[] heap = new int[k];
        for (int i = 0; i < k; i++) {
            heap[i] = nums[i];
            adjustUp(heap, i);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] <= heap[0]) continue;
            heap[0] = nums[i];
            adjustDown(heap);
        }
        return heap[0];
    }

    private static void adjustUp(int[] nums, int idx) {
        if (idx <= 0) return;
        // 2 * parent + 1 = leftIdx; 2 * parent + 2 = rightIdx;
        // parent = (leftIdx - 1) / 2; parent = (rightIdx - 2) / 2 --> (idx - 1) / 2
        int parentIdx = (idx - 1) / 2;
        while (parentIdx >= 0) {
            if (nums[idx] < nums[parentIdx]) {
                swap(nums, parentIdx, idx);
                idx = parentIdx;
                parentIdx = (idx - 1) / 2;
            } else {
                break;
            }
        }
    }

    private static void adjustDown(int[] heap) {
        if (heap.length <= 1) return;
        // 2 * parent + 1 = leftIdx; 2 * parent + 2 = rightIdx;
        // parent = (leftIdx - 1) / 2; parent = (rightIdx - 2) / 2 --> (idx - 1) / 2
        int parent = 0;
        while (true) {
            int leftChild = 2 * parent + 1;
            int rightChild = 2 * parent + 2;
            if (leftChild >= heap.length && rightChild >= heap.length) break;
            int smallerChildIdx = -1;
            if (leftChild < heap.length) {
                smallerChildIdx = leftChild;
            }
            if (rightChild < heap.length) {
                smallerChildIdx = smallerChildIdx == -1 ? rightChild
                        : heap[leftChild] < heap[rightChild] ? leftChild : rightChild;
            }
            if (heap[parent] > heap[smallerChildIdx]) {
                swap(heap, parent, smallerChildIdx);
                parent = smallerChildIdx;
            } else {
                break;
            }
        }
    }

    private static void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
    private static int quickSort(int[] nums, int left, int right, int k) {
        if (left == right) return nums[left];
        int pos = nums[left];
        int begin = left, end = right;
        while (begin < end) {
            while (begin < end && nums[end] >= pos) end--;
            if (begin < end) {
                nums[begin] = nums[end];
            }
            while(begin < end && nums[begin] < pos) begin++;
            if (begin < end) {
                nums[end] = nums[begin];
            }
        }
        nums[begin] = pos;
        if (begin == k) return nums[begin];
        else if (begin < k) return quickSort(nums, begin + 1, right, k);
        else return quickSort(nums, left, begin - 1, k);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,1,5,6,4};
        Arrays.sort(nums);
        int ans = findKthLargest(nums, 2);
        System.out.println(Arrays.toString(nums));
        System.out.println(ans);
    }
}
