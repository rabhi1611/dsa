class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        for(int num: nums){
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        int[] ans = new int[k];

        AtomicInteger i = new AtomicInteger();
        mp.entrySet().stream().sorted(Map.Entry.<Integer, Integer> comparingByValue().reversed()).forEach(el -> {
            int cnt = i.get(); 
            if(cnt < k){
                ans[cnt] = el.getKey();
                i.set(cnt + 1);
            }
        });

        return ans;
    }
}