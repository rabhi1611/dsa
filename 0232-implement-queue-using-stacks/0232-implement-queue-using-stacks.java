class MyQueue {
    
    Stack<Integer> st = new Stack<>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        Stack<Integer> tst = new Stack<>();
        
        while(!st.isEmpty()){
            int tempVar = st.pop();
            tst.push(tempVar);
            
        }
        
        int ans = tst.pop();
        
        while(!tst.isEmpty()){
            int tempVar = tst.pop();
            st.push(tempVar);
            
        }
        
        return ans;
    }
    
    public int peek() {
        Stack<Integer> tst = new Stack<>();
        
        while(!st.isEmpty()){
            int tempVar = st.pop();
            tst.push(tempVar);
            
        }
        
        int ans = tst.peek();
        
        while(!tst.isEmpty()){
            int tempVar = tst.pop();
            st.push(tempVar);
            
        }
        
        return ans;        
    }
    
    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */