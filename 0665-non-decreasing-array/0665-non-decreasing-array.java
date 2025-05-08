class Solution {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length, cnt = 0;
        int i = 1;

        while(i < n){
            if(nums[i] < nums[i - 1]){
                cnt += 1;

                if(cnt > 1){
                    return false;
                }

                if(i - 2 >= 0 && nums[i] < nums[i - 2]){
                    nums[i] = nums[i - 1];
                }
            }

            i += 1;
        }

        return true;
    }
}