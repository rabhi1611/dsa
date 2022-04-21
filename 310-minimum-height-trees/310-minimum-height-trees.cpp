class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
        
        if(n == 0){
            return {};
        }
        
        if(n == 1){
            return {0};
        }
        
        vector<int> ans;
        
        vector<int> indegree(n, 0);
        
        vector<vector<int>>adj(n);
        for(int i=0;i<edges.size();i++)
        {
            adj[edges[i][0]].push_back(edges[i][1]);//creating adjacent list
            adj[edges[i][1]].push_back(edges[i][0]);
            indegree[edges[i][1]]++;//updating how many edges each node has
            indegree[edges[i][0]]++;
        }
        
        
        queue<int>q;
        
        for(int i = 0; i < n; i++){
            if(indegree[i] == 1){
                q.push(i);
            }
        }
        
        while(!q.empty()){
            int size = q.size();
            ans.clear();
            
            for(int i = 0; i < size; i++){
            
                int node = q.front();
                q.pop();
                ans.push_back(node);
                for(auto &x: adj[node]){
                    indegree[x]--;
                    if(indegree[x] == 1){
                        q.push(x);
                    }
                }
            }
        }
        
        return ans;
    }
};