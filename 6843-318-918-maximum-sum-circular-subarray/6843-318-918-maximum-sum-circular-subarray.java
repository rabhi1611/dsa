class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int sum = nums[0];
        int tsum1 = nums[0];
        int tsum2 = nums[0];
        int maxSum = nums[0];
        int minSum = nums[0];

        for(int i = 1; i < n; i++){
            sum += nums[i];
            tsum1 = Math.max(tsum1 + nums[i], nums[i]);
            maxSum = Math.max(maxSum, tsum1);
            tsum2 = Math.min(tsum2 + nums[i], nums[i]);
            minSum = Math.min(minSum, tsum2);
        }

        int cirSum = sum - minSum;

        if(maxSum > 0)  return Math.max(maxSum, cirSum);
        return maxSum;
    }
}