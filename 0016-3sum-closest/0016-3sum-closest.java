class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        for(int x = 0; x < n; x += 1){
            int y = x + 1;
            int z = n - 1;

            while(y < z){
                int sum = nums[x] + nums[y] + nums[z];

                if(sum <= target){
                    if(target - sum < minDiff){
                        minDiff = target - sum;
                        ans = sum;
                    }
                    y += 1;
                } else if (sum > target){
                    if(sum - target < minDiff){
                        minDiff = sum - target;
                        ans = sum;
                    }
                    z -= 1;
                }
            }

        }

        return ans;
    }
}