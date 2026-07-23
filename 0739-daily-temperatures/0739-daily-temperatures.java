class Pair {
    int val;
    int pos;

    Pair(int val, int pos){
        this.val = val;
        this.pos = pos;
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        
        Stack<Pair> st = new Stack<>();

        for(int i = n - 1; i >= 0; i -= 1){
            if(st.isEmpty()){
                ans[i] = 0;
            } else {
                while(!st.isEmpty() && temperatures[i] >= st.peek().val){
                    st.pop();
                }

                if(st.isEmpty()){
                    ans[i] = 0;
                } else {
                    ans[i] = (st.peek().pos - i);
                }
            }

            st.push(new Pair(temperatures[i], i));
        }

        return ans;
    }
}