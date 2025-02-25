class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;

        int preSum = 0, ans = 0, evenPreSumCount = 0, oddPreSumCount = 0;

        for(int i = 0; i < n; i++){
            preSum += arr[i];

            if((preSum % 2 == 0)){
                // even
                ans += evenPreSumCount;
                oddPreSumCount += 1;
            } else {
                //odd
                ans++;
                ans += oddPreSumCount;
                evenPreSumCount += 1;                
            }

            ans = ans % 1000000007;
        }

        return ans;
    }
}