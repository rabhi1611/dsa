class Solution {

    private List<List<Integer>> ls = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);

        findCombinations(0, n - 1, candidates, target, new ArrayList<>());
        return ls;
    }

    private void findCombinations(int start, int end, int[] candidates,
     int target, List<Integer> bucket){
        
        if(target < 0){
            return;
        }

        if(target == 0){
            // we have the combination
            ls.add(new ArrayList<>(bucket));
            return;
        }

        if(start > end){
            return;
        }

        // take
        bucket.add(candidates[start]);
        findCombinations(start + 1, end, candidates, target - candidates[start], bucket);
        bucket.removeLast();

        int nextStart = start + 1;
        while(nextStart <= end && candidates[nextStart] == candidates[start]){
            nextStart += 1;
        }

        // not take
        findCombinations(nextStart, end, candidates, target, bucket);

        return;
    }
}