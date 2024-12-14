class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        int sum = 0;
        
        int temp = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++){
            if(height[i] > temp){
                temp = height[i];
            }
            leftMax[i] = temp;    
        }
        
        temp = Integer.MIN_VALUE;
        
        for(int i = n - 1; i >= 0; i--){
            if(height[i] > temp){
                temp = height[i];
            }
            rightMax[i] = temp;
        }
        
        for(int i = 1; i < n - 1; i++){
            sum += ((Math.min(leftMax[i], rightMax[i]) - height[i]));
        }
        
        return sum;
    }
}