class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = 0;

        int[][] visited = new int[n][m];

        for(int i = 0; i < n; i += 1){
            for(int j = 0; j < m; j += 1){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    // not visited
                    ans += 1;
                    // traverse all points and mark visited
                    dfs(i, j, n, m, grid, visited);
                }
            }            
        }

        return ans;
    }

    private void dfs(int i, int j, int n, int m, char[][] grid, int[][] visited){
        if(i < 0 || j < 0 || i >= n || j >= m){
            return;
        }

        // go down
        if(i + 1 < n && grid[i + 1][j] == '1' && visited[i + 1][j] == 0){
            visited[i + 1][j] = 1;
            dfs(i + 1, j, n, m, grid, visited);
        }

        // go up
        if(i - 1 >= 0 && grid[i - 1][j] == '1' && visited[i - 1][j] == 0){
            visited[i - 1][j] = 1;
            dfs(i - 1, j, n, m, grid, visited);
        }       

        // go left
        if(j - 1 >= 0 && grid[i][j - 1] == '1' && visited[i][j - 1] == 0){
            visited[i][j - 1] = 1;
            dfs(i, j - 1, n, m, grid, visited);
        }       

        // go right
        if(j + 1 < m && grid[i][j + 1] == '1' && visited[i][j + 1] == 0){
            visited[i][j + 1] = 1;
            dfs(i, j + 1, n, m, grid, visited);
        }   

        return;    
    }
}