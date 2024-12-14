class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        
        Map<Integer, Integer> mp = new HashMap<>();
        
        for(int j = nums2.length - 1; j >= 0; j--){
            int avar = nums2[j];

            while(!st.isEmpty() && st.peek() < avar){
                st.pop();
            }
            
            if(st.isEmpty()){
                st.push(-1);        
            }
            
            int stvar = st.peek();
            mp.put(avar, stvar);
            st.push(avar);
        }
        
        int[] ans = new int[nums1.length];
        
        for(int i = 0; i < ans.length; i++){
            ans[i] = mp.get(nums1[i]);
        }
        
        return ans;
    }
}