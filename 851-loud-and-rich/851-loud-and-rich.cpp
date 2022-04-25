class Solution {
public:
    
    void dfs(int node, vector<int>& visited, unordered_map<int, list<int>>& mp){
        
        visited[node] = 1;
        
        for(auto x: mp[node]){
            if(visited[x] == 0){
                visited[x] = 1;
                dfs(x, visited, mp);
            }
        }
    }
    
    
    vector<int> loudAndRich(vector<vector<int>>& richer, vector<int>& quiet) {
        
        int n = quiet.size();
        
        vector<int> ans(n , 0);
        
        unordered_map<int, list<int>> mp;
        
        
        for(int i = 0 ; i < richer.size(); i++){
            mp[richer[i][1]].push_back(richer[i][0]);
        }
        
        for(int i = 0; i < n; i++){
            
            vector<int> visited(n, 0);
            
            dfs(i, visited, mp);
            
            int temp = INT_MAX;
            int node = -1;
            
            for(int k = 0; k < n; k++){
                //cout<<visited[k]<<" ";
                if(visited[k] == 1){
                    if(quiet[k] < temp){
                        temp = quiet[k];
                        node = k;
                    }
                }
            }
            //cout<<endl;
            ans[i] = node;
        }
        return ans;
    }
};