
class Solution {
public:
    int dp[10001] = {};
        
    int fun(vector<int>& arr, int n, int idx){
        if(idx >= n){
            return -1;
        }
        
        if(idx == n - 1){
            return 0;
        }
        
        if(dp[idx] != -1){
            return dp[idx];
        }
        
        int t = INT_MAX;
        
        for(int i = 1; i <= arr[idx]; i++){
            int temp = fun(arr, n, idx + i);
            if(temp != -1)
                t = min(t, temp);
        }
        
        if(t == INT_MAX){
            return -1;
        }
        
        dp[idx] = t + 1;
        return t + 1;
    }
    
    
    int jump(vector<int>& nums) {
        memset(dp, -1, sizeof(dp));
        return fun(nums, nums.size(), 0);
    }
};