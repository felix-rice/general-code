package com.felix.general.code.daily.practice.leetcode.one;

import com.felix.general.code.daily.practice.leetcode.common.TreeNode;

/**
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2023-09-23
 */
public class ValidateBinarySearchTree {
    boolean result = true;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        postOrder(root);
        return result;
    }

    private int[] postOrder(TreeNode root) {
        // 如果已经判断出来不是二叉搜索树，则直接返回0，快速结束
        if (!result || root == null) {
            return new int[2];
        }
        int[] cur = new int[2];
        cur[0] = root.val;
        cur[1] = root.val;
        if (root.left != null) {
            int[] ret = postOrder(root.left);
            if (ret[1] >= root.val) {
                result = false;
                return cur;
            } else {
                cur[0] = ret[0];
            }
        }

        if (root.right != null) {
            int[] ret = postOrder(root.right);
            if (ret[0] <= root.val) {
                result = false;
                return cur;
            } else {
                cur[1] = ret[1];
            }
        }

        return cur;
    }
}
