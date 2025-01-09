class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;

        int[][] visited = new int[n][m];
        int[][] dis = new int[n][m];
        
        Queue<List<Integer>> q = new ArrayDeque<>();

        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(mat[row][col] == 0){
                    q.add(List.of(row, col, 0));
                    visited[row][col] = 1;
                }
            }
        }


        while(!q.isEmpty()){
            List<Integer> ls = q.poll();
            
            int row = ls.get(0);
            int col = ls.get(1);
            int steps = ls.get(2);

            dis[row][col] = steps;

            int[] rows = new int[]{-1, 0, 1 , 0};
            int[] cols = new int[]{0, -1, 0, 1};

            for(int i = 0; i < 4; i++){
                int nrow = row + rows[i];
                int ncol = col + cols[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0){
                    q.add(List.of(nrow, ncol, steps + 1));
                    visited[nrow][ncol] = 1;
                }
            }
        }

        return dis;       
    }
}