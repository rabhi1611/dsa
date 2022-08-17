class Solution {
public:
    
    int dp[101][101];
    
    int fun(vector<vector<int>>& matrix, int n, int m, int i, int j){
        if(i < 0){
            return INT_MAX;
        }
        
        if(j < 0){
            return INT_MAX;
        }
        
        if(i >= n){
            return INT_MAX;
        }
        
        if(j >= m){
            return INT_MAX;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        
        int a = fun(matrix, n, m, i + 1, j - 1);
        int b = fun(matrix, n, m, i + 1, j);
        int c = fun(matrix, n, m, i + 1, j + 1);
        
        if(a == INT_MAX && b == INT_MAX && c == INT_MAX){
            return dp[i][j] = matrix[i][j];
        }
        
        return dp[i][j] = min(a, min(b, c)) + matrix[i][j];
    }
    
    int minFallingPathSum(vector<vector<int>>& matrix) {
        
        memset(dp, -1, sizeof(dp));
        
        int ans = INT_MAX;
        for(int j = 0; j < matrix[0].size(); j++){
            ans = min(ans, fun(matrix, matrix.size(), matrix[0].size(), 0, j));
        }
        return  ans;
    }
};