class Solution {
    public int numIslands(char[][] grid) {
        int ni = 0;
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[301][301];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(grid[i][j] == '0')   continue;
                if(visited[i][j] != 0)   continue;

                Queue<List<Integer>> q = new ArrayDeque<>();

                q.add(List.of(i, j));
                visited[i][j] = 1;

                while(!q.isEmpty()){
                    List<Integer> ls = q.poll();
                    int grid_x = ls.get(0);
                    int grid_y = ls.get(1);

                    if(grid_x - 1 >= 0 && grid[grid_x - 1][grid_y] == '1' && visited[grid_x - 1][grid_y] == 0){
                        q.add(List.of(grid_x - 1, grid_y));
                        visited[grid_x - 1][grid_y] = 1;
                    }

                    if(grid_y - 1 >= 0 && grid[grid_x][grid_y - 1] == '1' && visited[grid_x][grid_y - 1] == 0){
                        q.add(List.of(grid_x, grid_y - 1));
                        visited[grid_x][grid_y - 1] = 1;
                    }

                    if(grid_x + 1 < n && grid[grid_x + 1][grid_y] == '1' && visited[grid_x + 1][grid_y] == 0){
                        q.add(List.of(grid_x + 1, grid_y));
                        visited[grid_x + 1][grid_y] = 1;
                    }

                    if(grid_y + 1 < m && grid[grid_x][grid_y + 1] == '1' && visited[grid_x][grid_y + 1] == 0){
                        q.add(List.of(grid_x, grid_y + 1));
                        visited[grid_x][grid_y + 1] = 1;
                    }
                }


                ni++;
            }
        }

        return ni;
    }
}