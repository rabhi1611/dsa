class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return helper(nums, 0, n, target);
    }

    private int helper(int[] nums, int i, int n, int target){
        
        if(i == n){
            if(target == 0){
                return 1;
            }
            return 0;
        }

        int subSum1 = helper(nums, i + 1, n, target - nums[i]);
        int subSum2 = helper(nums, i + 1, n, target + nums[i]);

        return subSum1 + subSum2;
    }
}