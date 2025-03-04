class Solution {
    private int[][] dp = new int[5001][2];
    
    public int maxProfit(int[] prices) {
        int n = prices.length;

        for(int t[]: dp){
            Arrays.fill(t, -1);
        }

        return solve(prices, 0, n, 1, dp);
    }

    private int solve(int[] prices, int cd, int n, int buy, int[][] dp){
        if(cd >= n){
            return 0;
        }

        if(dp[cd][buy] != -1){
            return dp[cd][buy];
        }

        int profit = 0;

        if(buy == 1){
            // buy now
            // sell nextDay
            int bnSnd = solve(prices, cd + 1, n, 0, dp) - prices[cd];

            // not buy now
            int bnd = solve(prices, cd + 1, n, 1, dp);

            profit = Math.max(profit, Math.max(bnSnd, bnd));
        } else {
            // sell now
            int sn = prices[cd] + solve(prices, cd + 2, n, 1, dp);

            // sell next day
            int snd = solve(prices, cd + 1, n, 0, dp);

            profit = Math.max(profit, Math.max(sn, snd));
        }

        return dp[cd][buy] = profit;
    }
}