class Solution {
    public long minCost(int[] arr, int[] brr, long k) {
        int n = arr.length;
        long var1 = 0;
        long var2 = 0;
        
        for(int i = 0; i < n; i++){
            var1 += Math.abs(arr[i] - brr[i]);
        }
        
        Arrays.sort(arr);
        Arrays.sort(brr);
        
        for(int i = 0; i < n; i++){
            var2 += Math.abs(arr[i] - brr[i]);
        }
        
        var2 += k;
        
        return Math.min(var1, var2);
    }
}