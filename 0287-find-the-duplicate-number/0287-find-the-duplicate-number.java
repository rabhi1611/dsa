class Solution {
    public int findDuplicate(int[] nums) {
        int low = 0;
        int high = 0;

        do {
            low = nums[low];
            high = nums[nums[high]];
        } while (nums[low] != nums[high]);

        low = 0;

        while(nums[low] != nums[high]){
            low = nums[low];
            high = nums[high];
        }


        return nums[low];
    }
}