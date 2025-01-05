class Solution {

    private int bs(int[] nums, int l, int r, int target){

        if(l > r){
            return -1;
        }

        int mid = (l + r) / 2;

        if(nums[mid] == target){
            return mid;
        }

        int sa1 = bs(nums, l, mid - 1, target);
        int sa2 = bs(nums, mid + 1, r, target);

        if(sa1 != -1){
            return sa1;
        }

        if(sa2 != -1){
            return sa2;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        return bs(nums, 0, nums.length - 1, target);
    }
}