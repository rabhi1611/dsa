class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(helper(i, j, n, m, board, 0, word, visited)){
                    return true;
                }
            }
        }
        return false;
    }


    private boolean helper(int i, int j, int n, int m, char[][] board, int p, String word, boolean[][] visited){
        
        if(p == word.length() - 1){
            if(word.charAt(p) != board[i][j]){
                return false;
            }
            return true;
        }

        if(word.charAt(p) != board[i][j]){
            return false;
        }

        visited[i][j] = true;

        int[] a = new int[]{-1, 1, 0, 0};
        int[] b = new int[]{0, 0, 1, -1};

        for(int k = 0; k < 4; k++){
                int ni = i + a[k];
                int nj = j + b[k];
                if(!(ni < 0 || ni >= n || nj < 0 || nj >= m) && !visited[ni][nj]){
                    boolean tres = helper(ni, nj, n, m, board, p + 1, word, visited);
                    if(tres)    return true;
                }
        }

        visited[i][j] = false;
        return false;
    }
}