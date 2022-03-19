class Solution {
public:
    
    int fun(vector<int>& ans, int target){
        int s = 0;
        int e = ans.size() - 1;
        
        int idx = -1;
        while(s <= e){
            int mid = (s+e)/2;
            if(ans[mid] >= target){
                e = mid - 1;
            }else{
                idx = mid;
                s = mid + 1;
            }
        }
        return idx;
    }
    
    
    int lengthOfLIS(vector<int>& nums) {
        vector<int>ans;
        for(auto x: nums){
            int idx = fun(ans, x);
            if(idx + 1 < ans.size()){
                ans[idx + 1] = x;
            }else{
                ans.push_back(x);
            }
        }
        return ans.size();
    }
};