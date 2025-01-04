class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i - 1] == nums[i]) continue;
            
            for(int j = i + 1; j < n; j++){
                if(j != (i + 1) && nums[j - 1] == nums[j]) continue;
                
                int k = j + 1, l = n - 1;
                
                while(k < l){
                    long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];
                    
                    if(sum < target){
                        k++;
                    } else if (sum > target){
                        l--;
                    }
                     else {
                         ans.add(List.of(nums[i], nums[j], nums[k], nums[l]));
                         k++;
                         l--;
                         
                         while(k < l && nums[k] == nums[k - 1]) k++;
                         while(k < l && nums[l] == nums[l + 1]) l--;
                     }
                }
            }
        }
        
        return ans;
    }
}