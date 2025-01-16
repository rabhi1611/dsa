
class Solution {
 
    private void dfs(char[][] board, int x, int y, int[][] visited, int n, int m){

        visited[x][y] = 1;

        int[] rows = new int[]{1, -1, 0, 0};
        int[] cols = new int[]{0, 0, 1, -1};

        for(int i = 0; i < 4; i++){
            int nx = x + rows[i];
            int ny = y + cols[i];

            if(nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny] == 0 && board[nx][ny] == 'O'){
                dfs(board, nx, ny, visited, n, m);
            }
        }
    }
 
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] visited = new int[n][m];

        for(int i = 0; i < n; i++){
            if(!(i == 0 || i == n - 1)){
                continue;
            }
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0 && board[i][j] == 'O')  {
                    dfs(board, i, j, visited, n, m);
                }
            }
        }

        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!(j == 0 || j == m - 1)){
                    continue;
                }
                if(visited[i][j] == 0 && board[i][j] == 'O')  {
                    dfs(board, i, j, visited, n, m);
                }
            }
        }

        
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0 && board[i][j] == 'O')  {
                    board[i][j] = 'X'; 
                }
            }
        }
    }
}