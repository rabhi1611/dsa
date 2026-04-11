class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n];

        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            preSum[i] = sum;
        }

        sum = preSum[n - 1];

        for(int i = 0; i < n; i += 1){
            int sumTillLastIndex = 0;
            if(i > 0)  sumTillLastIndex = preSum[i - 1];
            int sumAfterCurrentIndex = sum - preSum[i];

            if(sumTillLastIndex == sumAfterCurrentIndex){
                return i;
            }
        }

        return -1;
    }
}