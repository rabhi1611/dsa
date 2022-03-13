class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int ans = 0;
        int sum = 0;
        unordered_map<int, int>mp;
        mp[0] = 1;
        for(auto x: nums){
            sum += x;
            ans += mp[sum - k];
            mp[sum]++;
        }
        return ans;
    }
};