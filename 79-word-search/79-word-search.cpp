class Solution {
public:
    
    bool dfs(vector<vector<char>>& board, string word, int k, int i, int j){
        if(k == word.size()){
            return true;
        }
        if(i < 0 || j < 0 || i >= board.size() || j >= board[i].size() || word[k] != board[i][j]){
            return false;
        }
        
        
        bool ans = false;
        char temp = board[i][j];
        board[i][j] = ' ';
        
            if(dfs(board, word, k + 1, i - 1, j)){
                ans = true;
            }
        
        
        
            if(dfs(board, word, k + 1, i + 1, j)){
                ans = true;
            }
        
        
            if(dfs(board, word, k + 1, i, j - 1)){
                ans = true;
            }
        
        
        
            if(dfs(board, word, k + 1, i, j + 1)){
                ans = true;
            }
    
    
        board[i][j] = temp;
        return ans;
    }
    
    
    bool exist(vector<vector<char>>& board, string word) {
        bool ans = false;
        for(int i = 0; i < board.size(); i++){
            for(int j = 0; j < board[i].size(); j++){
                if(word[0] == board[i][j]){
                    if(dfs(board, word, 0, i, j)){
                        ans = true;
                        break;
                    }
                }
            }
        }
        return ans;
    }
};