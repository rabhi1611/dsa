class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        
        queue<pair<int, int>> q;
        vector<vector<int>> visited(mat.size(), vector<int>(mat[0].size(), 0));
        
        for(int i = 0; i < mat.size(); i++){
            for(int j = 0; j < mat[i].size(); j++){
                if(mat[i][j] == 0){
                    q.push({i, j});
                    visited[i][j] = 1;
                }
            }
        }
        
        // apply bfs
        
        int dir[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while(q.size() > 0){
            pair<int, int> node = q.front();
            q.pop();
            
            int cr = node.first;
            int cc = node.second;
            
            for(int i = 0; i < 4; i++){
                int nr = cr + dir[i][0];
                int nc = cc + dir[i][1];
                
                if(nr >= 0 && nr < mat.size() && nc >= 0 && nc < mat[0].size() && visited[nr][nc] == 0){
                    mat[nr][nc] = mat[cr][cc] + 1;
                    q.push({nr, nc});
                    visited[nr][nc] = 1;
                }
            }
        }
        return mat;
    }
};