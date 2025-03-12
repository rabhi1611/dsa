class Solution {
    public int maximumCount(int[] nums) {
        int ngNum = 0, posNum = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                ngNum += 1;
            } else if(nums[i] > 0){
                posNum += 1;
            }
        }

        return Math.max(ngNum, posNum);
    }
}