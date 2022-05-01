
class Solution {
public:
    int dp[10001] = {};
        
    int fun(int idx, vector<int>& nums){
        
        if(idx > nums.size() - 1){
            return 10000000;
        }
            
            
        if(idx == nums.size() - 1){
            return 0;
        }
        
        if(dp[idx] != -1){
            return dp[idx];
        }
        
        int ans = 10000000;

        for(int i = 1; i <= nums[idx]; i++){
            ans = min(ans, fun(idx + i, nums));
        }
        
        if(ans != 10000000){
            dp[idx]= ans + 1;
            return ans + 1;
        }
        //cout<<ans<<" ";
        return 10000000;
    }
    
    
    int jump(vector<int>& nums) {
        memset(dp, -1, sizeof(dp));
        int idx = 0;
        int step = 0;
        return fun(idx, nums);;
    }
};