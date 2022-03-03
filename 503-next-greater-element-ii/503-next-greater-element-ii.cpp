class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        vector<int>arr;
        stack<int>s;
        for(int i = 2 * nums.size() - 1; i >= 0; i--){
            while(!s.empty() && (s.top() <= nums[i % nums.size()])){
                s.pop();
            }
            if(i < nums.size()){
                if(s.empty() == false){
                    arr.push_back(s.top());
                }else{
                    arr.push_back(-1);
                }
            }
            s.push(nums[i % nums.size()]);
        }
        reverse(arr.begin(), arr.end());
        return arr;
    }
};