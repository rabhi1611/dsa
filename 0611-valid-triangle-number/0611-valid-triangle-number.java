class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;

        for(int i = n - 1; i >= 2; i -= 1){
            int left = 0, right = i - 1;

            while(left < right){
                if(nums[left] + nums[right] > nums[i]){
                    count += (right - left);
                    right -= 1;
                } else {
                    left += 1;
                }
            }
        }

        return count;
    }
}