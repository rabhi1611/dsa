class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for(int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        return helper(0, -1, nums, n, dp);
    }

    private int helper(int CurrIdx, int containerIdx, int[] nums, int n, int[][] dp){
        if(CurrIdx == n){
            return 0;
        }

        if(dp[CurrIdx][containerIdx + 1] != -1) return dp[CurrIdx][containerIdx + 1];

        int notTake = helper(CurrIdx + 1, containerIdx, nums, n, dp);
        int ans = notTake;

        if(containerIdx == -1 || nums[CurrIdx] > nums[containerIdx]){
            int take = 1 + helper(CurrIdx + 1, CurrIdx, nums, n, dp); 
            ans = Math.max(notTake, take);
        }

        return dp[CurrIdx][containerIdx + 1] = ans;
    }
}