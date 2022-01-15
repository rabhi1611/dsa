class Solution {
public:
    vector<int> sortArrayByParityII(vector<int>& nums) {
        stack<int>even;
        stack<int>odd;
        for(int i=0;i<nums.size();i++){
            if(i%2==0){
                if(nums[i]%2==0){
                    continue;
                }else{
                    if(even.size()==0){
                        odd.push(i);
                        //cout<<i<<" ";
                    }else{
                        int idx=even.top();
                        swap(nums[idx],nums[i]);
                        even.pop();
                    }
                }
            }else{
                if(nums[i]%2==1){
                    continue;
                }else{
                    if(odd.size()==0){
                        //cout<<i<<" ";
                        even.push(i);
                    }else{
                        int idx=odd.top();
                        swap(nums[idx],nums[i]);
                        odd.pop();
                    }
                }
            }
        }
        while(even.size()!=0){
            int idx1=odd.top();
            int idx2=even.top();
            swap(nums[idx1],nums[idx2]);
            odd.pop();
            even.pop();
        }
        return nums;
    }
};