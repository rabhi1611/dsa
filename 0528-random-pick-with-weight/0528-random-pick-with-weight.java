class Solution {

    private int[] nums;
    private int total;
    private Random r;

    public Solution(int[] w) {
        this.nums = new int[w.length];
        this.r = new Random();

        int runningTotal = 0;
        for (int i = 0; i < w.length; i++) {
            runningTotal += w[i];
            this.nums[i] = runningTotal;
        }
        
        this.total = runningTotal;
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