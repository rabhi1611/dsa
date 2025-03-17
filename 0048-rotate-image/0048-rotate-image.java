class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] ans = new int[n][m];

        for(int i = 0; i < n; i++){
            Arrays.fill(ans[i], -1);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans[j][i] = matrix[i][j];
            }
        }

        int temp;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < (m / 2); j++){
                temp = ans[i][j];
                ans[i][j] = ans[i][m - 1 - j];
                ans[i][m - 1 - j] = temp;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                matrix[i][j] = ans[i][j];
            }
        }
    }
}