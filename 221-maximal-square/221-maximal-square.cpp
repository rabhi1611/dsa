class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int ans = 0;
        
        vector<vector<int>>v(matrix.size(), vector<int>(matrix[0].size(), 0));
        
        for(int i = 0; i < matrix.size(); i++){
            int sum1 = 0;
            for(int j = 0; j < matrix[i].size(); j++){
                sum1 += (matrix[i][j] - 48);
                v[i][j] = sum1;
            }
        }
        
        for(int i = 0; i < matrix[0].size(); i++){
            int sum2 = 0;
            for(int j = 0; j < matrix.size(); j++){
                sum2 += (v[j][i]);
                v[j][i] = sum2;
            }
        }
        
        /*for(int i = 0; i < matrix.size(); i++){
            for(int j = 0; j < matrix[i].size(); j++){
                cout<<v[i][j]<<" ";    
            }
            cout<<endl;
        }*/
        
        
        for(int i = 0; i < v.size(); i++){
            for(int j = 0; j < v[i].size(); j++){
                int k = i ;
                int l = j ;
                while(k < matrix.size() && l < matrix[i].size()){
                    int sum = 0;
                    sum += v[k][l];
                    if(j-1 >=0 ){
                        sum -= v[k][j-1];
                    }
                    if(i-1 >= 0){
                        sum -= v[i-1][l];
                    }
                    if(i-1 >= 0 && j-1 >= 0){
                        sum += v[i-1][j-1];
                    }
                    //cout<<sum<<" ";
                    if(sum  == ((l-j+1)*(k-i+1))){
                        ans = max(ans, sum);
                    }
                    k++;
                    l++;
                }
                //ans = max(ans, c);
            }
        }
        return ans;
    }
};