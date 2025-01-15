class Pair {
    public int x;
    public int y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int ans = -1;

        int[][] visited = new int[n][m];
        Queue<Pair> q = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j));
                    visited[i][j] = 1;
                }
            }
        }
        
        while(!q.isEmpty()){
            int limit = q.size();
            ans++;

            while(limit > 0){
                Pair curr = q.poll();

                int curr_x = curr.x;
                int curr_y = curr.y;

                int[] nrows = new int[]{0, 0, 1, -1};
                int[] ncols = new int[]{1, -1, 0, 0};

                for(int i = 0; i < 4; i++){
                    int n_x = curr_x + nrows[i];
                    int n_y = curr_y + ncols[i];

                    if(n_x >= 0 && n_y >= 0 && n_x < n && n_y < m && grid[n_x][n_y] == 1 && visited[n_x][n_y] == 0){
                        q.add(new Pair(n_x, n_y));
                        visited[n_x][n_y] = 1;
                    }
                }
                limit--;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0 && grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return ans == -1 ? 0 : ans;
    }
}
