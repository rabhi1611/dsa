class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int[][] ans = image;

        Queue<List<Integer>> q = new ArrayDeque<>();
        int[][] visited = new int[n][m];

        q.add(List.of(sr, sc));
    
        while(!q.isEmpty()){
            List<Integer> ls = q.poll();
            int vtx_x = ls.get(0);
            int vtx_y = ls.get(1);
            int pre_color = image[vtx_x][vtx_y];

            ans[vtx_x][vtx_y] = color;
            visited[vtx_x][vtx_y] = 1;


            if(vtx_x - 1 >= 0 && image[vtx_x - 1][vtx_y] == pre_color && visited[vtx_x - 1][vtx_y] == 0){
                q.add(List.of(vtx_x - 1, vtx_y));
            }

            
            if(vtx_x + 1 < n && image[vtx_x + 1][vtx_y] == pre_color && visited[vtx_x + 1][vtx_y] == 0){
                q.add(List.of(vtx_x + 1, vtx_y));
            }


            if(vtx_y - 1 >= 0 && image[vtx_x][vtx_y - 1] == pre_color && visited[vtx_x][vtx_y - 1] == 0){
                q.add(List.of(vtx_x, vtx_y - 1));
            }

            
            if(vtx_y + 1 < m && image[vtx_x][vtx_y + 1] == pre_color && visited[vtx_x][vtx_y + 1] == 0){
                q.add(List.of(vtx_x, vtx_y + 1));
            }
        }


        return ans;
    }
}