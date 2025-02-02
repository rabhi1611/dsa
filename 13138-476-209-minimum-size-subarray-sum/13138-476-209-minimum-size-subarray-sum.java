class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;

        int l = 0, r = 0;
        int sum = 0;

        while(r < n){
            sum += nums[r];

            if(sum >= target){
                while(sum >= target){
                    sum -= nums[l];
                    l++;
                }

                min = Math.min(min, r - (l - 1) + 1);
            }

            r++;
        }


        return min == Integer.MAX_VALUE ? 0 : min;
    }
}