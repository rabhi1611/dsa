class Solution {
    
    private int[] findNse(int[] nums){
        
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        
        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        
        return nse;
    }
    
    private int[] findPse(int[] nums){
        
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] pse = new int[n];
        
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]){
                st.pop();
            }
            
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        
        return pse;
    }
    
    private long sumOfSubArraysMin(int[] nums){
        
        int[] nse = findNse(nums);
        int[] pse = findPse(nums);
        
        int n = nums.length;
        Long sum = 0L;
        
        for(int i = 0; i < n; i++){
            int a = i - pse[i];
            int b = nse[i] - i;
            
            sum += ((a * b * 1L * nums[i]));
        }
        
        return sum;
    }
    
    
    private int[] findNme(int[] nums){
        
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] nme = new int[n];
        
        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                st.pop();
            }
            
            nme[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        
        return nme;
    }
    
    private int[] findPme(int[] nums){
        
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] pme = new int[n];
        
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
                st.pop();
            }
            
            pme[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        
        return pme;
    }
    
    private long sumOfSubArraysMax(int[] nums){
        
        int[] nme = findNme(nums);
        int[] pme = findPme(nums);
        
        int n = nums.length;
        Long sum = 0L;
        
        for(int i = 0; i < n; i++){
            int a = i - pme[i];
            int b = nme[i] - i;
            
            sum += ((a * b * 1L * nums[i]));
        }
        
        return sum;
    }
    
    
    public long subArrayRanges(int[] nums) {
        long sumOfMins = sumOfSubArraysMin(nums);
        long sumOfMaxs = sumOfSubArraysMax(nums);;
        
        return sumOfMaxs - sumOfMins;
    }
}