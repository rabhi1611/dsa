
class Solution {
    
    private int fun(int[][] coins, int i, int j, int n, int m, int np, Integer[][][] dp){
        if(i >= n || j >= m){
            return Integer.MIN_VALUE;
        }

        int curr = coins[i][j];
        if(i == n - 1 && j == m - 1){
            if(curr < 0){
                return np > 0 ? 0 : curr;
            } else {
                return curr;
            }
        }

        if(dp[i][j][np] != null) return dp[i][j][np];
        
        int sans1 = Integer.MIN_VALUE;
        int sans2 = Integer.MIN_VALUE;
        int sans3 = Integer.MIN_VALUE;
        
        if(curr < 0){
            if(np > 0){
                sans1 = Math.max(fun(coins, i + 1, j, n, m, np - 1, dp), fun(coins, i, j + 1, n, m, np - 1, dp));  
            } 
            sans2 = Math.max(fun(coins, i + 1, j, n, m, np, dp), fun(coins, i, j + 1, n, m, np, dp)) - Math.abs(curr);
        } 
        sans3 = Math.max(fun(coins, i + 1, j, n, m, np, dp), fun(coins, i, j + 1, n, m, np, dp)) + curr;
        
        return dp[i][j][np] = Math.max(sans1, Math.max(sans2, sans3));
    }
    
    public int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;
        Integer[][][] dp = new Integer[n][m][3];
        return fun(coins, 0, 0, n, m, 2, dp);
    }
}