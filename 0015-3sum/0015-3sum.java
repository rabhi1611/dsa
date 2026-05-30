class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for(int k = 0; k < n; k++){
            if(k > 0 && nums[k] == nums[k - 1]){
                continue;
            }
            int j = k + 1, i = n - 1;
            int target = (-1) * nums[k];

            while (j < i){
                if (nums[i] + nums[j] > target){
                    i--;
                } else if (nums[i] + nums[j] < target){
                    j++;
                } else {
                    ans.add(List.of(nums[k], nums[j], nums[i]));
                    j++;
                    i--;
                    while(j < i && nums[j] == nums[j - 1])  j++;
                    while(j < i && nums[i] == nums[i + 1])  i--;
                }
            }
        }

        return ans;
    }
}