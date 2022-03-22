class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int i = 0, j = 1;
        int ans = -1;
        while(j < nums.size()){
            if(nums[i] == nums[j]){
                ans = nums[i];
                break;
            }
            i++;
            j++;
        }
        return ans;
    }
};