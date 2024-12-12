class MyStack {

    Queue<Integer> q = new LinkedList<>();
    
    public MyStack() {
        
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        Queue<Integer> tq = new LinkedList<>();
        
        int ans = -1;
        
        while(!q.isEmpty()) {
            int tempVar = q.remove();
            if(q.isEmpty()){
                ans = tempVar; 
            } else {
                tq.add(tempVar);
            }
        }
        
        while(!tq.isEmpty()){
            q.add(tq.remove());
        }
        
        return ans;
    }
    
    public int top() {
        Queue<Integer> tq = new LinkedList<>();
        
        int ans = -1;
        
        while(!q.isEmpty()) {
            int tempVar = q.remove();
            if(q.isEmpty()){
                ans = tempVar; 
            }
            tq.add(tempVar);
        }
        
        while(!tq.isEmpty()){
            q.add(tq.remove());
        }
        
        return ans;
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */