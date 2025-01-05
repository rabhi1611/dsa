class Solution {
    public int maxProduct(int[] nums) {
        int preProd = 1, suffProd = 1;
        int ans = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            if(preProd == 0)    preProd = 1;
            if(suffProd == 0)   suffProd = 1;
            
            preProd = preProd * nums[i];
            suffProd = suffProd * nums[nums.length - i - 1];
            
            ans = Math.max(ans, Math.max(preProd, suffProd));
        }
            
        return ans; 
    }
}