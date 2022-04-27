class Solution {
public:
    
    int dfs(int node, unordered_map<int, list<int>>& mp, vector<int>& visited){
        if(visited[node] == 1){
            return 0;
        }
        visited[node] = 1;
        
        int ans = 1;
        
        for(auto x: mp[node]){
            //if(visited[x] == 0){
                ans += dfs(x, mp, visited);
            //}
        }
        return ans;
    }
    
    
    int removeStones(vector<vector<int>>& stones) {
        
        int n = stones.size();
        
        unordered_map<int, list<int>> mp;
        
        for(int i = 0; i < stones.size(); i++){
            for(int j = i + 1; j < stones.size(); j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    mp[i].push_back(j);
                    mp[j].push_back(i);
                }
            }
        }
        
        vector<int> visited(n, 0);
        
        int ans = 0;
        
        for(int i = 0; i< n; i++){
            if(visited[i] == 0){
                ans += (dfs(i, mp, visited) - 1);
            }    
        }
        
        return ans;
    }
};