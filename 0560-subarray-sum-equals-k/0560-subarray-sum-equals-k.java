class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;

        Map<Integer, Integer> mp = new HashMap<>();       
        int sum = 0;
        mp.put(sum, 1);
        int[] preSum = new int[n];

        int i = 0;
        while(i < n){
            sum += nums[i];

            if(mp.containsKey(sum - k)){
                cnt += mp.get(sum - k);
            }

            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
            
            i += 1;
        }

        return cnt;
    }
}