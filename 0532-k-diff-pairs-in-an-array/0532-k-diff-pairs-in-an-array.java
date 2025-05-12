class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        int ans = 0;
    
        for(int i: mp.keySet()){
            if(k > 0 && mp.containsKey(i + k) || k == 0 && mp.get(i) > 1){
                ans += 1;
            }
        }

        return ans;
    }
}