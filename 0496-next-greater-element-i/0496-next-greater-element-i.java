class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        Stack<Integer> st = new Stack<>();

        Map<Integer, Integer> mp = new HashMap<>();
        int[] rec = new int[n];

        for(int i = n - 1; i >= 0; i -= 1){
            while(!st.isEmpty() && nums2[i] >= st.peek()){
                st.pop();
            }

            if(!st.isEmpty()){
                rec[i] = st.peek();
            }

            st.push(nums2[i]);
            mp.put(nums2[i], i);
        }

        int[] ans = new int[nums1.length];

        // now we have the next greater record
        for(int i = 0; i < nums1.length; i += 1){
            if(!mp.containsKey(nums1[i])){
                ans[i] = -1;
                continue;
            }

            if(rec[mp.get(nums1[i])] == 0){
                ans[i] = -1;
                continue;
            }

            ans[i] = rec[mp.get(nums1[i])];
        }

        return ans;
    }
}