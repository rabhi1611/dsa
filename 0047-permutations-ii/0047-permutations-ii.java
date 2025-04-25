class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        int[] check = new int[n];
        Arrays.sort(nums);
        helper(0, n, nums, new ArrayList<>(), check);
        return ans;        
    }

    private void helper(int idx, int n, int[] nums, List<Integer> bkt, int[] check){
        if(idx == n){
            ans.add(new ArrayList(bkt));
            return;
        }

        for(int i = 0; i < n; i++){
            if(check[i] == 1){
               continue; 
            }

            if(i > 0 && nums[i - 1] == nums[i] && check[i - 1] == 0){
                continue;
            }

            check[i] = 1;
            bkt.add(nums[i]);
            helper(idx + 1, n, nums, bkt, check);
            check[i] = 0;
            bkt.remove(bkt.size() - 1);
        }

        return;
    }
}