class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i += 1){
            Arrays.fill(dp[i], -1);
        }

        return helper(0, 0, m - 1, n - 1, grid, dp);
    }

    private int helper(int currX, int currY, int endX, int endY, int[][] grid, int[][] dp){
        if(currX > endX || currY > endY){
            return Integer.MAX_VALUE;
        }

        if(dp[currX][currY] != -1){
            return dp[currX][currY];
        }

        int down = helper(currX + 1, currY, endX, endY, grid, dp);
        int right = helper(currX, currY + 1, endX, endY, grid, dp);

        if(down == Integer.MAX_VALUE && right == Integer.MAX_VALUE){
            return dp[currX][currY] = grid[currX][currY];
        }

        if(down == Integer.MAX_VALUE){
            return dp[currX][currY] = grid[currX][currY] + right;
        }

        if(right == Integer.MAX_VALUE){
            return dp[currX][currY] = grid[currX][currY] + down;
        }

        return dp[currX][currY] = Math.min(grid[currX][currY] + down, grid[currX][currY] + right);
    }
}