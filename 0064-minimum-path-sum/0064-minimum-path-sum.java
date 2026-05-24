class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int dp[] = new int[n];

        for(int i = m - 1; i >= 0; i -= 1){
            for(int j = n - 1; j >= 0; j -= 1){
                if(i + 1 >= m && j + 1 >= n){
                    dp[j] = grid[i][j];
                } else if (i + 1 >= m){
                    dp[j] = grid[i][j] + dp[j + 1];
                } else if (j + 1 >= n){
                    dp[j] = grid[i][j] + dp[j];
                } else {
                    dp[j] = Math.min(grid[i][j] + dp[j], grid[i][j] + dp[j + 1]);
                }
            }
        }

        return dp[0];        
    }
}