class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int presum[100001] = {};
        int suffsum[100001] = {};
        presum[0] = INT_MIN;
        suffsum[nums.size()-1] = INT_MIN;
        int temp1 = nums[0];
        int temp2 = nums[nums.size()-1];
        
        for(int i=1 ;i < nums.size() ;i++){
            presum[i] = temp1;
            temp1 = temp1 * nums[i];
            suffsum[nums.size()-1-i] = temp2;
            temp2 = temp2 * nums[nums.size()-1-i];
        }
        
        vector<int>arr(100001);
        for(int i=0; i<nums.size(); i++){
            if(presum[i] == INT_MIN && suffsum[i] == INT_MIN){
                arr[i] = 0;
            }else if(presum[i] == INT_MIN){
                arr[i] = suffsum[i];
            }else if(suffsum[i] == INT_MIN){
                arr[i] = presum[i];
            }else{
                arr[i] = presum[i] * suffsum[i];
            }
        }
        return vector<int>(arr.begin(), arr.begin()+nums.size());
    }
};