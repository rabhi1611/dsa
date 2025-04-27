class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        for(int num: nums){
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        int[] ans = new int[k];

        /*AtomicInteger i = new AtomicInteger();
        mp.entrySet().stream().sorted(Map.Entry.<Integer, Integer> comparingByValue().reversed()).forEach(el -> {
            if(i.get() < k){
                ans[i.get()] = el.getKey();
                i.set(i.get() + 1);
            }
        });*/


        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.getValue(), a.getValue())
        );

        for(Map.Entry<Integer, Integer> e : mp.entrySet()){
            pq.offer(e);
        }

        for(int i = 0; i < k; i++){
            ans[i] = pq.poll().getKey();
        }

        return ans;
    }
}