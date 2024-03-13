package com.felix.general.code.daily.practice.leetcode.face;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import com.felix.general.code.daily.practice.common.data.struct.TreeNode;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-23
 */
public class KthLargestSumInBinaryTree {
    public long kthLargestLevelSum(TreeNode root, int k) {
        long[] nums = new long[10];
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int point = 0;
        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                TreeNode cur = queue.poll();
                nums[point] += cur.val;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            point++;
        }
        System.out.println(Arrays.toString(nums));
        return findKth(nums, 0, point - 1, k);
    }

    private long findKth(long[] nums, int begin, int end, int k) {
        if (begin == end) return nums[begin];
        long pos = nums[begin];
        int left = begin;
        int right = end;
        while (left < right) {
            while (left < right && nums[right] >= pos) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] < pos) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pos;
        if (k == left) return pos;
        else if (k < left) return findKth(nums, begin, left - 1, k);
        else return findKth(nums, left + 1, end, k);
    }

    public static void main(String[] args) {
        long[] nums = new long[] {5, 17, 13, 0, 0, 0, 0, 0, 0, 0};
        KthLargestSumInBinaryTree kthLargestSumInBinaryTree = new KthLargestSumInBinaryTree();
        long ans = kthLargestSumInBinaryTree.findKth(nums, 0, 6, 3);
        System.out.println(ans);
    }
}
