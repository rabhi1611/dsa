class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        
        int n = graph.length;
        List<List<Integer>> reverseGraph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            reverseGraph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < graph[i].length; j++){
                reverseGraph.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
    
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
    
        while(!q.isEmpty()){
            int curr = q.poll();
            ans.add(curr);

            for(int j = 0; j < reverseGraph.get(curr).size(); j++){
                int ncurr = reverseGraph.get(curr).get(j);

                indegree[ncurr]--;
                if(indegree[ncurr] == 0)    q.add(ncurr);
            }
        }

        Collections.sort(ans);
        return ans;
    }
}