class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        Arrays.sort(piles);
        
        int l = 0, r = piles[n - 1], ans = piles[n - 1];

        int[] tPiles = piles.clone();

        while(l <= r){
            int k = (l + r) / 2;

            if(withInH(tPiles, n, k, h)){
                ans = k;
                r = k - 1;
            } else {
                l = k + 1;
            }

            tPiles = piles.clone();
        }

        return ans;
    }

    private boolean withInH(int[] piles, int n, int k, int ah){
        if(k == 0)  return false;

        int th = 0;
        int i = n - 1;

        while(i >= 0){
            th += piles[i] / k;
            if(piles[i] % k > 0){
                th += 1;
            }

            if(th > ah){
                return false;
            }
            i -= 1;
        }

        return true;
    }
}