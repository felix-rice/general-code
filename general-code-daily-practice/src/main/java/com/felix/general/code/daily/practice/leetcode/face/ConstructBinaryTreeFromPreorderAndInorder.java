package com.felix.general.code.daily.practice.leetcode.face;


import com.felix.general.code.daily.practice.common.data.struct.TreeNode;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-02-13
 */
public class ConstructBinaryTreeFromPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pl > pr) return null;
        TreeNode root = new TreeNode(preorder[pl]);
        if (pl == pr) {
            return root;
        }
        int pos = pl;
        for (int i = il; i <= ir; i++) {
            if (inorder[i] == preorder[pl]) {
                pos = i;
            }
        }
        int leftLength = pos - il;
        int rightLength = ir - pos;
        if (leftLength > 0) {
            root.left = buildTree(preorder, inorder, pl + 1, pl + leftLength, il, pos - 1);
        }
        if (rightLength > 0) {
            root.right = buildTree(preorder, inorder, pl + leftLength + 1, pr, pos + 1, ir);
        }
        return root;
    }


}
