class Solution {
public:
    vector<vector<string>> ans;
    void fun(int n, vector<vector<char>> grid, int i, int j,
            vector<vector<char>> helper_grid){
        if(i >= n){
            // put ans
            vector<string>v;
            for(auto x: grid){
                string s="";
                for(auto y: x){
                    s += y;
                }
                v.push_back(s);
            }
            ans.push_back(v);
            return;
        }
        
        if(helper_grid[i][j] == '-'){
            return;
        }
        
        grid[i][j] = 'Q';
        
        for(int k = 0; k < n; k++){
            if(k == j){
                continue;
            }
            helper_grid[i][k] = '-';
        }
        
        for(int k = 0; k < n; k++){
            if(k == i){
                continue;
            }
            helper_grid[k][j] = '-';
        }
        
        int t_i = i + 1;
        int t_j = j + 1;
        
        while(t_i < n && t_j < n){
            helper_grid[t_i][t_j] = '-';
            t_i++;
            t_j++;
        }
        
        t_i = i - 1;
        t_j = j + 1;
        
        while(t_i >= 0 && t_j < n){
            helper_grid[t_i][t_j] = '-';
            t_i--;
            t_j++;
        }
        
        t_i = i - 1;
        t_j = j - 1;
        
        
        while(t_i >= 0 && t_j >= 0){
            helper_grid[t_i][t_j] = '-';
            t_i--;
            t_j--;
        }
        
        t_i = i + 1;
        t_j = j - 1;
        
        while(t_i < n && t_j >= 0){
            helper_grid[t_i][t_j] = '-';
            t_i++;
            t_j--;
        }
        
        
        for(int k = 0; k < grid[i].size(); k++){
            if(i + 1 >= n){
                fun(n, grid, i + 1, k, helper_grid);
                break;
            }
            fun(n, grid, i + 1, k, helper_grid);
        }
        return;
    }
    
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<char>>grid(n, vector<char>(n, '.'));
        vector<vector<char>>helper_grid(n, vector<char>(n, '.'));
        for(int j = 0; j < grid[0].size(); j++){
            fun(n, grid, 0, j, helper_grid);
        }
        return ans;
    }
};