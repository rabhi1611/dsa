class Solution {
public:
  
    void fun(unordered_map<string, multiset<string>>& mp, string s, vector<string>& ans){
         
        while(mp[s].size()){
            string v = *(mp[s].begin());
            mp[s].erase(mp[s].begin());
            fun(mp, v, ans);
        }
        
        ans.push_back(s);
    }
    
    
    vector<string> findItinerary(vector<vector<string>>& tickets) {
        unordered_map<string, multiset<string>>mp;
        
        for(auto x:tickets){
            mp[x[0]].insert(x[1]);
        }
        
        vector<string>ans;
        
        fun(mp, "JFK", ans);
        
        reverse(ans.begin(), ans.end());
        return ans;
    }
};