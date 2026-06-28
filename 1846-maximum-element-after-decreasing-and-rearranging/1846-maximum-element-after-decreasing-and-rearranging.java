class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        if(arr[0] != 1){
            arr[0] = 1;
        }

        int ans = 1;

        for(int i = 1; i < n; i += 1){
            if((arr[i] - arr[i - 1]) <= 1){
                // satisfy
            } else {
                // not satisfy
                arr[i] = arr[i - 1] + 1;
            }
            ans = Math.max(ans, arr[i]);
        }

        return ans;
    }
}