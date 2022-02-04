class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        bool all_negative = true;
        for(int i=0; i<nums.size(); i++){
            if(nums[i] > 0){
                all_negative = false;
                break;
            }
        }
        
        if(all_negative == true){
            int mini = INT_MIN;
            for(auto x: nums){
                cout<<x<<" "<<mini<<endl; 
                if(x > mini){
                    mini = x;
                }
            }
            return mini;
        }
        else{
            // cadenes algo
            int sum = 0;
            int max_num = INT_MIN;
            for(auto x: nums){
                sum += x;
                if(sum < 0 ){
                    sum = 0;
                }
                if(max_num < sum){
                    max_num = sum;
                }
            }
            return max_num;
        }
    }
};