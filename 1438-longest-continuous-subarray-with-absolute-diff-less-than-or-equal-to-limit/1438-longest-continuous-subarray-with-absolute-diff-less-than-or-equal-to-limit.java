class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        
        Deque<Integer> maxRec = new ArrayDeque<>();
        Deque<Integer> minRec = new ArrayDeque<>();
        
        int l = 0, r = 0, ans = 0;

        while(r < n){
            // expand

            while(!maxRec.isEmpty() && maxRec.peekLast() < nums[r]){
                maxRec.pollLast();
            }

            maxRec.offerLast(nums[r]);

            while(!minRec.isEmpty() && minRec.peekLast() > nums[r]){
                minRec.pollLast();
            }

            minRec.offerLast(nums[r]);

            // shrink
            while(Math.abs(maxRec.peekFirst() - minRec.peekFirst()) > limit){
                if(nums[l] == maxRec.peekFirst()){
                    maxRec.removeFirst();
                }

                if(nums[l] == minRec.peekFirst()){
                    minRec.removeFirst();
                }

                if(maxRec.isEmpty() || minRec.isEmpty()){
                    break;
                }

                l += 1;
            }

            ans = Math.max(ans, r - l + 1);
            r += 1;
        }

        return ans;
    }
}