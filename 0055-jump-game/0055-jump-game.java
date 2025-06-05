class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return helper(0, n, nums, dp);
    }

    private boolean helper(int idx, int n, int[] nums, int[] dp){

        if(idx >= n){
            return false;
        }

        if(idx == n - 1){
            return true;
        }

        if(dp[idx] != -1){
            return dp[idx] == 1 ? true : false;
        }

        for(int jumpCnt = 1; jumpCnt <= nums[idx]; jumpCnt += 1){
            if(helper(idx + jumpCnt, n, nums, dp)){
                dp[idx] = 1;
                return true;
            }
        }

        dp[idx] = 0;
        return false;
    }
}