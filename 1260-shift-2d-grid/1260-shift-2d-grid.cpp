class Solution {
public:
    vector<vector<int>> shiftGrid(vector<vector<int>>& grid, int k) {
        int n=grid.size();
        int m=grid[0].size();
        k=k%(n*m);
        while(k--){
            int temp=grid[n-1][m-1];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    int t=grid[i][j];
                    grid[i][j]=temp;
                    temp=t;
                }
            }
        }
        return grid;
    }
};