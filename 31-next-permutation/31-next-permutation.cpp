class Solution {
public:
    
    int bin_search(vector<int>& nums, int s, int e, int pivot){
        int ans = -1;
        while(s <= e){
            int mid = (s+e)/2;
            if(nums[mid] > pivot){
                ans = mid;
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return ans;
    }
    
    
    void nextPermutation(vector<int>& nums) {
        int i = nums.size() - 2;
        int j = nums.size() - 1;
        while(i >= 0){
            if(nums[i] < nums[j]){
                break;
            }
            i--;
            j--;
        }
        // j se subsequesnce start hai
        if(i == -1){
            sort(nums.begin(), nums.end());
            return;
        }
        // i pivot hai
        // i se j
        // find rightmost successor of pivot
        int idx = bin_search(nums, j, nums.size() - 1, nums[i]);
        cout<<i<<" "<<j<<" "<<idx<<endl;
        swap(nums[idx], nums[i]);
        i = j;
        j = nums.size() - 1;
        while(i <= j){
            swap(nums[i], nums[j]);
            i++;
            j--;
        }
        return;
    }
};