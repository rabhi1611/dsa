class Solution {
    public int countPrimes(int n) {
        // sieve
        int[] lp = new int[n + 1];

        for(int i = 2; i <= n; i++){
            lp[i] = 1;
        }

        for(int i = 2; (i * i) <= n; i++){
            if(lp[i] == 1){
                for(int j = i * i; j <= n; j += i){
                    lp[j] = 0;
                }
            }
        }

        int cnt = 0;

        // traverse
        for(int i = 0; i < n; i++){
            cnt += lp[i];
        }

        return cnt;
    }
}