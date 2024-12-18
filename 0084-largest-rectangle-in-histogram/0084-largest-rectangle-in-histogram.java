class Solution {
    
    int[] giveNSE(int[] heights, int n){
        int[] nse = new int[n];
        
        Stack<Integer> st = new Stack();
        
        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                st.pop();
            }
            
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        
        return nse;
    }
    
    int[] givePSE(int[] heights, int n){
        int[] pse = new int[n];
        
        Stack<Integer> st = new Stack();
        
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        
        return pse;
    }
    
    
    
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
                
        int[] nse = giveNSE(heights, n);
        int[] pse = givePSE(heights, n);
        
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            int ns = nse[i];
            int ps = pse[i];
            
            ans = Math.max((ns - ps - 1) * heights[i] , ans);
        }
        
        return ans;
    }
}