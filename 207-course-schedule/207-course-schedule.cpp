class Solution {
public:
    unordered_map<int, list<int>> mp;
    
    bool dfs(vector<int>& visited, vector<int>& path, int i){
        visited[i] = 1;
        path[i] = 1;
        
        for(auto x: mp[i]){
            if(path[x] == 1){
                return false;
            }
            
            if(visited[x] == 0){
                bool is_cycle = dfs(visited, path, x);
                if(is_cycle == false){
                    return false;
                }
            }
        }
        
        path[i] = 0;
        return true;
    }
    
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        
        for(auto x: prerequisites){
            mp[x[0]].push_back(x[1]);
        }
        
        vector<int>visited(numCourses, 0);
        vector<int>path(numCourses, 0);
        
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0){
                if(dfs(visited, path, i) == false){
                    return false;
                }
            }
        }
        return true;
    }
};