class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] visited = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int tans = helper(i, j, n, m, heights, -1, visited);
                if(tans == 3){
                    ans.add(List.of(i, j));
                }
            }
        }
        
        
        return ans;
    }

    // pacific = 1
    // atlanta = 2
    // both = 3
    // none of them = -1

    private int helper(int i, int j, int n, int m, int[][] heights, int prevHeight, int[][] visited){

        if(i < 0 || j < 0){
            return 1;
        }

        if(i >= n || j >= m){
            return 2;
        }

        if(prevHeight != -1 && heights[i][j] > prevHeight){
            return -1;
        }

        if(visited[i][j] == 1){
            return -1;
        }

        visited[i][j] = 1;

        List<Integer> rec = new ArrayList<>();

        rec.add(helper(i, j - 1, n, m, heights, heights[i][j], visited));
    
        rec.add(helper(i, j + 1, n, m, heights, heights[i][j], visited));
    
        rec.add(helper(i - 1, j, n, m, heights, heights[i][j], visited));
    
        rec.add(helper(i + 1, j, n, m, heights, heights[i][j], visited));

        visited[i][j] = 0;

        if(rec.contains(3)){
            return 3;
        }
    
        if(rec.contains(1) && rec.contains(2)){
            return 3;
        }

        if(rec.contains(1)){
            return 1;
        }

        if(rec.contains(2)){
            return 2;
        }

        return -1;       
    }
}