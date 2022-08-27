class Solution {
public:
    
    int dp[201][10001];
    
    bool fun(vector<int>& arr, int n, int i, int sum){
       
        if(sum == 0){
            return true;
        }
        
        if(i >= n || sum < 0){
            return false;
        }
         
        
        if(dp[i][sum] != -1){
            return dp[i][sum];
        }
        
        int pk = fun(arr, n, i + 1, sum - arr[i]);
        int npk = fun(arr, n, i + 1, sum);
        
        if(pk){
            return dp[i][sum] = true;
        }
        if(npk){
            return dp[i][sum] = true;
        }
        return dp[i][sum] = false;
    }

    bool canPartition(vector<int>& arr) {
        memset(dp, -1, sizeof(dp));
        
        int sum = 0;
        
        for(int i = 0; i < arr.size(); i++){
            sum += arr[i];
        }
        
         if(sum % 2 == 1){
            return false;
        }
        
        return fun(arr, arr.size(), 0, sum / 2);
    }
};