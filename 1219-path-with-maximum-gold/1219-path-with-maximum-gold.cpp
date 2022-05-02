class Solution {
public:
    
    void dfs(pair<int, int> cell, vector<vector<int>>& visited, vector<vector<int>>& grid, int c, int& ans){
        
        int c_i = cell.first;
        int c_j = cell.second;
        
        visited[c_i][c_j] = 1;
        
        int arr1[] = {0, 1, -1, 0};
        int arr2[] = {1, 0, 0, -1};
        
        
        for(int i = 0; i < 4; i++){
            int n_i = c_i + arr1[i];
            int n_j = c_j + arr2[i];
            
            if(n_i < 0 || n_j < 0 || n_i >= grid.size() || n_j >= grid[n_i].size() || grid[n_i][n_j] == 0){
                continue;
            }    
            if(visited[n_i][n_j] == 0){
                dfs({n_i, n_j}, visited, grid, c + grid[n_i][n_j], ans);
            }
        }
        //cout<<ans<<endl;
        ans = max(ans, c);
        
        visited[c_i][c_j] = 0;
    }
    
    
    int getMaximumGold(vector<vector<int>>& grid) {
        
        int result = 0;
        
        int n = grid.size();
        int m = grid[0].size();
        
        for(int i = 0; i < grid.size(); i++){
            for(int j  = 0; j < grid[i].size(); j++){
                vector<vector<int>> visited(n, vector<int>(m, 0));
                if(grid[i][j] != 0 && visited[i][j] == 0){
                    int ans = 0;
                    int c = grid[i][j];
                    dfs({i , j}, visited, grid, c, ans);
                    /*for(auto x: visited){
                        
                            cout<<x.first<<", "<<x.second<<endl;
                        
                        //cout<<endl;
                    }
                    cout<<endl;
                    cout<<i<<" "<<j<<" -> "<<ans<<endl;
                    cout<<endl;*/
                    result = max(result, ans);
                }
            }
        }
        return result;
    }
};