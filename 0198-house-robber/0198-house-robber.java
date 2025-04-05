class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        
        return helper(0, nums, n, dp);
    }


    private int helper(int i, int[] nums, int n, int[] dp){
        if(i >= n){
            return 0;
        }

        if(dp[i] != -1) return dp[i];

        int take = nums[i] + helper(i + 2, nums, n, dp);
        int notTake = helper(i + 1, nums, n, dp);

        return dp[i] = Math.max(take, notTake);
    }
}