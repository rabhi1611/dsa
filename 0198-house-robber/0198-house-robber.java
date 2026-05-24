class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        for(int i = 0; i < n; i += 1){
            dp[i] = -1;
        }

        return helper(0, n - 1, nums, dp);
    }

    private int helper(int curr, int end, int[] nums, int[] dp){
        if(curr > end){
            return 0;
        }

        if(dp[curr] != -1){
            return dp[curr];
        }

        // if robbing yes
        int yesRobbed = nums[curr] + helper(curr + 2, end, nums, dp);
        int noRobbed = helper(curr + 1, end, nums, dp);

        return dp[curr] = Math.max(yesRobbed, noRobbed);
    }
}