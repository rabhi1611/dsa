class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int n=grid.size();
        int m=grid[0].size();
        int t=(m*n);
        int p_c_1=0;
        
        for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(grid[i][j]==1){
                        p_c_1++;
                    }  
                }
        }
        vector<vector<int>> new_grid;
        
        
        for(int i=0;i<n;i++){
            new_grid.push_back({});
                for(int j=0;j<m;j++){
                    new_grid[i].push_back(grid[i][j]);  
                }
        }
        
        while(t){
            int c_1=p_c_1;        
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(grid[i][j]==0 || grid[i][j]==2){
                        continue;
                    }
                    if(i+1<n && grid[i+1][j]==2){
                        if(new_grid[i][j]==1){
                            c_1--;
                            new_grid[i][j]=2;
                        }
                        //break;
                    }
                    if(i-1>=0 && grid[i-1][j]==2){
                        if(new_grid[i][j]==1){
                            c_1--;
                            new_grid[i][j]=2;
                        }
                        //break;
                    }if(j+1<m && grid[i][j+1]==2){
                        if(new_grid[i][j]==1){
                            c_1--;
                            new_grid[i][j]=2;
                        }
                        //break;
                    }if(j-1>=0 && grid[i][j-1]==2){
                        if(new_grid[i][j]==1){
                            c_1--;
                            new_grid[i][j]=2;
                        }
                        //break;
                    }
                }
            }
            cout<<p_c_1<<" "<<c_1<<endl;
            cout<<t<<endl;
            if(c_1==p_c_1){
                break;
            }
            p_c_1=c_1;
            grid=new_grid;
            t--;
        }
        if(p_c_1>0){
            return -1;
        }
        return (m*n)-t;
    }
};