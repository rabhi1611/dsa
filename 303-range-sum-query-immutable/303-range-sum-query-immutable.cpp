class NumArray {
public:
    vector<int>v;
    NumArray(vector<int>& nums) {
        int sum=nums[0];
        v.push_back(nums[0]);
        for(int i=1;i<nums.size();i++){
            sum+=nums[i];
            v.push_back(sum);
        }
    }
    
    int sumRange(int left, int right) {
        int ans=0;
        if(right<v.size()){
            ans+=v[right];
        }
        if((left-1)>=0){
            ans-=v[left-1];
        }
        return ans;
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * int param_1 = obj->sumRange(left,right);
 */