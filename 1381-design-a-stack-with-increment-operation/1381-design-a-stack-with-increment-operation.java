class CustomStack {

    private Integer maxSize;
    private Stack<Integer> st;
    private Stack<Integer> tst;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.st = new Stack<>();
        this.tst = new Stack<>();
    }
    
    public void push(int x) {
        if(st.size() == maxSize){
            return;
        }

        st.add(x);
    }
    
    public int pop() {
        if(st.isEmpty()){
            return -1;
        }

        return st.pop();
    }
    
    public void increment(int k, int val) {
        while(!st.isEmpty()){
            tst.add(st.pop());
        }

        while(!tst.isEmpty()){
            if(k > 0){
                st.add(tst.pop() + val);
                k -= 1;
            } else {
                st.add(tst.pop());
            }
        }

        return;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */