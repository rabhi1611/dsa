class Solution {
    private List<List<Integer>> adjList = new ArrayList<>();
    private boolean[] visited;
    private Map<Integer, Integer> bobPath;
    private int maxIncome = Integer.MIN_VALUE;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        visited = new boolean[n];
        bobPath = new HashMap<>();

        // building the tree using adjacency list
        for(int i = 0; i < n; i++){
            adjList.add(new LinkedList<>());
        }

        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        // record bob arrival time at each node
        findBobPath(bob, 0);

        // reset visited array for alice's DFS
        Arrays.fill(visited, false);

        // let alice begin her treasure hunt!
        findAlicePath(0, 0, 0, amount);

        return maxIncome;
    }

    private boolean findBobPath(int node, int time){
        bobPath.put(node, time);
        visited[node] = true;

        if(node == 0) return true;

        for(int neighbor: adjList.get(node)){
            if(!visited[neighbor] && findBobPath(neighbor, time + 1)){
                return true;
            }
        }

        bobPath.remove(node);
        return false;
    }

    private void findAlicePath(int node, int time, int income, int[] amount){
        visited[node] = true;

        if(!bobPath.containsKey(node) || time < bobPath.get(node)){
            income += amount[node];
        } else if(time == bobPath.get(node)){
            income += amount[node] / 2;
        }

        boolean isLeaf = true;

        for(int neighbor: adjList.get(node)){
            if(!visited[neighbor]){
                isLeaf = false;
                findAlicePath(neighbor, time + 1, income, amount);
            }
        }

        if(isLeaf){
            maxIncome = Math.max(maxIncome, income);
        }
    }
}