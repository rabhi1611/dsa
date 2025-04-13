class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Arrays.sort(coins);

        int dp[][] = new int[13][10001];
        for(int i = 0; i < 13; i++){
            Arrays.fill(dp[i], -1);
        }

        int ans = helper(n - 1, coins, amount, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int helper(int i, int[] coins, int amount, int[][] dp){
       
        if(amount == 0){
            return 0;
        }

        if(amount < 0){
            return Integer.MAX_VALUE;
        }

         if(i < 0){
            return Integer.MAX_VALUE;
        }

        if(dp[i][amount] != -1){
            return dp[i][amount];
        }

        // take and stay
        int a = helper(i, coins, amount - coins[i], dp);
        // take and move
        int b = helper(i - 1, coins, amount - coins[i], dp);
        // not take and move
        int c = helper(i - 1, coins, amount, dp);

        if(a == Integer.MAX_VALUE && b == Integer.MAX_VALUE && c == Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }

        int min = Math.min(a, Math.min(b, c));

        if(min == c){
            return dp[i][amount] = min;
        }

        return dp[i][amount] = 1 + min;
    }
}