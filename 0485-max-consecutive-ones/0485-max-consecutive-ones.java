class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int max = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                cnt = 0;
                continue;
            } 

            cnt++;
            max = Math.max(max, cnt);
        }
        
        return max;
    }
}