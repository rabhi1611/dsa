class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int max = 0;
    
        Map<Integer, Integer> mp = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            mp.put(nums[i], 1);
        }
        
        
        int i = 0;
        while(i < n){
            if(!mp.containsKey(nums[i])){
                i++;
                continue;
            }
            
            // if it is head
            if(!mp.containsKey(nums[i] - 1)){
                mp.remove(nums[i]);
                int cnt = 1;

                while(mp.containsKey(nums[i] + cnt)){
                    mp.remove(nums[i] + cnt);
                    cnt++;
                }

                max = Math.max(max, cnt);
                i++;
            } else{
                i++;
            }
        }
        
        return max;
    }
}