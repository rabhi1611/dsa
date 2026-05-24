class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int dp[][] = new int[m][n];

        for(int i = m - 1; i >= 0; i -= 1){
            for(int j = n - 1; j >= 0; j -= 1){
                if(i + 1 >= m && j + 1 >= n){
                    dp[i][j] = grid[i][j];
                } else if (i + 1 >= m){
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                } else if (j + 1 >= n){
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                } else {
                    dp[i][j] = Math.min(grid[i][j] + dp[i + 1][j], grid[i][j] + dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];        
    }
}