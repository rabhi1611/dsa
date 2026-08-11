class Solution {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n; i += 1){
            List<Integer> bucket = new ArrayList<>();
            int[] visited = new int[n];

            bucket.add(nums[i]);
            visited[i] = 1;
            compute(i, n - 1, nums, bucket, visited);
        }

        return ans;
    }

    private void compute(int start, int end, int[] nums
        , List<Integer> bucket, int[] visited){

        if(bucket.size() == nums.length){
            ans.add(new ArrayList<>(bucket));
            return;
        }

        for(int i = 0; i < nums.length; i += 1){
            if(visited[i] == 0){
                // take
                bucket.add(nums[i]);
                visited[i] = 1;
                compute(i + 1, end, nums, bucket, visited);
                bucket.removeLast();
                visited[i] = 0; 
            }
        }
    }
}