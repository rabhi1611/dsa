class Solution {
public:
    
    void fun(vector<vector<int>>& matrix){
        
        unordered_set<int> s1;
        unordered_set<int> s2;
        
        for(int i = 0; i < matrix.size(); i++){
            for(int j = 0; j < matrix[i].size(); j++){
                if(matrix[i][j] == 0){
                    s1.insert(i);
                    s2.insert(j);
                }
            }
        }
        
        for(int i = 0; i < matrix.size(); i++){
            for(int j = 0; j < matrix[i].size(); j++){
                if(s1.count(i) != 0 || s2.count(j) != 0){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    
    void setZeroes(vector<vector<int>>& matrix) {
        fun(matrix);
    }
};