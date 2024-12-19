class Pair {
    int index;
    int val;

    Pair(int idx, int val){
        this.index = idx;
        this.val = val;
    }
}

class Solution {
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        
        Deque<Pair> dq = new ArrayDeque<>();
        
        int[] ans = new int[n + 1 - k];
        
        for(int i = 0; i < n; i++){
            while(!dq.isEmpty() && dq.getLast().val <= nums[i]){
                dq.removeLast();
            }
            
            dq.addLast(new Pair(i, nums[i]));
            
            if(dq.getFirst().index < i + 1 - k){
                dq.removeFirst();
            }
            
            if(i + 1 - k >= 0)
                ans[i + 1 - k] = dq.getFirst().val;
        }
        
        return ans;
    }
}