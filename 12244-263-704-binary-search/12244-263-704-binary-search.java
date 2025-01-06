class Solution {

    private int bs(int[] nums, int l, int r, int target){

        if(l > r){
            return -1;
        }

        int mid = (l + r) / 2;

        if(nums[mid] == target){
            return mid;
        } else if(nums[mid] > target){
            return bs(nums, l, mid - 1, target);
        } else{
            return bs(nums, mid + 1, r, target);
        }
    }

    public int search(int[] nums, int target) {
        return bs(nums, 0, nums.length - 1, target);
    }
}