class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1){
            return nums[0];
        }
        
        int dp[] = new int[n];
        
        // 0 <-> n - 2
        Arrays.fill(dp, -1);
        int ans1 = helper(0, nums, n - 1, dp);

        // 1 <-> n - 1
        Arrays.fill(dp, -1);
        int ans2 = helper(1, nums, n, dp);

        return Math.max(ans1, ans2);
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