class Solution {
    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        helper(0, n, nums, new ArrayList<>());
        return ans;
    }

    private void helper(int i, int n, int[] nums, List<Integer> bucket){
        if(i == n){
            ans.add(new ArrayList<>(bucket));
            return;
        }

        // take
        bucket.add(nums[i]);
        helper(i + 1, n, nums, bucket);
        bucket.remove(bucket.size() - 1);
        
        // not take
        helper(i + 1, n, nums, bucket);

        return;
    }
}