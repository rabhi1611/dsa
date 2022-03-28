class Solution {
public:
    
    set<vector<int>> st;
    
    void fun(vector<int>& nums, vector<int>& bucket, int idx){
        if(idx >= nums.size()){
            st.insert(bucket);
            return;
        }
        bucket.push_back(nums[idx]);
        fun(nums, bucket, idx + 1);
        bucket.pop_back();
        fun(nums, bucket, idx + 1);
        return;
    }
    
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<int> bucket;
        fun(nums, bucket, 0);
        vector<vector<int>>ans;
        for(auto x: st){
            ans.push_back(x);
        }
        return ans;
    }
};