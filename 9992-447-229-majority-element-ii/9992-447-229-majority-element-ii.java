class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1 = 0, el1 = Integer.MIN_VALUE, cnt2 = 0, el2 = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++){
            if(cnt1 == 0 && nums[i] != el2){
                cnt1 = 1;
                el1 = nums[i];
            }
            
            else if(cnt2 == 0 && nums[i] != el1){
                cnt2 = 1;
                el2 = nums[i];
            }
            
            else if(el1 == nums[i]){
                cnt1++;
            }
            
            else if(el2 == nums[i]){
                cnt2++;
            }
            
            else{
                cnt1--;
                cnt2--;
            }
        }
        
        int target = nums.length / 3;
        List<Integer> ans = new ArrayList<>();
        
        cnt1 = 0; cnt2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(el1 == nums[i])  cnt1++;
            if(el2 == nums[i])  cnt2++;
        }
        
        if(cnt1 > target) ans.add(el1);
        if(cnt2 > target) ans.add(el2);
            
        return ans;
    }
}