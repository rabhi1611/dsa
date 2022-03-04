class Solution {
public:
    void sortColors(vector<int>& nums) {
        int l_0 = -1;
        int l_2 = nums.size();
        
        int i = 0;
        int j = nums.size() - 1;
        
        while(i <= j){
            
            if(nums[j] == 0){
                if(l_0 + 1 < nums.size()){
                    swap(nums[j], nums[l_0 + 1]);
                    l_0++;
                    i++;
                    continue;
                }
            }
            
            if(nums[i] == 2){
                if(l_2 - 1 >= 0){
                    swap(nums[i], nums[l_2 - 1]);
                    l_2--;
                    j--;
                    continue;
                }
            }
            if(nums[i] == 0){
                if(l_0 != i){
                    if(l_0 + 1 < nums.size()){
                        swap(nums[i], nums[l_0 + 1]);
                        l_0++;
                        i++;
                        continue;
                    }   
                }else{
                    l_0 = i;
                    i++;
                }
                continue;
            }
            if(nums[j] == 2){
                if(l_2 != j){
                    
                    if(l_2 - 1 >= 0){
                        swap(nums[j], nums[l_2 - 1]);
                        l_2--;
                        j--;
                        continue;
                    }
                    
                }else{
                    l_2 = j;
                    j--;
                }
                continue;
            }
            i++;
        }
    }
};