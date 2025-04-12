class Pair {
    int x;
    int y;
    int moves;

    Pair(int x, int y, int moves){
        this.x = x;
        this.y = y;
        this.moves = moves;
    }
}


class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        int[][] visited = new int[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(visited[i], 0);
        }

        int ans = helper(0, 0, n, n, grid, visited); 
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }


    private int helper(int i, int j, int n, int m, int[][] grid, int[][] visited){
        /*
        DFS 
        -----

        if(grid[i][j] != 0){
            return Integer.MAX_VALUE;
        }

        if(i == n - 1 && j == m - 1){
            return 1;
        }

        int[] rows = new int[]{0, 1, 0, -1, -1, -1, 1, 1};
        int[] cols = new int[]{1, 0, -1, 0, 1, -1, 1, -1};


        int ans = Integer.MAX_VALUE;

        for(int k = 0; k < 8; k++){
            int ni = i + rows[k];
            int nj = j + cols[k];
            
            if(!(ni < 0 || nj < 0 || ni >= n || nj >= m) && (visited[ni][nj] == 0)){
                visited[ni][nj] = 1;
                ans = Math.min(ans, helper(ni, nj, n, m, grid, visited));
                visited[ni][nj] = 0;
            }
        }

        if(ans == Integer.MAX_VALUE){
            return ans;
        }

        return 1 + ans;

        -----
        */

        if(grid[i][j] == 1){
            return -1;
        }

        int ans = Integer.MAX_VALUE;

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(i, j, 1));
        visited[i][j] = 1;

        while(!q.isEmpty()){
            Pair p = q.poll();

            int x = p.x;
            int y = p.y;
            int moves = p.moves;

            if(x == n - 1 && y == m -1)
                ans = Math.min(ans, moves);

            int[] rows = new int[]{0, 1, 0, -1, -1, -1, 1, 1};
            int[] cols = new int[]{1, 0, -1, 0, 1, -1, 1, -1};

            for(int k = 0; k < 8; k++){
                int nx = x + rows[k];
                int ny = y + cols[k];
                
                if(!(nx < 0 || ny < 0 || nx >= n || ny >= m) && (visited[nx][ny] == 0) && grid[nx][ny] == 0){
                    visited[nx][ny] = 1;
                    q.add(new Pair(nx, ny, moves + 1));
                    //visited[ni][nj] = 0;
                }
            }
        }


        return ans;
    }
}