class Solution {
public:
    vector<vector<int>> ans;
    
    void fun(int i, vector<int>& bucket, vector<int>& nums){
        if(i == nums.size()){
            ans.push_back(bucket);
            return;
        }
        
        bucket.push_back(nums[i]);
        fun(i + 1, bucket, nums);
        bucket.pop_back();
        fun(i + 1, bucket, nums);
        return;
    }
    
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<int> bucket;
        fun(0, bucket, nums);
        return ans;
    }
};