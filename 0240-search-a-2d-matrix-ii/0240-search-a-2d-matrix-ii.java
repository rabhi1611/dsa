class Solution {

    private boolean bs(int li, int lj, int ri, int rj, int[][] matrix, int target){

        if(lj > rj){
            return false;
        }

        int mid = lj + (rj - lj) / 2;

        if(matrix[li][mid] == target){
            return true;
        } else if (matrix[li][mid] > target){
            return bs(li, lj, ri, mid - 1, matrix, target);
        } else {
            return bs(li, mid + 1, ri, rj, matrix, target);
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;


        for(int i = 0; i < n; i++){
            if(bs(i, 0, i, m - 1, matrix, target)){
                return true;
            }
        }

        return false;
    }
}