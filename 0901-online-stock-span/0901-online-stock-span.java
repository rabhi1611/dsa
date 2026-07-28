class Pair {
    int price;
    int index;

    Pair(int price, int index){
        this.price = price;
        this.index = index;
    }
}

class StockSpanner {

    private Stack<Pair> st;
    private int days;

    public StockSpanner() {
        this.st = new Stack<>();
        this.days = 0;
    }
    
    public int next(int price) {

        while(!st.isEmpty() && st.peek().price <= price){
            st.pop();
        }

        days += 1;

        if(st.size() == 0){
            st.push(new Pair(price, days));
            return days;
        }

        int ans = (days - st.peek().index);
        st.push(new Pair(price, days));
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */