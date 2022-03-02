class Solution {
public:
    
    int cnt(vector<vector<char>>& board, vector<int>& click){
        int ans = 0;
        int arr1[] = {-1, 0, 1, 0, -1, -1, 1, 1};
        int arr2[] = {0, 1, 0, -1, -1, 1, -1, 1};
        int k = 0;
        while(k < 8){
               if(click[0] + arr1[k] >= board.size() || click[0] + arr1[k] < 0 ||  click[1] + arr2[k] >= board[0].size() || click[1] + arr2[k] < 0 || board[click[0] + arr1[k]][click[1] + arr2[k]] != 'M'){
                 k++;
                 continue;
                }
                ans++;
                 k++;
            }
        return ans;
    }
    
    void fun(vector<vector<char>>& board, vector<int>& click){
        
        if(board[click[0]][click[1]] == 'M'){
            board[click[0]][click[1]] = 'X';
            return;
        }
        
        if(board[click[0]][click[1]] == 'B'){
            return;
        }
        
        if(board[click[0]][click[1]] == 'E'){
            cout<<cnt(board, click)<<" ";
            if(cnt(board, click) == 0){
                board[click[0]][click[1]] = 'B';
                
                int arr1[] = {-1, 0, 1, 0, -1, -1, 1, 1};
                int arr2[] = {0, 1, 0, -1, -1, 1, -1, 1};
                int k = 0;
                while(k < 8){
                    if(click[0] + arr1[k] >= board.size() || click[0] + arr1[k] < 0 ||  click[1] + arr2[k] >= board[0].size() || click[1] + arr2[k] < 0){
                        //cout<<"andr "<<click[0] + arr1[k]<<" "<<click[1] + arr2[k]<<endl;
                        k++;
                        continue;
                    }
                    //cout<<click[0] + arr1[k]<<" "<<click[1] + arr2[k]<<endl;
                    click[0] =  click[0] + arr1[k];
                    click[1] = click[1] + arr2[k];
                    fun(board, click);
                    click[0] =  click[0] - arr1[k];
                    click[1] = click[1] - arr2[k];
                    k++;
                }
            }else{
                board[click[0]][click[1]] = cnt(board, click) + 48;
            }
        }
        return;
    }
    
    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        fun(board, click);
        return board;
    }
};