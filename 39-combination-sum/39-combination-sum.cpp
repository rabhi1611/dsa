class Solution {
public:
    vector<vector<int>> ans;
    
    void fun(vector<int>& candidates, int rem, vector<int>& v, int i){
        if(rem < 0){
            return;
        }
        if(rem == 0){
            ans.push_back(v);
            return;
        }
        for(int k = i; k < candidates.size(); k++){
            while(rem - candidates[k] >= 0){
                //cout<<x<<" ";
                v.push_back(candidates[k]);
                rem = rem - candidates[k];
                fun(candidates, rem, v, k);
                v.pop_back();
                rem = rem + candidates[k];
                break;
            }
        }
        return;
    }
    
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> v;
        fun(candidates, target, v, 0);
        return ans;
    }
};