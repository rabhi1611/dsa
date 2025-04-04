class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int dp[][] = new int[200][200];
        for(int i = 0; i < 200; i++)
            Arrays.fill(dp[i], -1);

        return helper(0, 0, n, m, grid, dp);
    }

    private int helper(int i, int j, int n, int m, int[][] grid, int[][] dp){
        if(i >= n || j >= m){
            return Integer.MAX_VALUE;
        }

        int sa1 = helper(i + 1, j, n, m, grid, dp);
        int sa2 = helper(i, j + 1, n, m, grid, dp);

        if(sa1 == Integer.MAX_VALUE && sa2 == Integer.MAX_VALUE){
            return grid[i][j];
        } else if (sa1 == Integer.MAX_VALUE){
            return sa2 + grid[i][j];
        } else if (sa2 == Integer.MAX_VALUE){
            return sa1 + grid[i][j];
        }
        return Math.min(sa1 + grid[i][j], sa2 + grid[i][j]);
    }
}