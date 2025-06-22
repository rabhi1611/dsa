class Solution {

    private List<Integer> ls;
    private Random r;

    public Solution(int[] w) {
        this.ls = new ArrayList<>();
        this.r = new Random();

        for (int i = 0; i < w.length; i++)
            for (int j = 0; j < w[i]; j++)
                this.ls.add(i);
    }
    
    public int pickIndex() {
        return this.ls.get(r.nextInt(ls.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */