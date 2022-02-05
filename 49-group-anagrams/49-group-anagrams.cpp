class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        map<vector<int>, vector<string>> mp;
        
        for(auto x: strs){
            vector<int>v(26);
            for(auto y: x){
                v[y - 97]++;
            }
            mp[v].push_back(x);
        }
        
        vector<vector<string>> ans;
        for(auto x: mp){
            vector<string>temp;
            for(auto y: x.second){
                temp.push_back(y);
            }
            ans.push_back(temp);
        }
        return ans;
    }
};