class Solution {
public:
    int maxProfit(vector<int>& prices) {
        
        int mini = INT_MAX;
        int profit = 0;
        
        for(auto x: prices){
            if(mini > x){
                mini = x;
            }
            
            int t_p = x - mini;
            profit = max(profit, t_p);     
        }
        
        return profit;
    }
};