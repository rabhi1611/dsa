class Solution {

    private int[] dp;

    public boolean canJump(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        
        for(int i = 0; i < n; i += 1){
            dp[i] = -1;
        }

        return helper(0, n - 1, nums);
    }

    private boolean helper(int start, int end, int[] nums){
        if(start == end){
            return true;
        }

        if(start > end){
            return false;
        }

        if(dp[start] != -1){
            return dp[start] == 0 ? false : true;
        }

        for(int step = 1; step <= nums[start]; step += 1){
            if(helper(start + step, end, nums)){
                dp[start + step] = 1;
                return true;
            }
        }

        dp[start] = 0;
        return false;
    }
}