class Solution {
    
    private List<List<Integer>> ls = new ArrayList<>(); 

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<Integer> bucket = new ArrayList<>();
        helper(-1, n - 1, bucket, nums);
        return ls;
    }

    private void helper(int curr, int end, List<Integer> bucket, int[] nums){
        if(curr > end){
            return;
        }

        ls.add(new ArrayList<>(bucket));

        for(int i = curr + 1; i <= end; i += 1){
            bucket.add(nums[i]);
            helper(i, end, bucket, nums);
            bucket.removeLast();
        }

        return;
    }
}