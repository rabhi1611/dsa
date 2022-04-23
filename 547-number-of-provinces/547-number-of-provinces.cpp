class Solution {
public:
    
    void dfs(int node, unordered_map<int, list<int>>& mp, vector<int>& visited){
        visited[node] = 1;
        
        for(auto x: mp[node]){
            if(visited[x] == 0){
                dfs(x, mp, visited);
            }
        }
    }
    
    int findCircleNum(vector<vector<int>>& isConnected) {
        unordered_map<int, list<int>> mp;
        
        for(int i = 0; i < isConnected.size(); i++){
            for(int j = 0; j < isConnected[i].size(); j++){
                if(isConnected[i][j] == 1){
                    if((i + 1) != (j + 1)){
                        mp[i + 1].push_back(j + 1);
                    }
                }
            }
        }
        
        vector<int> visited(201, 0);
        int ans = 0;
        
        for(int i = 1; i <= isConnected.size(); i++){
            if(visited[i] == 0){
                ans++;
                dfs(i, mp, visited);
            }
        }
        return ans;
    }
};