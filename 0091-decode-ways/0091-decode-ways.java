class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[102];
        Arrays.fill(dp, -1);
        return helper(0, n, s, dp);
    }


    private int helper(int i, int n, String s, int[] dp){
        if(i >= n){
            return 1;
        }

        if(dp[i] != -1) return dp[i];

        int sa1 = -1, sa2 = -1;

        String t =  "" + s.charAt(i);

        if(Integer.valueOf(t) >= 1 && Integer.valueOf(t) <= 9){
            sa1 = helper(i + 1, n, s, dp);
        }

        if(i + 1 < n){
            t += s.charAt(i + 1); 
            if(Integer.valueOf(t) >= 10 && Integer.valueOf(t) <= 26){
                sa2 = helper(i + 2, n, s, dp);
            }
        }

        if(sa1 == -1 && sa2 == -1){
            return 0;
        }

        else if(sa1 == -1){
            return sa2;
        }

        else if(sa2 == -1){
            return sa1;
        }

        return dp[i] = sa1 + sa2;
    }
}