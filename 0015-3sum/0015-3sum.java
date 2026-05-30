class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> ls = new ArrayList<>();

        for(int i = 0; i < n; i += 1){
            if(i > 0 && nums[i - 1] == nums[i]){
                continue;
            }

            int j = i + 1, k = n - 1;
            int target = -1 * nums[i];

            while(j < k){
                if(nums[j] + nums[k] < target){
                    j += 1;
                } else if (nums[j] + nums[k] > target){
                    k -= 1;
                } else {
                    ls.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j += 1;
                    k -= 1;
                    while(j < k && nums[j] == nums[j - 1])  j += 1;
                    while(j < k && nums[k] == nums[k + 1])  k -= 1;
                }
            }
        }
        
        return ls;
    }
}