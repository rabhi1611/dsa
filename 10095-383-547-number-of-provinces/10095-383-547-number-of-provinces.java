class Solution {
    public int findCircleNum(int[][] isConnected) {
        int np = 0;
        int n = isConnected.length;

        int[] visited = new int[201];

        for(int i = 0; i < n; i++){
            if(visited[i] != 0) continue;

            Stack<Integer> q = new Stack<>();
            q.add(i);
            visited[i] = 1;

            while(!q.isEmpty()){
                int vtx = q.pop();

                for(int j = 0; j < isConnected[vtx].length; j++){
                    if(isConnected[vtx][j] == 1 && visited[j] == 0){
                        q.add(j);
                        visited[j] = 1;
                    }
                }
            }


            np++;
        }

        return np;
    }
}