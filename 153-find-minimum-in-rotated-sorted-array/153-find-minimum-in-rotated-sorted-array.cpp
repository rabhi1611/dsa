class Solution {
public:
    int findMin(vector<int>& nums) {
        int mi = INT_MAX;
        for(auto x: nums){
            mi = min(mi, x);
        }
        return mi;
    }
};