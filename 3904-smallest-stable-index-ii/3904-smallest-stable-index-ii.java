class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int[] preMax = new int[n];
        int[] postMin = new int[n];

        preMax[0] = nums[0];
        postMin[n - 1] = nums[n - 1];


        for(int i = 1; i < n; i += 1){
            preMax[i] = Math.max(preMax[i - 1], nums[i]);
        }

        for(int i = n - 2; i >= 0; i -= 1){
            postMin[i] = Math.min(postMin[i + 1], nums[i]);
        }

        int minStableValueIndex = -1;

        for(int i = 0; i < n; i += 1){
            int diff = preMax[i] - postMin[i]; 
            if(diff <= k){
                minStableValueIndex = i;
                break;
            }
        }

        return minStableValueIndex;
    }
}