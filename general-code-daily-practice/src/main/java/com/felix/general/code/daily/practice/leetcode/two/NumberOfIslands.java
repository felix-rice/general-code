package com.felix.general.code.daily.practice.leetcode.two;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2023-09-21
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visited[i][j] || grid[i][j] == '0') {
                    continue;
                }
                dfs(grid, visited, i, j);
                result++;
            }
        }
        return result;
    }

    private void dfs(char[][] grid, boolean[][] visited, int x, int y) {
        if (x >= grid.length || x < 0 || y >= grid[0].length || y < 0 || visited[x][y]) return;
        visited[x][y] = true;
        if (grid[x][y] == '0') {
            return;
        }
        dfs(grid, visited, x + 1, y);
        dfs(grid, visited, x, y + 1);
        dfs(grid, visited, x - 1, y);
        dfs(grid, visited, x, y - 1);
    }
}
