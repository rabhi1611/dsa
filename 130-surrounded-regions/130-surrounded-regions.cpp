class Solution {
public:
    void solve(vector<vector<char>>& board) {
        
        vector<pair<int, int>>zeros;
        
        for(int i = 0; i < board.size(); i++){
            for(int j = 0; j < board[i].size(); j++){
                if(i == 0 || i == (board.size() - 1) || j == 0 || j == (board[i].size() - 1)){
                    continue;
                }
                //cout<<i<<" "<<j<<endl;
                if(board[i][j] == 'O'){
                    zeros.push_back({i, j});
                }
            }
        }
        
        int arr1[] = {0, 1, -1, 0};
        int arr2[] = {1, 0, 0, -1};
        
        set<pair<int, int>>visited;
        
        for(auto x: zeros){
            int c_i = x.first;
            int c_j = x.second;
            
            if(visited.count({c_i, c_j}) == 0){
                
                vector<pair<int, int>> ans;
                
                queue<pair<int, int>>q;
                q.push({c_i, c_j});
                visited.insert({c_i, c_j});
                
                while(!q.empty()){
                    pair<int, int> p = q.front();
                    q.pop();
                    ans.push_back(p);
                    int q_c_i = p.first;
                    int q_c_j = p.second;
                    
                    for(int i = 0; i < 4; i++){
                        int q_n_i = arr1[i] + q_c_i;
                        int q_n_j = arr2[i] + q_c_j;
                        
                        if(q_n_i < 0 || q_n_i >= board.size() || q_n_j < 0 || q_n_j >= board[q_n_i].size()){
                            continue;
                        }
                        if(board[q_n_i][q_n_j] == 'O' && visited.count({q_n_i, q_n_j}) == 0){
                            visited.insert({q_n_i, q_n_j});
                            q.push({q_n_i, q_n_j});
                        }
                    }
                }
                bool flag = true;
                
                for(auto x: ans){
                    if(x.first == board.size() - 1 || x.second == board[x.first].size() - 1 || x.first == 0 || x.second == 0){
                        flag = false;
                        break;
                    }    
                }
                
                if(flag){
                    for(auto x: ans){
                        board[x.first][x.second] = 'X';
                    }
                }
            }
        }
    }
};