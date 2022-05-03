class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& mat) {
        
        int n = mat.size();
        int m = mat[0].size();
        
        vector<int>ans;
        
        int c = 0;
        
        int i = 0, j = 0;
        
        while(c != (m*n)){
            if(c == (m*n)){
                break;
            }
            c++;
            ans.push_back(mat[i][j]);
            //cout<<i<<" "<<j<<endl;
            while(i - 1 >= 0 && j + 1 < m){
                if(c == (m*n)){
                    break;
                }
                i -= 1;
                j += 1;
                c++;
                //cout<<i<<" "<<j<<endl;
                ans.push_back(mat[i][j]);
            }

            if(i - 1 < 0 && j + 1 >= m){
                i += 1;
            }

            else if(i - 1 < 0){
                j += 1;
            }

            else if(j + 1 >= m){
                i += 1;
            }

            if(c == (m*n)){
                break;
            }
            c++;
            ans.push_back(mat[i][j]);
            //cout<<i<<" "<<j<<endl;
            while(i + 1 < n && j - 1 >= 0){
                if(c == (m*n)){
                    break;
                }
                i += 1;
                j -= 1;
                c++;
                //cout<<i<<" "<<j<<endl;
                ans.push_back(mat[i][j]);
            }

            if(i + 1 >= n && j - 1 < 0){
                j += 1;
            }

            else if(i + 1 >= n){
                j += 1;
            }
            else if(j - 1 < 0){
                i += 1;   
            }
        }
        return ans;
    }
};