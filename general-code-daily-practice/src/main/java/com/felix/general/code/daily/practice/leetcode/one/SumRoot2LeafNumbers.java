package com.felix.general.code.daily.practice.leetcode.one;

import com.felix.general.code.daily.practice.leetcode.common.TreeNode;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2023-09-23
 */
public class SumRoot2LeafNumbers {
    int sumVal = 0;
    public int sumNumbers(TreeNode root) {
        sum(root, 0);
        return sumVal;
    }

    private void sum(TreeNode root, int parentVal) {
        if (root == null) {
            return;
        }
        parentVal *= 10;
        parentVal += root.val;
        if (root.left == null && root.right == null) {
            sumVal += parentVal;
        } else {
            sum(root.left, parentVal);
            sum(root.right, parentVal);
        }
    }
}
