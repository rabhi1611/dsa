class Solution {
public:
    
    bool dfs(int node, unordered_map<int, list<int>>& mp, vector<int>& color){
        
        if(color[node] == -1)
            color[node] = 1;
        
        for(auto x: mp[node]){
            if(color[x] == -1){
                color[x] = 1 - color[node];
                if(dfs(x, mp, color) == false){
                    return false;
                }
            }else{
                if(color[x] == color[node]){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    
    bool possibleBipartition(int n, vector<vector<int>>& dislikes) {
        
        unordered_map<int, list<int>> mp;
        
        for(auto x: dislikes){
            mp[x[0]].push_back(x[1]);
            mp[x[1]].push_back(x[0]);
        }
        
        // check if circle is there or not?
        
        vector<int> color(n + 1, -1);
        
        for(int i = 1; i <= n; i++){
            if(dfs(i, mp, color) == false){
                return false;
            }
        }
        
        return true;
    }
};