class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int ans = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;

        int i = 0;
        while(i < n - 2){
            int j = i + 1, k = n - 1;

            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                int currDiff = Math.abs(target - sum);
                //System.out.println(Math.abs(target - sum));
                if(currDiff < diff){
                    ans = sum;
                    diff = currDiff;
                }
                
                if(sum <= target){
                    j = j + 1;
                } else {
                    k = k - 1;
                }
            }

            i = i + 1;
        }

        return ans;
    }
}