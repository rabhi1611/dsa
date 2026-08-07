class Solution {
    public int leastInterval(char[] tasks, int n) {
        int size = tasks.length;

        int[] freq = new int[26];

        for(int i = 0; i < size; i += 1){
            freq[tasks[i] - 'A'] += 1;
        }

        Queue<int[]> pq = new PriorityQueue<>(
            Comparator.comparing((int[] a) -> a[1]).reversed());

        for(int i = 0; i < 26; i += 1){
            if(freq[i] > 0)
                pq.offer(new int[]{i, freq[i]});
        }

        Queue<int[]> q = new ArrayDeque<>();
        int time = 0;

        while(!pq.isEmpty() || !q.isEmpty()){
            time += 1;

            if(!q.isEmpty() && q.peek()[2] == time){
                pq.offer(new int[]{q.peek()[0], q.peek()[1]});
                q.poll();
            }

            if(!pq.isEmpty()){
                int[] curr = pq.poll();
                curr[1] -= 1;
                if(curr[1] > 0){
                    int nextAvailableTime = time + n + 1;
                    q.offer(new int[]{curr[0], curr[1], nextAvailableTime});
                }
            }
        }    

        return time; 
    }
}