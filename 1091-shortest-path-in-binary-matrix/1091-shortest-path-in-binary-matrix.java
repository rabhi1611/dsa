class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        int [][] dp = new int[n][n];
        
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        int[][] visited = new int[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(visited[i], 0);
        }

        int ans = helper(0, 0, n, n, grid, visited, dp); 
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }


    private int helper(int i, int j, int n, int m, int[][] grid, int[][] visited, int[][] dp){

        if(dp[i][j] != -1){
            return dp[i][j];
        }

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

           // System.out.printf("%d %d \n ", ni, nj);
            
            if(!(ni < 0 || nj < 0 || ni >= n || nj >= m) && (visited[ni][nj] == 0)){
                visited[ni][nj] = 1;
                ans = Math.min(ans, helper(ni, nj, n, m, grid, visited, dp));
                visited[ni][nj] = 0;
            }
        }

        if(ans == Integer.MAX_VALUE){
            return dp[i][j] = ans;
        }

        return dp[i][j] = 1 + ans;
    }
}