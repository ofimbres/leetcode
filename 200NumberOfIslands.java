/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 */

class Solution {

    /**
     * Approach 1. DFS
     * Time: O(M x N), Space: O(M x N)
     */
    private static final int[][] DIRECTIONS = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

    public int numIslands(char[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    num_islands++;
                }
            }
        }

        return num_islands;
    }

    private void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || r >= nr || c < 0 || c >= nc) return;
        if (grid[r][c] == '0') return;

        grid[r][c] = '0'; // mark as visited

        for (int[] d : DIRECTIONS) {
            int next_r = r + d[0];
            int next_c = c + d[1];
            dfs(grid, next_r, next_c);
        }
    }
}