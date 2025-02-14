class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int ans = 0;
        Arrays.sort(citations);

        for(int i = 0; i < n; i++){
            int cnp = (n - 1) - i + 1;
            if(citations[i] >= cnp){
                ans = Math.max(ans, cnp);
            }
        }

        return ans;
    }
}