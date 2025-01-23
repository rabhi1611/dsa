class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        List<List<Integer>> arr = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            arr.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int i = 0; i < n; i++){
            arr.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        int cnt = 0;

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) {
                q.add(i);
                cnt++;
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int j = 0; j < arr.get(curr).size(); j++){
                int ncurr = arr.get(curr).get(j);
                indegree[ncurr]--;
                if(indegree[ncurr] == 0){
                    q.add(ncurr);
                    cnt++;
                }               
            }           
        }

        if(cnt == numCourses)    return true;
        return false;
    }
}