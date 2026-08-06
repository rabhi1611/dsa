class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        int pColor = image[sr][sc];
        image[sr][sc] = color;
        helper(sr, sc, m - 1, n - 1, image, color, pColor);

        return image;
    }

    private void helper(
        int ci, int cj, int ei, int ej, int[][] image, int color, int pColor){
        
            int[] rows = new int[]{1, 0, -1, 0};
            int[] cols = new int[]{0, -1, 0, 1};

            for(int k = 0; k < 4; k += 1){
                int ni = ci + rows[k];
                int nj = cj + cols[k];

                if(ni < 0 || nj < 0 || ni > ei || nj > ej
                     || image[ni][nj] != pColor || image[ni][nj] == color){
                        continue;
                }

                pColor = image[ni][nj];
                image[ni][nj] = color;
                helper(ni, nj, ei, ej, image, color, pColor);
            }
    }
}