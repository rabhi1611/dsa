class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        for(int num: nums){
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        int[] ans = new int[k];

        AtomicInteger i = new AtomicInteger();
        mp.entrySet().stream().sorted(Map.Entry.<Integer, Integer> comparingByValue().reversed()).forEach(el -> {
            if(i.get() < k){
                ans[i.get()] = el.getKey();
                i.set(i.get() + 1);
            }
        });

        return ans;
    }
}