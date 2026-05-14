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
        int[] visited = new int[numCourses];
        int[] path = new int[numCourses];
        for(int i = 0; i < numCourses; i += 1){
                if(cycleDetect(i, adj, visited, path)) return false;
        }
        
        return true;

        // BFS
        /*
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
        */
    }

    // DFS
    private boolean cycleDetect(int course, List<List<Integer>> adj, int[] visited, int[] path){
        visited[course] = 1;
        path[course] = 1;

        for(int neigh: adj.get(course)){
            if(path[neigh] == 1)    return true;
            if(visited[neigh] == 0 && cycleDetect(neigh, adj, visited, path)) return true;
        }

        path[course] = 0;
        return false;
    }      
}