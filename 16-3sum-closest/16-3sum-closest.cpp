class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        
        int ans1 = INT_MIN;
        int ans2 = INT_MAX;
        
        for(int k = 0; k < nums.size(); k++){
            int i = k + 1;
            int j = nums.size() - 1;
            
            while(i < j){
                //cout<<k<<" "<<i<<" "<<j<<endl;
                if(nums[i] + nums[j] + nums[k] <= target){
                    //cout<<nums[i] + nums[j] + nums[k]<<" ";
                    ans1 = max(ans1, nums[i] + nums[j] + nums[k]);
                    i++;
                }else{
                    //cout<<nums[i] + nums[j] + nums[k]<<" ";
                    ans2 = min(ans2, nums[i] + nums[j] + nums[k]);
                    j--;
                }
            }
        }
        if(ans1 == INT_MIN){
            return ans2;
        }
        if(ans2 == INT_MAX){
            return ans1;
        }
        return (target - ans1) <= (ans2 - target) ? ans1 : ans2;
    }
};