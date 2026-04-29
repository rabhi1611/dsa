class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;

        List<List<Integer>> ls = new ArrayList<>();

        if(n == 0 || m == 0 || k == 0){
            return ls; 
        }


        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for(int j = 0; j < Math.min(m, k); j += 1){
            pq.offer(new int[]{nums2[j] + nums1[0], 0, j});
        }


        while(k > 0 && !pq.isEmpty()){
            int[] curr = pq.poll();

            int sum = curr[0];
            int i = curr[1];
            int j = curr[2];

            ls.add(List.of(nums1[i], nums2[j]));

            if(i + 1 < n){
                pq.offer(new int[]{nums1[i + 1] + nums2[j], i  + 1, j});
            }

            k -= 1;
        }

        
        return ls;
    }
}