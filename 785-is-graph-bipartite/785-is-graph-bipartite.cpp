class Solution {
public:
    unordered_map<int, int>mp;
    bool ans = true;
    void dfs(vector<vector<int>>& graph, int idx){
        for(auto x: graph[idx]){
            
            int clr;
            if(mp[idx] == 1){
                clr = 2;
            }else{
                clr = 1;
            }
            
            if(mp.count(x) > 0){
                if(mp[x] != clr){
                    ans = false;
                    break;
                }else{
                    continue;
                }
            }
            mp[x] = clr;
            dfs(graph, x);
        }
    }
    
    bool isBipartite(vector<vector<int>>& graph) {
        
        // 1 mean red
        // 2 mean blue
        for(int i = 0; i < graph.size() ; i++){
            if(mp.count(i) == 0){
                mp[i] = 1;
                dfs(graph, i);
            }
        }
        
        return ans;   
    }
};