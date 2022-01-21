class Solution {
public:
    vector<bool> kidsWithCandies(vector<int>& candies, int extraCandies) {
        int maxi=INT_MIN;
        for(auto x:candies){
            maxi=max(x,maxi);
        }
        vector<bool>ans(candies.size());
        int i=0;
        for(auto x:candies){
            if(x+extraCandies>=maxi){
                ans[i]=true;
            }else{
                ans[i]=false;
            }
            i++;
        }
        return ans;
    }
};