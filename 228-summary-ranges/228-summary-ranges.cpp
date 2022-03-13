class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        if(nums.size() == 0){
            return {};
        }
        
        if(nums.size() == 1){
            return {to_string(nums[0])};
        }
        
        vector<string>ans;
        
        int i = 0;
        int j = 1;
        
        string temp = "";
        while(j < nums.size()){
            if(nums[j] != nums[j - 1] + 1){
                if((j - 1) != i){
                    temp += to_string(nums[i]);
                    temp += "->";
                    temp += to_string(nums[j - 1]);
                    ans.push_back(temp);
                }else{
                    temp += to_string(nums[i]);
                    ans.push_back(temp);
                }
                temp = "";
                i = j;
                j++;
                continue;
            }
            j++;
        }
        
        if((j - 1) != i){
            temp += to_string(nums[i]);
            temp += "->";
            temp += to_string(nums[j - 1]);
            ans.push_back(temp);
        }else{
            temp += to_string(nums[i]);
            ans.push_back(temp);
        }
        return ans;
    }
};