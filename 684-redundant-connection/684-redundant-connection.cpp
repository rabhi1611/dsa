class Solution {
public:
    
    bool dfs(int node, unordered_map<int, list<int>>& mp, vector<int>& visited, int parent){
        visited[node] = 1;
        
        for(auto x: mp[node]){
            if(visited[x] == 1 && x != parent){
                return true;
            }
            if(visited[x] == 0){
                bool ans = dfs(x, mp, visited, node);
                if(ans == true){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        
        unordered_map<int, list<int>> mp;
        
        for(auto x: edges){
            mp[x[0]].push_back(x[1]);
            mp[x[1]].push_back(x[0]);
            
            vector<int> visited(1001, 0);
            
            if(dfs(x[0], mp, visited, -1) == true){
                return {x[0], x[1]};
            }
        }
        
        return {};
    }
};