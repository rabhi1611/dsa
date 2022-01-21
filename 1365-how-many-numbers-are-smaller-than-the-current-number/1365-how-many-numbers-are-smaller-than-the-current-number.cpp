class Solution {
public:
    vector<int> smallerNumbersThanCurrent(vector<int>& nums) {
        int arr[102]={};
        for(auto x:nums){
            arr[x]++;
        }
        int sum=0;
        for(int i=0;i<102;i++){
            int temp=arr[i];
            arr[i]=sum;
            sum+=temp;
        }
        for(int i=0;i<10;i++){
            //cout<<arr[i]<<" ";
        }
        vector<int>ans;
        for(auto x:nums){
            ans.push_back(arr[x]);
        }
        return ans;
    }
};