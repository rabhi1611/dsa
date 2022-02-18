class Solution {
public:
    vector<vector<int>> ans;
    
    void fun(vector<int>& nums, unordered_set<int>& s){
        if(s.size() == nums.size()){
            vector<int>v;
            for(auto x: s){
                v.push_back(nums[x]);
            }
            ans.push_back(v);
            return;
        }
        
        for(int j = 0; j < nums.size(); j++){
            if(s.count(j) > 0){
                continue;
            }
            s.insert(j);
            fun(nums, s);
            auto it = s.find(j);
            s.erase(it);
        }
        return;
    }
    
    vector<vector<int>> permute(vector<int>& nums) {
        unordered_set<int> s;
        for(int i = 0; i<nums.size(); i++){
            s.insert(i);
            fun(nums, s);
            auto it = s.find(i);
            s.erase(it);
        }
        return ans;
    }
};