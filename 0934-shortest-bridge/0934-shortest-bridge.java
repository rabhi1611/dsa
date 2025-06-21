class Solution {
    public int shortestBridge(int[][] grid) {
        int ans = Integer.MAX_VALUE;
        
        int n = grid.length;
        int[][] visited = new int[n][n];
        // identify both islands
        int islandNum = 1;

        for(int i = 0; i < n; i += 1){
            for(int j = 0; j < n; j += 1){
                if(grid[i][j] == 0){
                    continue;
                }

                if(visited[i][j] != 0){
                    continue;
                }
                
                // visit island
                visited[i][j] = islandNum;
                visit(i, j, n, grid, visited, islandNum);
                islandNum += 1;
            }
        }

        // put visited in grid and reset visite
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = visited[i][j];
            }
        }

        /* // print
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.printf("%d ", grid[i][j]);
            }
            System.out.printf("\n");
        }*/
        

        // find sortest path betwn 2 of them
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    continue;
                }
                
                if(grid[i][j] == 2){
                    continue;
                }
                // only 1 island to traverse
                int sans = sortestPath(i, j, n, grid);
                //System.out.printf("%d %d %d \n", i, j, sans);
                ans = Math.min(ans, sans);
            }
        }

        return ans;
    }

    private int sortestPath(int i, int j, int n, int[][] grid){

        int[][] visited = new int[n][n];
        Queue<List<Integer>> q = new ArrayDeque<>();

        q.add(List.of(i, j, 0));
        visited[i][j] = 1;

        int[] rows = new int[]{1, -1, 0, 0};
        int[] cols = new int[]{0, 0, 1, -1};


        while(!q.isEmpty()){
            List<Integer> ls = q.poll();

            int ci = ls.get(0);
            int cj = ls.get(1);
            int cs = ls.get(2);

            for(int k = 0; k < 4; k++){
                int ni = ci + rows[k];
                int nj = cj + cols[k];

                if(ni >= 0 && nj >= 0 && ni < n && nj < n && visited[ni][nj] == 0){
                    if(grid[ni][nj] == 2){
                        return cs;
                    }

                    visited[ni][nj] = 1;
                    q.add(List.of(ni, nj, cs + 1));
                }
            }
        }

        return -1;
    }

    private void visit(int i, int j, int n, int[][] grid, int[][] visited, int islandNum){

        int[] rows = new int[]{1, -1, 0, 0};
        int[] cols = new int[]{0, 0, 1, -1};

        for(int k = 0; k < 4; k += 1){
            int nr = i + rows[k];
            int nc = j + cols[k];

            if(nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 1 && visited[nr][nc] == 0){
                visited[nr][nc] = islandNum;
                visit(nr, nc, n, grid, visited, islandNum);
            }
        }
    }
}