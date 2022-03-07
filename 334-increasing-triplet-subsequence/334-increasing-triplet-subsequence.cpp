class Solution {
public:
    bool increasingTriplet(vector<int>& nums) {
        int a = INT_MAX;
        int b = INT_MAX;
        int c = INT_MAX;
        
        for(auto x: nums){
            if(x <= a){
                a = x;
                continue;
            }
            if(x <= b){
                b = x;
                continue;
            }
            if(x <= c){
                c = x;
                return true;
            }
        }
        return false;
    }
};