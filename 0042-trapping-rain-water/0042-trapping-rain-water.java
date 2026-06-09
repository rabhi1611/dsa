class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;

        int preMax[] = new int[n];
        int postMax[] = new int[n];

        preMax[0] = height[0];
        for(int i = 1; i < n; i += 1){
            preMax[i] = Math.max(height[i], preMax[i - 1]);
        }


        postMax[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i -= 1){
            postMax[i] = Math.max(height[i], postMax[i + 1]);
        }
        
        for(int i = 1; i < n - 1; i += 1){
            int diff = Math.min(preMax[i - 1], postMax[i + 1]) - height[i];
            if(diff > 0){
                ans += diff;
            }
        }

        return ans;
    }
}