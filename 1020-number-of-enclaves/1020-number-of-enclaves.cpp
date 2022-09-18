class Solution {
public:
    int numEnclaves(vector<vector<int>>& grid) {
        
        queue<pair<int, int>> q;
        
        vector<vector<int>>visited(grid.size(), vector<int>(grid[0].size(), 0));
        
        for(int i = 0; i < grid.size(); i++){
            for(int j = 0; j < grid[i].size(); j++){
                if(i == 0 || j == 0 || i == grid.size() - 1 || j == grid[i].size() - 1){
                    if(grid[i][j] == 1){
                        q.push({i, j});
                        //cout<<i<<" "<<j<<endl;
                        visited[i][j] = 1;
                    }
                }
            }
        }
        
        
        while(!q.empty()){
            int i = q.front().first;
            int j = q.front().second;
            
            q.pop();
            
            int arr1[] = {1, -1, 0, 0};
            int arr2[] = {0, 0, 1, -1};
            
            for(int k = 0; k < 4; k++){
                int ni = i + arr1[k];
                int nj = j + arr2[k];
                
                if(ni < 0 || nj < 0 || ni >= grid.size() || nj >= grid[0].size() || grid[ni][nj] == 0 || visited[ni][nj] == 1){
                    continue;
                }
                
                q.push({ni, nj});
                visited[ni][nj] = 1;
            }
        }
        
        int ans = 0;
        
        for(int i = 0; i < visited.size(); i++){
            for(int j = 0; j < visited[i].size(); j++){
                if(grid[i][j] == 1 && visited[i][j] == 0)   ans++;
            }
        }
        return ans;
    }
};