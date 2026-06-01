class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int n = nums.length;

        int sum = 0, l = 0, r = 0;
        while(r < n){
            sum += nums[r];

            while(sum >= target){
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l];
                l += 1;
            }

            r += 1;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}