class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        if(n == 1){
            return 0;
        }

        for(int i = 1; i < n; i++){
            if(nums[i - 1] > nums[i]){
                return i - 1;
            }
        }

        return n - 1;
    }
}