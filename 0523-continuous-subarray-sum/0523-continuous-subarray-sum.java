class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);

        int sum = 0;
        for(int i = 0; i < n; i += 1){
            sum += nums[i];
            int remainder = sum % k;

            if(mp.containsKey(remainder) && (i - mp.get(remainder)) > 1){
                return true;
            }
            
            if(!mp.containsKey(remainder))
                mp.put(remainder, i);
        }

        return false;
    }
}