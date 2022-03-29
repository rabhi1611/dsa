class Solution {
public:
    
    void fun(vector<vector<int>>& matrix, vector<vector<int>>& t_grid){
        for(int i = 0; i < matrix.size(); i++){
            for(int j = 0; j < matrix[i].size(); j++){
                if(matrix[i][j] == 0){
                    for(int k = 0; k < matrix[i].size(); k++){
                        t_grid[i][k] = 0;
                    }
                    for(int k = 0; k < matrix.size(); k++){
                        t_grid[k][j] = 0;
                    }
                }
            }
        }
    }
    
    void setZeroes(vector<vector<int>>& matrix) {
        vector<vector<int>> t_grid(matrix.size(), vector<int>(matrix[0].size(), 0));
        for(int i = 0; i < matrix.size(); i++){
            for(int j = 0; j < matrix[i].size(); j++){
                t_grid[i][j] = matrix[i][j];
            }
        }
        fun(matrix, t_grid);
        for(int i = 0; i < matrix.size(); i++){
            for(int j = 0; j < matrix[i].size(); j++){
                matrix[i][j] = t_grid[i][j];
            }
        }
    }
};