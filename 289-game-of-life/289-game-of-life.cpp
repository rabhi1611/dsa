class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        vector<vector<int>> ans;
        for(int i = 0; i<board.size(); i++){
            vector<int>v;
            for(int j = 0; j<board[i].size(); j++){
                v.push_back(0);
            }
            ans.push_back(v);
        }
        
        
        for(int i = 0; i<board.size(); i++){
            for(int j = 0; j<board[i].size(); j++){
                // count no. of live neighbours
                int c_lsn = 0;
                if(j-1 >= 0){
                    if(board[i][j-1] == 1){
                        c_lsn++;
                    }
                }
                if(j+1 < board[i].size()){
                    if(board[i][j+1] == 1){
                        c_lsn++;
                    }
                }
                if(i-1 >= 0){
                    if(board[i-1][j] == 1){
                        c_lsn++;
                    }
                }
                
                if(i+1 < board.size()){
                    if(board[i+1][j] == 1){
                        c_lsn++;
                    }
                }
                
                
                if(i-1 >= 0 && j-1 >= 0){
                    if(board[i-1][j-1] == 1){
                        c_lsn++;
                    }
                }
                
                if(i-1 >= 0 && j+1 < board[i].size()){
                    if(board[i-1][j+1] == 1){
                        c_lsn++;
                    }
                }
                
                if(i+1 < board.size() && j-1 >= 0){
                    if(board[i+1][j-1] == 1){
                        c_lsn++;
                    }
                }
                
                if(i+1 < board.size() && j+1 < board[i].size()){
                    if(board[i+1][j+1] == 1){
                        c_lsn++;
                    }
                }
                
                bool is_live;
                if(board[i][j] == 1){
                    is_live = true;
                }else{
                    is_live = false;
                }
                
                
                if(is_live){
                    if(c_lsn < 2){
                        ans[i][j] = 0;
                    }else if(c_lsn == 2 || c_lsn == 3){
                        ans[i][j] = 1;
                    }
                    else{
                        ans[i][j] = 0;
                    }
                }else{
                    if(c_lsn == 3){
                        ans[i][j] = 1;
                    }
                }
            }
        }
        board = ans;
        return;
    }
};