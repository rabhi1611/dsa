class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int max = 0;

        for(int i = prices.length - 1; i >= 0; i--){
            max = Math.max(max, prices[i]);

            if(max >= prices[i]){
                ans = Math.max(ans, max - prices[i]);
            }
        }

        return ans;
    }
}