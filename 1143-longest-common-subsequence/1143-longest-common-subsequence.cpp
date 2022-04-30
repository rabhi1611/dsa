
class Solution {
public:
    
    int dp[1001][1001] = {};
    
    int fun(string& s1, string& s2, int m, int n){
        
        if(m == 0 || n == 0){
            return 0;
        }
        
        
        if(dp[m - 1][n - 1] > 0){
            return dp[m - 1][n - 1];
        }
        
        if(s1[m - 1] == s2[n - 1]){
            return dp[m - 1][n - 1] = 1 + fun(s1, s2, m - 1, n - 1);
        }
        
        int t1 = fun(s1, s2, m - 1, n);
        int t2 = fun(s1, s2, m , n - 1);
        
        return dp[m - 1][n - 1] = max(t1, t2);
    }
    
    int longestCommonSubsequence(string text1, string text2) {
        //memset(dp, -1, sizeof(dp));
        return fun(text1, text2, text1.length(), text2.length());
    }
};