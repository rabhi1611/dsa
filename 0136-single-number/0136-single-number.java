class Solution {
    public int singleNumber(int[] nums) {
        int t = 0;
        
        for(int i = 0; i < nums.length; i++){
            t = t ^ nums[i];
        }
        
        return t;
    }
}