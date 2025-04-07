class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(0, 0, m, n, dp);
    }

    private int helper(int i, int j, int n, int m, int dp[][]){
        if(i < 0 || j < 0 || i >= n || j >= m){
            return 0;
        }
        
        
        if(i == n - 1 && j == m - 1){
            return 1;
        }

        if(dp[i][j] != -1)  return dp[i][j];

        int right = helper(i, j + 1, n, m, dp);
        int down = helper(i + 1, j, n, m, dp);

        return dp[i][j] = right + down;       
    }
}