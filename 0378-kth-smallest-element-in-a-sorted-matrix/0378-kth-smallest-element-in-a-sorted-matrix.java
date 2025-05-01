class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        int low = matrix[0][0], high = matrix[n - 1][m - 1];

        while(low < high){
            int mid = low + (high - low) / 2;
            int pos = countHelper(matrix, mid, n, m);

            if(pos < k){
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int countHelper(int[][] matrix, int mid, int n, int m){
        int cnt = 0, i = 0;

        while(i < n){
            int j = m - 1;
            while(j >= 0 && matrix[i][j] > mid){
                j -= 1;
            }
            cnt += (j + 1);
            i += 1;
        }       

        return cnt;
    }
}