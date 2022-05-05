class Solution {
public:
    
    int dp[10001] = {};
    
    int fun(int n, int t){
        
        if(t < 0){
            return 10000000;    
        }
        
        if(t == 0){
            return 1;
        }
        
        if(dp[t] != -1){
            return dp[t];
        }
        
        int ans = 10000000;
        
        for(int i = 1; i <= sqrt(n); i++){
            ans = min(ans, fun(n, t - (i * i)));        
        }
        
        dp[t] = ans + 1;
        
        return ans + 1;
    }
    
    int numSquares(int n) {
        
        memset(dp, -1, sizeof(dp));
        
        int k = sqrt(n);
        
        int ans = 10000000;
        
        for(int i = 1; i <= k; i++){
            ans = min(ans, fun(n,  n - (i * i)));        
        }
        
        return ans;
    }
};