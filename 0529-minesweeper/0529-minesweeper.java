class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int n = board.length;
        int m = board[0].length;

        char[][] ans = board.clone();
        int[][] visited = new int[n][m];

        visited[click[0]][click[1]] = 1;

        helper(click[0], click[1], n, m, board, visited, ans);

        return ans;
    }


    private void helper(int i, int j, int n, int m, char[][] board, int[][] visited, char[][] ans){
        
        if(board[i][j] == 'M'){
            ans[i][j] = 'X';
            return;
        }

        if(board[i][j] != 'E'){
            return;
        }

        // E hai

        //System.out.println(" e hai");

        // cnt adj
        int adjMinesCnt = 0;

        int[] rows = new int[]{1, -1, 0, 0, -1, -1, 1, 1};
        int[] cols = new int[]{0, 0, 1, -1, -1, 1, -1, 1};


        for(int k = 0; k < 8; k += 1){
            int nr = i + rows[k];
            int nc = j + cols[k];
            if(!(nr < 0 || nc < 0 || nr >= n || nc >= m)){
                if(board[nr][nc] == 'M'){
                    adjMinesCnt += 1;
                }
            }
        }

        //System.out.println(adjMinesCnt);

        if(adjMinesCnt != 0){
            ans[i][j] = (char) ('0' + adjMinesCnt);
            return;
        }

        // recursive
        ans[i][j] = 'B';

        for(int k = 0; k < 8; k += 1){
            int nr = i + rows[k];
            int nc = j + cols[k];
            
            if(!(nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc] == 1)){
                visited[nr][nc] = 1;
                helper(nr, nc, n, m, board, visited, ans);
            }
        }

       return;
    }
}