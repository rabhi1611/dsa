class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int mid = l;
        
        
        while(mid <= r){
            if(nums[mid] == 0){
                swap(nums, mid, l);
                l++;
                mid++;
            } else if(nums[mid] == 1){
                mid++;
            } else{
                swap(nums, mid, r);
                r--;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}