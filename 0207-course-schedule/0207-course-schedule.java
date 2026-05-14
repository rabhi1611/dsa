class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;

        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i += 1){
            adj.add(new ArrayList());
        }

        for(int i = 0; i < n; i += 1){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // adj is ready
        // DFS
        /*
        for(int i = 0; i < numCourses; i += 1){
                if(dfs(i, adj, visited) == false) return false;
        }
        */


        // BFS
        int[] inDegree = new int[numCourses];
        int cnt = 0;

        for(List<Integer> node: adj){
            for(int neigh: node){
                inDegree[neigh] += 1;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i += 1){
            if(inDegree[i] == 0){
                q.offer(i);
                cnt += 1;
            }
        }


        while(!q.isEmpty()){
            int curr = q.poll();

            for(int neigh: adj.get(curr)){
                inDegree[neigh] -= 1;

                if(inDegree[neigh] == 0){
                    q.offer(neigh);
                    cnt += 1;
                }
            }
        }

    
        return cnt == numCourses ? true : false;
    }

    // DFS
    /*
    private boolean dfs(int course, List<List<Integer>> adj, boolean[] visited){
        if(visited[course]) return false;
        visited[course] = true;

        for(int i = 0; i < adj.get(course).size(); i += 1){
            if(dfs(adj.get(course).get(i), adj, visited) == false) return false;
        }

        visited[course] = false;
        return true;
    } 
    */  
}