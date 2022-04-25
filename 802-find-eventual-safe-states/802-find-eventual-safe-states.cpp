class Solution {
public:
    
    bool dfs(int node, unordered_map<int, list<int>>& mp, vector<int>& visited, 
            vector<int>& isSafe){
        if(mp[node].size() == 0){
            return true;
        }
        
        if(visited[node]){
            if(isSafe[node])    return true;
            return false;
        }
        
        visited[node] = 1;
        
        for(auto x: mp[node]){
            if(!dfs(x, mp, visited, isSafe)){
                return false;
            }
        }
        
        isSafe[node] = 1;
        return true;
    }
    
    
    
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        int n = graph.size();
        vector<int> ans;
        unordered_map<int, list<int>> mp;
        
        for(int i = 0; i < graph.size(); i++){
            for(int j = 0; j < graph[i].size(); j++){
                mp[i].push_back(graph[i][j]);
            }
        }
        
        vector<int> isSafe(n, 0);
        vector<int> visited(n, 0);
        
        for(int i = 0; i < n; i++){
            if(dfs(i, mp, visited, isSafe)){
                ans.push_back(i);   
            }
        }
        return ans;
    }
};