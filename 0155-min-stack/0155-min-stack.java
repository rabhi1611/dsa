class MinStack {
    
    Stack<Long> st = new Stack<>();
    Long min = Long.MAX_VALUE;
    
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(Long.valueOf(val));
            min = Long.valueOf(val);
        } else {
            if(Long.valueOf(val) > min){
                st.push(Long.valueOf(val));    
            } else {
                st.push((2 * Long.valueOf(val)) - min);
                min = Long.valueOf(val);
            }
        }
    }
    
    public void pop() {  
        if(st.isEmpty()){
            return;
        }
        if(st.peek() < min)
            min = (2 * min) - st.peek();
        st.pop();
    }
    
    public int top() {  
        if(st.peek() < min) 
            return min.intValue();
        return st.peek().intValue();
    }
    
    public int getMin() {
        return min.intValue();    
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */