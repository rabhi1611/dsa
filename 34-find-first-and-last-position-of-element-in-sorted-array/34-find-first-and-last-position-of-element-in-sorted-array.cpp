class Solution {
public:
    
    int fun(vector<int>& nums, int s, int e, int target){
        int ans = -1;
        while(s <= e){
            int mid = (s+e)/2;
            if(nums[mid] >= target){
                ans = mid;
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return ans;
    }
    
    vector<int> searchRange(vector<int>& nums, int target) {
        if(nums.size() == 0){
            return {-1, -1};
        }
        int start = fun(nums, 0, nums.size() - 1, target);
        if(start == -1){
            return {-1, -1};
        }
        auto end_pointer = upper_bound(nums.begin(), nums.end(), target);
        end_pointer--;
        if(nums[start] == target && (*end_pointer == target)){
            int end = (end_pointer - nums.begin());
            return {start, end};
        }
        return {-1, -1};
    }
};