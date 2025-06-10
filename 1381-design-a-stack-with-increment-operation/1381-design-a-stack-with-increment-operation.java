class CustomStack {

    private Integer maxSize;
    private List<Integer> ls;
    
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.ls = new ArrayList<>();
    }
    
    public void push(int x) {
        if(ls.size() == maxSize){
            return;
        }

        ls.add(x);
    }
    
    public int pop() {
        if(ls.size() == 0){
            return -1;
        }

        int val = ls.get(ls.size() - 1);
        ls.remove(ls.size() - 1);

        return val;
    }
    
    public void increment(int k, int val) {
        for(int i = 0; i < Math.min(k, ls.size()); i += 1){
            ls.set(i, ls.get(i) + val);
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