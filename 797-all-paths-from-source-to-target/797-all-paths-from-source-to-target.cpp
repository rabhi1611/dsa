class Solution {
public:
    vector<vector<int>> ans;
    
    void dfs(int node, unordered_map<int, list<int>>& mp, vector<int>& visited
            , vector<int>& temp, int n){
        
        visited[node] = 1;
        
        temp.push_back(node);
        
        if(node == n - 1){
            ans.push_back(temp);
            visited[node] = 0;
            temp.pop_back();
            return;
        }
        
        for(auto x: mp[node]){
            if(visited[x] == 0){
                dfs(x, mp, visited, temp, n);
            }
        }
        
        visited[node] = 0;
        temp.pop_back();
    }
    
    
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        
        unordered_map<int, list<int>> mp;
        
        for(int i = 0; i < graph.size(); i++){
            for(int j = 0; j < graph[i].size(); j++){
                mp[i].push_back(graph[i][j]);
            }
        }
        
        
        vector<int> visited(16, 0);
        
        vector<int> temp;
        
        dfs(0, mp, visited, temp, graph.size());
        return ans;
    }
};