class Solution {
    public int majorityElement(int[] nums) {
        Integer cnt = 0, candidate = null;

        for(int i =  0; i < nums.length; i += 1){
            if(cnt == 0){
                candidate = nums[i];
            }

            if(candidate == nums[i]){
                cnt += 1;
            } else{
                cnt -= 1;
            }
        }

        return candidate;
    }
}