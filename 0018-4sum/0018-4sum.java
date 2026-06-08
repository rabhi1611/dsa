class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < n; i += 1){
            if(i > 0 && nums[i - 1] == nums[i]) continue;  
            for(int j = i + 1; j < n; j += 1){
                if(j != (i + 1) && nums[j - 1] == nums[j]) continue;
                int k = j + 1, l = n - 1;

                while(k < l){
                    long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];

                    if(sum == target){
                        ans.add(List.of(nums[i], nums[j], nums[k], nums[l]));
                        
                        k += 1;
                        l -= 1;

                        while(k < l && nums[k - 1] == nums[k])  k += 1;
                        while(k < l && nums[l + 1] == nums[l])  l -= 1;
                    } else if (sum < target) {
                        k += 1;
                    } else {
                        l -= 1;
                    }
                }
            }
        }

        return ans;
    }
}