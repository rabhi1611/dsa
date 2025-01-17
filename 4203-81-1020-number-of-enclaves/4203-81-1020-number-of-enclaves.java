class Pair {
    int x;
    int y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        Queue<Pair> q = new ArrayDeque<>();
        
        for(int j = 0; j < m; j++){
            if(grid[0][j] == 1 && visited[0][j] == 0){
                q.add(new Pair(0, j));
                visited[0][j] = 1;
            }

            if(grid[n - 1][j] == 1 && visited[n - 1][j] == 0){
                q.add(new Pair(n - 1, j));
                visited[n - 1][j] = 1;
            }
        }

        for(int i = 0; i < n; i++){
            if(grid[i][0] == 1 && visited[i][0] == 0){
                q.add(new Pair(i, 0));
                visited[i][0] = 1;
            }

            if(grid[i][m - 1] == 1 && visited[i][m - 1] == 0){
                q.add(new Pair(i, m - 1));
                visited[i][m - 1] = 1;
            }
        }


        int[] rows = new int[]{1, -1, 0, 0};
        int[] cols = new int[]{0, 0, 1, -1};

        while(!q.isEmpty()){
            Pair curr = q.poll();

            int curr_x = curr.x;
            int curr_y = curr.y;

            for(int i = 0; i < 4; i++){
                int n_curr_x = curr_x + rows[i];
                int n_curr_y = curr_y + cols[i];

                if(n_curr_x >= 0 && n_curr_x < n && n_curr_y >= 0 && n_curr_y < m  
                    && grid[n_curr_x][n_curr_y] == 1 && visited[n_curr_x][n_curr_y] == 0){
                        q.add(new Pair(n_curr_x, n_curr_y));
                        visited[n_curr_x][n_curr_y] = 1;
                }
            }
        }
        
        int cnt = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    cnt++;
                }
            }
        }

        return cnt;
    }
}