class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length, cols = board[0].length;
        int [][] tBoard = new int [rows][cols];

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                int liveNeighbors = neighbor(board, r-1, c-1) + neighbor(board, r-1, c)
                + neighbor(board, r-1, c+1) + neighbor(board, r, c+1) 
                + neighbor(board, r+1, c+1) + neighbor(board, r+1, c)
                + neighbor(board, r+1, c-1) + neighbor(board, r, c-1);

                if(board[r][c] == 1){
                    tBoard[r][c] = (liveNeighbors < 2 || liveNeighbors > 3) ? 0 : 1;
                } else {   
                    tBoard[r][c] = (liveNeighbors == 3) ? 1 : 0;
                }       
            }
        }

        for(int r = 0; r < rows; r++){
            board[r] = tBoard[r].clone();
        }
    }

    public int neighbor(int[][] board, int r, int c){
        if( r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == 0 ){ 
            return 0; 
        }                         
        return 1;
    }
}