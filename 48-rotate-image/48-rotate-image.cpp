class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        vector<vector<int>>ans;
        for(int i=0; i<matrix.size(); i++){
            ans.push_back(vector<int>(matrix[i].size()));
        }
        for(int i=0; i<matrix.size(); i++){
            for(int j=0; j<matrix[i].size(); j++){
                ans[j][matrix.size()-i-1]=matrix[i][j];
            }   
        }
        matrix=ans;
        return;
    }
};