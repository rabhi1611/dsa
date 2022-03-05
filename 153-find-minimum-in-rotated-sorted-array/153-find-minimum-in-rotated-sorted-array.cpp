class Solution {
public:
    int findMin(vector<int>& nums) {
        int s = 0;
        int e = nums.size() - 1;
        if(nums[e] >= nums[0]){
            return nums[s];
        }
        int mid;
        while(s <= e){
            //cout<<s<<" "<<e<<endl;
            mid = (s+e)/2;
            if(nums[mid] >= nums[0]){
                s = mid + 1;
            }else{
                e = mid - 1;
            }
            
        }
        cout<<mid;
        if(mid == nums.size() -1){
            return nums[mid];
        }
        if(nums[mid] > nums[mid + 1]){
            return nums[mid + 1];
        }
        return nums[mid];
    }
};