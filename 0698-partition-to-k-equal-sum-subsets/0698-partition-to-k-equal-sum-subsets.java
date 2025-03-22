class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();

        if(sum % k != 0){
            return false;
        }

        int targetSum = sum / k;
        Arrays.sort(nums);

        return helper(0, nums, 0, targetSum, k, new boolean[nums.length]);
    }

    private boolean helper(int sIdx, int[] nums, int inSum, int targetSum, int k, boolean[] used){
        if(k == 1){
            return true;
        }

        if(inSum == targetSum){
            return helper(0, nums, 0, targetSum, k - 1, used);
        }

        for(int i = sIdx; i < nums.length; i++){
            if(used[i] == false){
                used[i] = true;

                if(helper(i + 1, nums, inSum + nums[i], targetSum, k, used) == true){
                    return true;
                }

                used[i] = false;
            }

            if(inSum == 0) break;
        }
        return false;
    }
}