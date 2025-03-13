class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int prefixSum = 0;
        int k = 0;
        int[] diff = new int[nums.length + 1];

        for(int i = 0; i < nums.length; i++){
            while((prefixSum + diff[i]) < nums[i]){
                k++;
                if(k > queries.length){
                    return -1;
                }
                if(queries[k - 1][1] >= i){
                    diff[Math.max(queries[k - 1][0], i)] += queries[k - 1][2];
                    diff[queries[k - 1][1] + 1] -= queries[k - 1][2];
                }
            }

            prefixSum += diff[i];
        }
        return k;
    }
}