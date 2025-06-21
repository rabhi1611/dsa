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

         // print
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.printf("%d ", grid[i][j]);
            }
            System.out.printf("\n");
        }
        

        // find sortest path betwn 2 of them
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    continue;
                }
                
                if(grid[i][j] == 2){
                    continue;
                }

                //System.out.println(visited[i][j]);
                int[][] visited2 = new int[n][n];
                visited2[i][j] = 1;
                // only 1 island to traverse
                int sans = sortestPath(i, j, n, grid, visited2);
                System.out.printf("%d %d %d \n", i, j, sans);
                ans = Math.min(ans, sans);
            }
        }

        return ans - 1;
    }

    private int sortestPath(int i, int j, int n, int[][] grid, int[][] visited){

        if(grid[i][j] == 2){
            return 0;
        }

        int ans = Integer.MAX_VALUE;

        int[] rows = new int[]{1, -1, 0, 0};
        int[] cols = new int[]{0, 0, 1, -1};

        for(int k = 0; k < 4; k += 1){
            int nr = i + rows[k];
            int nc = j + cols[k];

            if(nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] != 1 && visited[nr][nc] == 0){
                visited[nr][nc] = 1;
                ans = Math.min(ans, sortestPath(nr, nc, n, grid, visited));
                visited[nr][nc] = 0;
            }
        }

        if(ans == Integer.MAX_VALUE){
            return ans;
        }

        return 1 + ans;
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