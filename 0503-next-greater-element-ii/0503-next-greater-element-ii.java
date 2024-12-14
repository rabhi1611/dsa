class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        
         int[] ans = new int[nums.length];
        
        for(int j = nums.length - 1; j >= 0; j--){
            int avar = nums[j];

            while(!st.isEmpty() && st.peek() <= avar){
                st.pop();
            }
            
            if(st.isEmpty()){
                st.push(-1);        
            }
            
            st.push(avar);
        }
        
        for(int j = nums.length - 1; j >= 0; j--){
            int avar = nums[j];

            while(!st.isEmpty() && st.peek() <= avar){
                st.pop();
            }
            
            if(st.isEmpty()){
                st.push(-1);        
            }
            
            int stvar = st.peek();
            ans[j] = stvar;
            st.push(avar);
        }
        
        return ans;
        
    }
}