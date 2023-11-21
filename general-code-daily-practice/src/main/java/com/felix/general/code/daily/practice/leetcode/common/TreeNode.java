package com.felix.general.code.daily.practice.leetcode.common;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2023-09-23
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;
    public TreeNode() {}
    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
