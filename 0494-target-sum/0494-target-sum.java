class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return helper(nums, 0, n, target, dp);
    }

    private int helper(int[] nums, int i, int n, int target, int[] dp){
        
        if(i == n){
            if(target == 0){
                return 1;
            }
            return 0;
        }

        if(dp[i] != -1) return dp[i]; 

        int subSum1 = helper(nums, i + 1, n, target - nums[i], dp);
        int subSum2 = helper(nums, i + 1, n, target + nums[i], dp);

        return dp[i] = subSum1 + subSum2;
    }
}