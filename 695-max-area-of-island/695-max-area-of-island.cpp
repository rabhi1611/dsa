class Solution {
public:
    map<pair<int, int>, list<pair<int, int>>> mp;
    
    void dfs(vector<vector<int>>& grid, vector<vector<int>>& visited, int& c, pair<int,int>& p){
        visited[p.first][p.second] = 1;
        c++;
        for(auto x: mp[{p.first,p.second}]){
            if(grid[x.first][x.second] == 1 && visited[x.first][x.second] == 0){
                dfs(grid, visited, c, x);
            }
        }
    }
    
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        
        for(int i = 0 ; i < grid.size(); i++){
            for(int j = 0; j < grid[i].size(); j++){
                
                if(grid[i][j] == 0){
                    continue;
                }
                
                if(i-1 >= 0 && grid[i-1][j] == 1){
                    mp[{i, j}].push_back({i-1, j});
                }
                
                if(i+1 < grid.size() && grid[i+1][j] == 1){
                    mp[{i, j}].push_back({i+1, j});
                }
                
                if(j-1 >= 0 && grid[i][j-1] == 1){
                    mp[{i, j}].push_back({i, j-1});
                }
                
                if(j+1 < grid[i].size() && grid[i][j+1] == 1){
                    mp[{i, j}].push_back({i, j+1});
                }
            }
        }
        
        vector<vector<int>>visited(grid.size(), vector<int>(grid[0].size()));
        
        int ans = 0;
        for(int i = 0 ; i < grid.size(); i++){
            for(int j = 0; j < grid[i].size(); j++){
                if(grid[i][j] == 0){
                    continue;
                }
                if(visited[i][j] == 1){
                    continue;
                }
                int c = 0;
                pair<int,int> p = {i,j};
                dfs(grid, visited, c, p);
                //cout<<c<<endl;
                ans = max(c, ans);
            }
        }
        return ans;
    }
};