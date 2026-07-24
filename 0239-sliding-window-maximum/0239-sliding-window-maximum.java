class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n + 1 - k];
        Deque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < k; i += 1){
            while(!q.isEmpty() && q.peekLast() < nums[i]){
                q.pollLast();
            }

            q.offerLast(nums[i]);
        }

        ans[0] = q.peekFirst();

        for(int i = k; i < n; i += 1){
            while(!q.isEmpty() && q.peekLast() < nums[i]){
                q.pollLast();
            }

            if(!q.isEmpty() && nums[i - k] == q.peekFirst()){
                q.pollFirst();
            }

            q.offerLast(nums[i]);

            ans[i + 1 - k] = q.peekFirst();
        }

        return ans;
    }
}