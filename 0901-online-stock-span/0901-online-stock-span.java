class Pair {
    public int fir;
    public int sec;
    
    Pair(int fir, int sec){
        this.fir = fir;
        this.sec = sec;
    }
}

class StockSpanner {
    
    int idx = -1;
    Stack<Pair> st = new Stack<>();
    
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        idx++;
        
        while(!st.isEmpty() && st.peek().sec <= price){
            st.pop();
        }
        
        int ans = st.isEmpty() ? idx + 1 : idx - st.peek().fir;
        
        st.push(new Pair(idx, price));
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */