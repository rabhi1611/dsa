class Solution {

    private int[][] dp = new int[99999][];

    {
        for(int i = 0; i < 99999; i += 1){
            dp[i] = new int[12];
            for(int j = 0; j < 12; j += 1){
                dp[i][j] = -2;
            }
        }
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        return helper(amount, 0, coins, n);
    }

    private int helper(int amount, int idx, int[] coins, int n){
        if(amount < 0){
            return -1;
        }

        if(amount == 0){
            return 0;
        }

        if(idx == n){
            return -1;
        }

        if(dp[amount][idx] != -2){
            return dp[amount][idx];
        }

        // take
        int step1 = helper(amount - coins[idx], idx, coins, n);
        
        //not take
        int step2 = helper(amount, idx + 1, coins, n);

        if (step1 == -1 && step2 == -1) {
            return dp[amount][idx] = -1;
        }
        else if (step1 == -1) {
            // don't count
            return dp[amount][idx] = step2;
        } else if (step2 == -1) {
            return dp[amount][idx] = step1 + 1;
        }
        else {
            if (step1 < step2) {
                return dp[amount][idx] = step1 + 1;
            } else {
                return dp[amount][idx] = step2;
            } 
        }
    }
}