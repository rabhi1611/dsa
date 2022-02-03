class Solution {
public:
    
    int fun(vector<int>& nums, int s, int e, int target){
        int ans = -1;
        while(s<=e){
            int mid = (s+e)/2;
            if(nums[mid] == target){
                ans = mid;
                break;
            }
            else if(nums[mid] < target){
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return ans;
    }
    
    int search(vector<int>& nums, int target) {
        int pivot = -1;
        for(int i=1; i<nums.size() ;i++){
            if(nums[i-1] <= nums[i]){
                continue;
            }
            pivot = i;
            break;
        }
        //cout<<pivot<<endl;
        if(pivot != -1){
            int idx = -1;
            idx = fun(nums, pivot, nums.size()-1, target);
            if(idx == -1)
                idx = fun(nums, 0, pivot - 1, target);
            return idx;
        }
        return fun(nums, 0, nums.size()-1, target);
    }
};