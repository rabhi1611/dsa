class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ans = Integer.MIN_VALUE;

        
        int maxi = prices[n - 1];

        for(int i = n - 2; i >= 0; i--){
            // if buy today??
            ans = Math.max(ans, maxi - prices[i]);

            // update maxi
            maxi = Math.max(maxi, prices[i]);
        } 

        if(ans < 0) ans = 0;

        return ans;
    }
}