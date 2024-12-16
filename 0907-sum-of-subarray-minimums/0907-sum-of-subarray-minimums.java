class Solution {
    
    private static int mod = 1000000007;
    
     private int[] findNse(int[] nums){
        
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        
        
        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        
        return nse;
    }
    
    private int[] findPse(int[] nums){
        
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[n];
        
        
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]){
                st.pop();
            }
            
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        
        return pse;
    }
    
    public int sumSubarrayMins(int[] arr) {
        int[] nse = findNse(arr);
        int[] pse = findPse(arr);
        
        int n = arr.length;
        int sum = 0;
        
        for(int i = 0; i < n; i++){
            int a = i - pse[i];
            int b = nse[i] - i;
            
            sum = (int)(sum + ((int)((a * 1l * b) % mod) * 1l * arr[i]) % mod) % mod;
        }
        
        return sum;
    }
}