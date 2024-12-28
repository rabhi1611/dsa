class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
     
        int[] ans = new int[2];
        Map<Integer, Integer> mp = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            
            if(mp.containsKey(target - nums[i])){
                int t = mp.get(target - nums[i]);
                ans[0] = t;
                ans[1] = i;
            }
            
            if(!mp.containsKey(nums[i])){
                mp.put(nums[i], i);
            }
        }
        
        return ans;
    }
}