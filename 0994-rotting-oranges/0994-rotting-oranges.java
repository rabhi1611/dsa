class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        int[][] visited = new int[m][n];

        for(int i = 0; i < m; i += 1){
            for(int j = 0; j < n; j += 1){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                    visited[i][j] = 1;
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        int mins = 0;

        while(!q.isEmpty()){
            int size = q.size();

            while(size > 0){
                int[] curr = q.poll();

                int ci = curr[0];
                int cj = curr[1];

                //System.out.printf("%d %d \n", ci, cj);

                int[] rows = new int[]{1, 0, -1, 0};
                int[] cols = new int[]{0, 1, 0, -1};

                for(int k = 0; k < 4; k += 1){
                    int ni = ci + rows[k];
                    int nj = cj + cols[k];

                    if(ni < 0 || nj < 0 || ni >= m || nj >= n || grid[ni][nj] == 0 || visited[ni][nj] == 1){
                        continue;
                    }

                    grid[ni][nj] = 2;
                    q.offer(new int[]{ni, nj});
                    visited[ni][nj] = 1;
                }

                size -= 1;
            }
            //System.out.println("\n");
            mins += 1;
        }

        for(int i = 0; i < m; i += 1){
            for(int j = 0; j < n; j += 1){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return mins == 0 ? mins : mins - 1;
    }
}