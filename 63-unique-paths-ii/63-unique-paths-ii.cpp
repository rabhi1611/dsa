class Solution {
public:
    map<pair<int, int>, int> mp;
    
    int fun(vector<vector<int>>& obstacleGrid, int i, int j, vector<string>& path){
        
        if(i >= obstacleGrid.size()){
            return 0;
        }
        
        if(j >= obstacleGrid[0].size()){
            return 0;
        }
        
        if(obstacleGrid[i][j] == 1){
            return 0;
        }
        
        if(i == obstacleGrid.size() - 1 && j == obstacleGrid[0].size() - 1){
            // path mila
            //for(auto x: path){
              //  cout<<x<<"-> ";
            //}
            //cout<<endl;
            return 1;
        }
        int a, b;
        
        if(mp.count({i + 1, j}) == 0){
            path.push_back("Down");
            mp[{i+1, j}] = fun(obstacleGrid, i + 1, j, path);
            path.pop_back();
        }
        
        a = mp[{i+1, j}];
        
        if(mp.count({i, j + 1}) == 0){
            path.push_back("Right");
            mp[{i, j + 1}] = fun(obstacleGrid, i, j + 1, path);
            if(path.size() != 0){
                path.pop_back();
            }
        }
        
        b = mp[{i, j + 1}];
        
        mp[{i, j}] = a + b;
        return a + b;
    }
    
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        vector<string>path;
        return fun(obstacleGrid, 0, 0, path);
    }
};