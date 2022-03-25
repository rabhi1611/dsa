class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        vector<vector<int>> ans;
        if(nums.size() <= 3){
            return ans;
        }
        sort(nums.begin(), nums.end());
        unordered_map<long long, vector<long long>> mp;
        for(int i = 0; i < nums.size(); i++){
            mp[nums[i]].push_back(i);
        }
        
        vector<vector<int>>v;
        
        
        for(int i = 0; i < nums.size(); i++){
            for(int j = i + 1; j < nums.size(); j++){
                // 2 sum lga do
                unordered_map<int, int>mp;
                int t = target - nums[i] - nums[j];
                int s = j + 1;
                int e = nums.size() - 1;
                while(s < e){    
                    if(nums[s] + nums[e] > t){
                        e--;
                    }
                    else if(nums[s] + nums[e] < t){
                        s++;
                    }else{
                        v.push_back({nums[i], nums[j], nums[s], nums[e]});
                        s++;
                    }
                }
            }
        }
        
        set<vector<int>>r_s;
        
        
        for(auto x: v){
            r_s.insert(x);
        }
        for(auto x: r_s){
            ans.push_back(x);
        }
        return ans;
    }
};