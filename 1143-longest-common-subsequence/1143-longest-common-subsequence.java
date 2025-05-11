class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        return helper(text1, text2, n - 1, m - 1, dp);
    }

    private int helper(String s1, String s2, int idx1, int idx2, int[][] dp){
        if(idx1 < 0 || idx2 < 0){
            return 0;
        }

        if(dp[idx1][idx2] != -1){
            return dp[idx1][idx2];
        }

        if(s1.charAt(idx1) == s2.charAt(idx2)){
            return 1 + helper(s1, s2, idx1 - 1, idx2 - 1, dp);
        }

        return Math.max(helper(s1, s2, idx1 - 1, idx2, dp), helper(s1, s2, idx1, idx2 - 1, dp));
    }
}