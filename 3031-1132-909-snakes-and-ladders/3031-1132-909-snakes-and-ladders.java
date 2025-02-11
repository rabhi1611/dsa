class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int steps = 0;
        int[][] visited = new int[n][n];

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[n - 1][0] = 1;

        while(!q.isEmpty()){
            int limit = q.size();

            while(limit > 0){
                int curr = q.poll();

                if(curr == (n * n)){
                    return steps;
                }

                for(int i = 1; i <= 6; i++){
                    int ncurr = curr + i;

                    if(ncurr > (n * n)){
                        break;
                    }

                    int[] cord = findCord(ncurr, n); 

                    int nx = cord[0];
                    int ny = cord[1];

                    if(visited[nx][ny] == 0){
                        if(board[nx][ny] == -1){
                            q.add(ncurr);
                        } else {
                            q.add(board[nx][ny]);
                        }
                        visited[nx][ny] = 1;
                    }
                }
                limit--;
            }
            steps++;
        }

        return -1;
    }

    private int[] findCord(int ncurr, int n){
            int r = n - (ncurr - 1) / n - 1;
            int c = (ncurr - 1) % n;

            if(r % 2 == n % 2){
                return new int[]{r, n - 1 - c};
            } else {
                return new int[]{r, c};
            }
    }
}