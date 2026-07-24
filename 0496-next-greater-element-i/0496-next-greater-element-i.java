class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        Stack<Integer> st = new Stack<>();

        int[] rec = new int[10001];

        for(int i = n - 1; i >= 0; i -= 1){
            while(!st.isEmpty() && nums2[i] >= st.peek()){
                st.pop();
            }

            if(!st.isEmpty()){
                rec[nums2[i]] = st.peek();
            }else{
                rec[nums2[i]] = -1;
            }

            st.push(nums2[i]);
        }

        // now we have the next greater record
        for(int i = 0; i < nums1.length; i += 1){
            nums1[i] = rec[nums1[i]];
        }

        return nums1;
    }
}