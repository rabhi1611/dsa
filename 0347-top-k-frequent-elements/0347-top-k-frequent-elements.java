class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i += 1){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for(Map.Entry<Integer, Integer> e : mp.entrySet()){
            pq.offer(new int[]{e.getValue(), e.getKey()});

            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] res = new int[k];

        for(int i = 0; i < k; i += 1){
            res[i] = pq.poll()[1];
        }

        return res;
    }
}