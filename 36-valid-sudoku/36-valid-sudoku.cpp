class Solution {
public:
    
    
    bool isValidSudoku(vector<vector<char>>& board) {
        //bool ans = true;
        
        for(int i = 0; i < 9; i++){
            vector<int>v(10, 0);
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                //cout<<board[i][j] - 48<<" ";
                if(v[board[i][j] - 48] == 1){
                    return false;
                }
                v[board[i][j] - 48] = 1;
            }
        }
        
        for(int i = 0; i < 9; i++){
            vector<int>v(10, 0);
            for(int j = 0; j < 9; j++){
                if(board[j][i] == '.'){
                    continue;
                }
                if(v[board[j][i] - 48] == 1){
                    return false;
                }
                v[board[j][i] - 48] = 1;
            }
        }
        
        for(int i = 0; i < 9; i += 3){
            for(int j = 0; j < 9; j += 3){
                vector<int>v(10, 0);
                for(int k = 0; k <= 2; k++){
                    for(int l = 0; l <= 2; l++){
                        //cout<<"( "<<i+k <<", "<< j+l<<") ";
                        
                        if(board[i+k][j+l] == '.'){
                            continue;
                        }
                        //cout<<board[i+k][j+l]<<endl;
                        if(v[board[i+k][j+l] - 48] == 1){
                            return false;
                        }
                        v[board[i+k][j+l] - 48] = 1;
                    }
                }
            }
        }
        return true;
    }
};