class Solution {
public:
int record[10001] = {};
    bool fun(vector<int>& nums, int i){
        if(i == nums.size() - 1){
            return true;
        }
        bool ans = false;
        for(int j = 1; j <= nums[i]; j++){
            bool check;
            if(record[i+j] != -1){
                check = record[i + j];
            }else{
                check = fun(nums, i + j); 
            }
            if(check == true){
                ans = true;
                break;
            }
        }
        record[i] = ans;
        return ans;
    }
    
    bool canJump(vector<int>& nums) {
        int i = 0;
        memset(record, -1, sizeof(record));
        //cout<<record[0];
        return fun(nums, 0);
    }
};