class Solution {
public:
    bool checkPossibility(vector<int>& nums) {
        int c=0;
        int t=INT_MIN;
        int idx=-1;
        for(int i=0;i<nums.size();i++){
            if(i>idx && nums[i]>=t){
                idx=i;
                t=nums[i];
                continue;
            }
            c++;
        }
        if(c<=1){
            return true;
        }
        c=0;
        t=INT_MAX;
        idx=nums.size();
        for(int i=nums.size()-1;i>=0;i--){
            if(i<idx && nums[i]<=t){
                idx=i;
                t=nums[i];
                continue;
            }
            c++;
        }
        if(c<=1){
            return true;
        }
        return false;
    }
};