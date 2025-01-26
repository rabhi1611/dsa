class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        
        Arrays.sort(nums);

        int[] temp = new int[n];

        int j = 0;
        int k = ((n - 1) / 2) + 1;
        
        int i = n - 1;

        while(i >= 0){
            if(i % 2 == 0){
                temp[i] = nums[j];
                j++;
            } else {
                temp[i] = nums[k];
                k++;
            }
            i--;
        }


        for(i = 0; i < n; i++){
            nums[i] = temp[i];
        }
    }   
}