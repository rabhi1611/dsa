class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        // find the breaking point
        int i = n - 1;
        while(i > 0){
            if(nums[i] > nums[i - 1]){
                break;
            }
            i -= 1;
        }

        if(i == 0){
            // no bp
            // reverse and return
            reverse(nums, 0, n - 1);
            return;
        }



        int breakingPointIdx = i - 1, j;

        // find next greater element from breakingPoint
        for(j = n - 1; j > breakingPointIdx; j -= 1){
            if(nums[j] > nums[breakingPointIdx]){
                break;
            }
        }

        // swap
        int temp = nums[breakingPointIdx];
        nums[breakingPointIdx] = nums[j];
        nums[j] = temp;

        // reverse 
        reverse(nums, breakingPointIdx + 1, n - 1);
    }

    void reverse(int[] arr, int left, int right){
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    void sort(int[] arr, int left, int right){
        Arrays.sort(arr, left, right);
    }
}