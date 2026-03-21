class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;


        int mini = Integer.MAX_VALUE;
        int result = 0;

        for(int i = 0; i < n; i += 1){
            result = Math.max(result, prices[i] - mini);
            mini = Math.min(mini, prices[i]);
        }

        return result;
    }
}