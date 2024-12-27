class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        int t = 0;
        
        for(int i = 0; i < n; i++){
            t = t ^ nums[i] ^ (i + 1);
        }
        
        return t;
    }
}