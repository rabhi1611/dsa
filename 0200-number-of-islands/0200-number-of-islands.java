class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] visited = new int[m][n];

        for(int i = 0; i < m; i += 1){
            Arrays.fill(visited[i], 0);
        }

        int cnt = 0;

        for(int i = 0; i < m; i += 1){
            for(int j = 0; j < n; j += 1){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    cnt += 1;
                    visited[i][j] = 1;
                    Queue<int[]> q = new ArrayDeque<>();
                    q.offer(new int[]{i, j});
                
                    while(!q.isEmpty()){
                        int[] curr = q.poll();

                        int ci = curr[0];
                        int cj = curr[1];

                        int[] rows = new int[]{0, 1, 0, -1};
                        int[] cols = new int[]{1, 0, -1, 0};

                        for(int k = 0; k < 4; k += 1){
                            int ni = ci + rows[k];
                            int nj = cj + cols[k];

                            if(ni < 0 || nj < 0 || ni >= m || nj >= n
                                    || grid[ni][nj] == '0' || visited[ni][nj] == 1){
                                continue;
                            }

                            visited[ni][nj] = 1;
                            q.offer(new int[]{ni, nj});
                        }
                    }          
                }
            }
        }
        
        return cnt;
    }
}