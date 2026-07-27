class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        int input[] = new int[n + n];
        for(int i = 0; i < (2 * n); i += 1){
            input[i] = nums[i % n];
        }

        int[] ans = new int[n];

        for(int i = (2* n) - 1; i >= 0; i -= 1){
            while(!st.isEmpty() && st.peek() <= input[i]){
                st.pop();
            }

            if(st.isEmpty()){
                ans[i % n] = -1;
            }else{
                ans[i % n] = st.peek();
            }

            st.push(input[i]);
        }

        return ans;
    }
}