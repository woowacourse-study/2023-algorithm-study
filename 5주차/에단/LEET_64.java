class Solution {
    public int minPathSum(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;

        int[][] dp = new int[R][C];
        dp[0][0] = grid[0][0];
        for (int c = 1; c < C; c++) {
            dp[0][c] = dp[0][c - 1] + grid[0][c];
        }

        for (int r = 1; r < R; r++) {
            dp[r][0] = dp[r - 1][0] + grid[r][0];
        }

        for (int r = 1; r < R; r++) {
            for (int c = 1; c < C; c++) {
                dp[r][c] = Math.min(dp[r - 1][c], dp[r][c - 1]) + grid[r][c];
            }
        }
        return dp[R - 1][C - 1];
    }
}
