class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;

        int[] visited = new int[n];
        Arrays.fill(visited, 0);

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return helper(start, n, arr, dp, visited) == 0 ? false : true;
    }

    private int helper(int i, int n, int[] arr, int[] dp, int[] visited){
        //System.out.println(i);
        if(i < 0 || i >= n){
            return 0;
        }

        if(arr[i] == 0){
            return 1;
        }

         if(visited[i] != 0){
            return 0;           
        }

        visited[i] = 1;

        if(dp[i] != -1){
            return dp[i];
        }

        int s1 = helper(i + arr[i], n, arr, dp, visited);
        int s2 = helper(i - arr[i], n, arr, dp, visited);


        if(s1 == 1 || s2 == 1){
            return dp[i] = 1;
        }

        return dp[i] = 0;
    }
}