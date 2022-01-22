class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        int arr[10001]={};
        vector<int>ans;
        for(auto x:nums){
            arr[x]++;
            if(arr[x]>1){
                ans.push_back(x);
            }
        }
        for(int i=1;i<=nums.size();i++){
            if(arr[i]==0){
                ans.push_back(i);
            }
        }
        return ans;
    }
};