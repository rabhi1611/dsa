class NumMatrix {
    final int[][] matrix;
    final int[][] preSumRows;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;

        int n = matrix.length, m = matrix[0].length;
        int[][] preSumRows = new int[n][m];

        for(int i = 0; i < n; i++){
            int psum = 0;
            for(int j = 0; j < m; j++){
                psum += matrix[i][j];
                preSumRows[i][j] = psum;
            }
        }

        this.preSumRows = preSumRows;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;

        for(int i = row1; i <= row2; i++){
            if(col1 == 0){
                ans += preSumRows[i][col2];
            } else {
                ans += (preSumRows[i][col2] - preSumRows[i][col1 - 1]);
            }
        }

        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */