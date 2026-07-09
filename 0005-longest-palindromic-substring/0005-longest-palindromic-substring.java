class Solution {

    int dp[][];

    public String longestPalindrome(String s) {
        int n = s.length();
        dp = new int[n][n];

        for(int i = 0; i < n; i += 1){
            for(int j = 0; j < n; j += 1){
                dp[i][j] = -1;
            }
        }

        int startIdx = 0, ans = Integer.MIN_VALUE;

        for(int i = 0; i < n; i += 1){
            for(int j = i; j < n; j += 1){
                if(isPalindrome(i, j, s) == true){
                    if((j - i + 1) > ans){
                        ans = j - i + 1;
                        startIdx = i;
                    }
                }
            }
        }

        return s.substring(startIdx, startIdx + ans);
    }

    private boolean isPalindrome(int start, int end, String s){
        if(start >= end){
            return true;
        }

        if(s.charAt(start) != s.charAt(end)){
            return false;
        }

        if(dp[start][end] != -1){
            return dp[start][end] == 1 ? true : false;
        }

        boolean result = isPalindrome(start + 1, end - 1, s);

        dp[start][end] = result == true ? 1 : 0;

        return result;
    }
}