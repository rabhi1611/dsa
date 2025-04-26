class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        return helper(0, 0, n, m, obstacleGrid, dp);
    }

    private int helper(int i, int j, int n, int m, int[][] obstacleGrid, int[][] dp){
        if(i < 0 || j < 0 || i >= n || j >= m){
            return 0;
        }

        if(obstacleGrid[i][j] == 1){
            return 0;
        }

        if(i == n - 1 && j == m - 1){
            return 1;
        }

        if(dp[i][j] != -1)  return dp[i][j];

        int right = helper(i, j + 1, n, m, obstacleGrid, dp);
        int down = helper(i + 1, j, n, m, obstacleGrid, dp);

        return dp[i][j] = right + down;
    }
}