class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int max = -1;

        for(int i = prices.length - 1; i >= 0; i--){
            int var = prices[i];
            max = Math.max(max, var);

            if(max >= var){
                ans = Math.max(ans, max - var);
            }
        }

        return ans;
    }
}