class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i += 1){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue().compareTo(b.getValue()));

        int i = 0;
        Iterator<Map.Entry<Integer, Integer>> it = mp.entrySet().iterator();

        while(i < k){
            pq.offer(it.next());
            i += 1;
        }

        while(it.hasNext()){
            Map.Entry<Integer, Integer> e = it.next();

            if(e.getValue() > pq.peek().getValue()){
                pq.poll();
                pq.offer(e);
            }
        }

        return pq.stream().map(e -> e.getKey()).mapToInt(j -> j).toArray();
    }
}