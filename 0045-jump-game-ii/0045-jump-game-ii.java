class Solution {
    public int jump(int[] nums) {
        int n = nums.length;    
        int dp[] = new int[n];
        
        for(int i = 0; i < n; i += 1){
            dp[i] = Integer.MAX_VALUE;
        }

        return dfs(0, n - 1, nums, dp);
    }

    private int dfs(int start, int end, int[] nums, int[] dp){
        if(start > end){
            return Integer.MAX_VALUE;
        }

        if(start == end){
            return 0;
        }

        if(dp[start] != Integer.MAX_VALUE){
            return dp[start];
        }

        int ans = Integer.MAX_VALUE;

        for(int step = 1; step <= nums[start]; step += 1){
            int cnt = dfs(start + step, end, nums, dp);
            ans = Math.min(ans, cnt == Integer.MAX_VALUE ? cnt : cnt + 1);
        }

        return dp[start] = ans;
    }
}