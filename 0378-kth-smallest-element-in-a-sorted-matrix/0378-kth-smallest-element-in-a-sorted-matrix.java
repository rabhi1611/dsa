class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < matrix.length; i += 1){
            for(int j = 0; j < matrix[i].length; j += 1){
                pq.offer(matrix[i][j]);

                if(pq.size() > k){
                    pq.poll();
                }
            }
        }

        return pq.peek();
    }
}