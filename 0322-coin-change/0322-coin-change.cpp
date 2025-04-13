class Solution {
public:
    int arr[10001];
    int fun(vector<int>& coins, int amount){
        if(amount == 0){
            return 0;
        }
        
        
        int i = INT_MAX;
        for(auto x: coins){
            if(amount - x < 0){
                   continue;
            }    
            int k;
            if(arr[amount - x] == -1){    
                    k = fun(coins, amount - x);
            }
            else{
                    k = arr[amount - x];
            }
            if(k != INT_MAX){
                i = min(i, k+1);
            }
        }
        
        arr[amount] = i;
        return i;        
    }
    
    int coinChange(vector<int>& coins, int amount) {
        memset(arr, -1, sizeof(arr));
        int ans = fun(coins, amount);
        if(ans == INT_MAX) return -1;
        return ans; 
    }
};