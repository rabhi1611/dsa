class Solution {

    private int[] nums;
    private int total;
    private Random r;

    public Solution(int[] w) {
        this.r = new Random();

        for (int i = 1; i < w.length; i++) {
           w[i] += w[i - 1];
        }
        
        this.nums = w;
        this.total = w[w.length - 1];
    }
    
    public int pickIndex() {
        if (this.total == 0)
            return -1;

        int n = this.r.nextInt(this.total);
        for (int i = 0; i < this.nums.length; i++) {
            if (n < this.nums[i])
                return i;
        }
        
        return - 1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */