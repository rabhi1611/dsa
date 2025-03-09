class Pair {
    int idx;
    int value;

    Pair(int idx, int value){
        this.idx = idx;
        this.value = value;
    }
} 

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];

        Stack<Pair> st = new Stack<>();

        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && temperatures[i] >= st.peek().value){
                st.pop();
            }

            if(st.isEmpty()){
                ans[i] = 0;               
            } else {
                ans[i] = st.peek().idx - i;
            }

            st.push(new Pair(i, temperatures[i]));
        }

        return ans;
    }
}