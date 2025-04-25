class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;

        helper(0, n, nums, new LinkedHashMap<>());
        return ans.stream().distinct().toList();        
    }

    private void helper(int idx, int n, int[] nums, Map<Integer, Integer> bkt){
        if(idx == n){
            List<Integer> sans = bkt.entrySet().stream().map(val -> nums[val.getKey()]).toList(); 
            ans.add(sans);
            return;
        }

        for(int i = 0; i < n; i++){
            if(bkt.containsKey(i)){
               continue; 
            }

            bkt.put(i, 1);
            helper(idx + 1, n, nums, bkt);
            bkt.remove(i);
        }

        return;
    }
}