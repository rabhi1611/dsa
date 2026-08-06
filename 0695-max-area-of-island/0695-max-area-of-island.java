class Solution {

    private int ans = Integer.MIN_VALUE;
    private int cnt = 1;

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        
        for(int i = 0; i < n; i += 1){
            for(int j = 0; j < m; j += 1){
                if(grid[i][j] == 0){
                    continue;
                }

                if(visited[i][j] == 1){
                    continue;
                }

                visited[i][j] = 1;
                helper(i, j, n, m, grid, visited);
                cnt = 1;
                //System.out.println(" \n ");
            }
        }

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }

    private void helper(int ci, int cj, int n, int m,
        int[][] grid, int[][] visited){

        //System.out.printf("%d %d \n", ci, cj);

        int[] rows = new int[]{1, 0, -1, 0};
        int[] cols = new int[]{0, 1, 0, -1};

        for(int k = 0; k < 4; k += 1){
            int ni = ci + rows[k];
            int nj = cj + cols[k];

            if(ni < 0 || nj < 0 || ni >= n || nj >= m
                || grid[ni][nj] == 0 || visited[ni][nj] == 1){
                continue;
            }

            visited[ni][nj] = 1;
            cnt += 1;
            helper(ni, nj, n, m, grid, visited); 
            //visited[ni][nj] = 0;
        }

        ans = Math.max(ans, cnt);

        return;
    }
}