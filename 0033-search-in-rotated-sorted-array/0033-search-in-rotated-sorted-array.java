class Solution {

    private int binarySearch(int left, int right, int[] nums, int target){
        while(left <= right){
            int mid = (left + right) / 2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[left] <= nums[mid]){
                // this part is sorted
                if(nums[left] <= target && target <= nums[mid]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // this part is sorted
                if(nums[mid] <= target && target <= nums[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        return binarySearch(0, n - 1, nums, target);
    }
}