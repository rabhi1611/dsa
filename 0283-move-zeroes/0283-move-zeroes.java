class Solution {
    public void moveZeroes(int[] nums) {
        int j = -1;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                if(j != -1){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    j++;
                }
            } else{
                if(j == -1){
                    j = i;
                }
            }
        }
    }
}