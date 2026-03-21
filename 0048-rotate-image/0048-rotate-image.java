class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < n; i += 1){
            for(int j = i + 1; j < m; j += 1){
                // swap
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse
        for(int i = 0; i < n; i += 1){
            int left = 0, right = m - 1;

            while(left < right){
                // swap
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left += 1;
                right -= 1;
            }
        }

    }
}