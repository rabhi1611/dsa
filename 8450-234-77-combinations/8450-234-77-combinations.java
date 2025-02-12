class Solution {

    private void helper(int n, int k, List<Integer> t, List<List<Integer>> ans, int curr){
        if(t.size() == k){
            ans.add(new ArrayList<>(t));
            return;
        }

        for(int i = curr + 1; i <= n; i++){
            t.add(i);
            helper(n, k, t, ans, i);
            t.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            List<Integer> t = new ArrayList<>();
            t.add(i);
            helper(n, k, t, ans, i);
        }
        return ans;
    }
}