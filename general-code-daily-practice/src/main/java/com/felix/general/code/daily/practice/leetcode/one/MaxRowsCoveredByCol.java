package com.felix.general.code.daily.practice.leetcode.one;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2024-01-04
 */
public class MaxRowsCoveredByCol {
    public static int maximumRows(int[][] matrix, int numSelect) {
        int colLen = matrix[0].length, rowLen = matrix.length;
        // 每列都存在
        if (colLen == numSelect) {
            return rowLen;
        }
        int[] masks = new int[rowLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                // 左移一位 + 当前位（0/1）
                masks[i] = (masks[i] << 1) + matrix[i][j];
            }
        }
        int maxColCount = 0;
        for (int i = 0; i < 1 << colLen; i++) {
            if (Integer.bitCount(i) != numSelect) {
                continue;
            }
            int count = 0;
            for (int mask : masks) {
                if ((mask & i) == mask) {
                    count++;
                    maxColCount = Math.max(count, maxColCount);
                }
            }
        }
        return maxColCount;
    }

    public static void main(String[] args) {
        /*
        [[0,0,0],[1,0,1],[0,1,1],[0,0,1]]
         */
        int[][] matrix = {{0,0,0}, {1,0,1}, {0,1,1}, {0,0,1}};
        int maximumRows = maximumRows(matrix, 2);
        System.out.println(maximumRows);
    }
}
