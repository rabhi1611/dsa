class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
        
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        helper(0, candidates, target, new ArrayList<>());
        return ans;
    }

    private void helper(int idx, int[] candidates, int target, List<Integer> ds){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = idx; i < candidates.length; i++){
            if(i > idx && candidates[i - 1] == candidates[i]){
                continue;
            }

            if(candidates[i] > target){
                break;
            }

            ds.add(candidates[i]);
            helper(i + 1, candidates, target - candidates[i], ds);
            ds.remove(ds.size() - 1);
        }

        return;
    } 
}