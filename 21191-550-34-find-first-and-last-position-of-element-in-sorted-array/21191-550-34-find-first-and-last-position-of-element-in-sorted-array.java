class Solution {

    private int lowerBound(int[] nums, int l, int r, int target){
        if(l > r)    return nums.length;

        int mid = l + ((r - l) / 2);

        int a = nums.length, b = nums.length;

        if(nums[mid] >= target){
            a = lowerBound(nums, l, mid - 1, target);
        }else{
            b = lowerBound(nums, mid + 1, r, target);
        }

        if(nums[mid] == target){
            return Math.min(Math.min(a, b), mid);
        }
        
        return  Math.min(a, b);
    }

    private int upperBound(int[] nums, int l, int r, int target){
        if(l > r)   return -1;

        int mid = l + ((r - l) / 2);

        int a = -1, b = -1;

        if(nums[mid] > target){
            a = upperBound(nums, l, mid - 1, target);
        }else{
            b = upperBound(nums, mid + 1, r, target);
        }

        if(nums[mid] == target){
            return Math.max(Math.max(a, b), mid);
        }

        return Math.max(a, b);
    }

    public int[] searchRange(int[] nums, int target) {
        int first = lowerBound(nums, 0, nums.length - 1, target);
        int last = upperBound(nums, 0, nums.length - 1, target);

        if(first == nums.length) first = -1;

        return new int[]{first, last};
    }
}