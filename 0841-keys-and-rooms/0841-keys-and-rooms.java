class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        int[] visited = new int[n];

        dfs(rooms, visited, 0);

        return allOne(visited) ? true : false;
    }

    private void dfs(List<List<Integer>> rooms, int[] visited, int cr){
        visited[cr] = 1;

        for(int j = 0; j < rooms.get(cr).size(); j++){
            int nr = rooms.get(cr).get(j);
            if(visited[nr] == 0){
                dfs(rooms, visited, nr);
            }
        }
    }

    private boolean allOne(int[] visited){
        for(int rm: visited){
            if(rm == 0){
                return false;
            }
        }

        return true;
    }
}