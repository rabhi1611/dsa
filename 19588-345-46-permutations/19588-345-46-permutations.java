class Solution {

    private void helper(int[] nums, List<List<Integer>> ans, List<Integer> temp){
        
        if(temp.size() == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(temp.contains(nums[i]))  continue;
            temp.add(nums[i]);
            helper(nums, ans, temp);
            temp.remove(temp.size() - 1);
        }

        return;
    }

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;

        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, ans, new ArrayList<>());

        return ans;
    }
}