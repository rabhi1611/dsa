class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        helper(new ArrayList<>(), 0, 0, candidates, target, n);
        return ans;
    }

    private void helper(List<Integer> cb, int idx, int sum, int[] candidates, int target, int n){
        if(idx >= n){
            return;
        }

        if(sum > target){
            return;
        }

        if(sum == target){
            ans.add(new ArrayList<>(cb));
            return;
        }


        for(int i = idx; i < n; i++){
            cb.add(candidates[i]);
            helper(cb, i, sum + candidates[i], candidates, target, n);
            cb.remove(cb.size() - 1);
        }

        return;
    }
}