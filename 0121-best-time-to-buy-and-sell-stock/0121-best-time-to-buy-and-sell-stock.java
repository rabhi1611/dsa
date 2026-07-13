class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ans = Integer.MIN_VALUE;

        int[] maxRec = new int[n];
        maxRec[n - 1] = prices[n - 1];

        for(int i = n - 2; i >= 0; i--){
            maxRec[i] = Math.max(maxRec[i + 1], prices[i]);

            // if buy today??
            ans = Math.max(ans, maxRec[i + 1] - prices[i]);
        } 

        if(ans < 0) ans = 0;

        return ans;
    }
}