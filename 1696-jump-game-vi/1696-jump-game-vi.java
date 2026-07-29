class Solution {
    private int[] dp;

    public int maxResult(int[] nums, int k) {
        dp = new int[nums.length];
        dp[0] = nums[0];

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(0);

        for (int i = 1; i < nums.length; i++) {
            // Best score to reach i
            dp[i] = nums[i] + dp[deque.peekFirst()];

            // Maintain decreasing order in deque
            while (!deque.isEmpty() && dp[i] >= dp[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);

            // Remove indices out of window
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
        }
        return dp[nums.length - 1];
    }
}