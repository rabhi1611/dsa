class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return;
        }
        
        int i = n - 1;
        
        while(i > 0){
            if(nums[i - 1] < nums[i]){
                break;
            }
            i--;
        }
        
        if(i == 0){
            reverse(nums, i, n - 1);
            return;
        }
       
        int el_idx = i;
        int j = i + 1;
        while(j < n){
            if(nums[j] > nums[i - 1] && nums[j] <= nums[el_idx]){
                el_idx = j;
            }
            j++;
        }
        
        swap(nums, i - 1, el_idx);
        
        reverse(nums, i, n - 1);
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int i, int j){
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}