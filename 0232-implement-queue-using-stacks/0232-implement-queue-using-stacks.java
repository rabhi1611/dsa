class MyQueue {
    private final Stack<Integer> st1;
    private final Stack<Integer> st2;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int x) {
        st1.push(x);
    }
    
    public int pop() {
        fill();
        int ans = st2.pop();
        unfill();
        return ans;
    }
    
    public int peek() {
        fill();
        int ans = st2.peek();
        unfill();
        return ans;
    }
    
    public boolean empty() {
        return st1.isEmpty();
    }

    private void fill() {
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
    }

    private void unfill(){
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
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