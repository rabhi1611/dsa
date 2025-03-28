class Solution {
public:
    int find(vector<int>& nums, int s, int e){
        int pivot_idx = e;
        int c;
        do{
            c = 0;
            for(int i = s; i < pivot_idx; i++){
                if(nums[i] > nums[pivot_idx]){
                    swap(nums[i], nums[pivot_idx]);
                    pivot_idx = i;
                    c++;
                    break;
                }
            }

            for(int i = e; i > pivot_idx; i--){
                if(nums[i] <= nums[pivot_idx]){
                    swap(nums[i], nums[pivot_idx]);
                    pivot_idx = i;
                    c++;
                    break;
                }
            }
        }while(c > 0);
        
        return pivot_idx;
    }
    int ans;
    void fun(vector<int>& nums, int k, int s, int e){
        if(s > e){
            return;
        }
        
        int idx = find(nums, s, e);
        //cout<<idx<<" ";
        //cout<<nums.size() - idx<<endl;
        if(nums.size() - idx == k){
            ans = idx;
        }
        
        fun(nums, k, s, idx - 1);
        fun(nums, k, idx + 1, e);
    }
    
    int findKthLargest(vector<int>& nums, int k) {
        fun(nums, k, 0, nums.size() - 1);
        //cout<<ans<<" ";
        return nums[ans];
    }
};