package com.felix.general.code.daily.practice.leetcode.one;

import com.felix.general.code.daily.practice.leetcode.common.TreeNode;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2023-09-23
 */
public class BalanceBinaryTree {
    public boolean ret = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        depth(root);
        return ret;
    }

    private int depth(TreeNode root) {
        if (root == null || !ret) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            ret = false;
            return 0;
        } else {
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}
