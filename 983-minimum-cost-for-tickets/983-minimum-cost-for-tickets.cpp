class Solution {
public:
    vector<int>mp;
    int fun(vector<int>& days, vector<int>& costs, int idx, int cst){
        if(idx >= days.size()){
            return cst;
        }    
        
        int ans = INT_MAX;
        int i;
        for(i = 0; i < costs.size(); i++){
            if(i == 0){
                // 1 day pass
                int temp;
                if(mp[idx + 1] == INT_MAX){
                   temp = fun(days, costs, idx + 1, cst);
                    //cout<<temp <<"-> "<<idx + 1<<endl;
                }
                else{
                    temp = mp[idx + 1];
                }
                mp[idx + 1] = temp;
                ans = min(ans, temp + costs[i]);
                
                
            }else if(i == 1){
                // 7 day pass
                int j = idx;
                while((j < days.size()) && (days[j] - days[idx] + 1) <= 7){
                    j++;
                }
                int temp;
                if(mp[j] == INT_MAX){
                    temp = fun(days, costs, j, cst);
                    //cout<<temp <<"-> "<<j<<endl;
                }else{
                    temp = mp[j];
                }
                mp[j] = temp;
                ans = min(ans, temp + costs[i]);
                
            }else{
                // 30 day pass
                int j = idx;
                while((j < days.size()) && (days[j] - days[idx] + 1) <= 30){
                    j++;
                }
                int temp;
                if(mp[j] == INT_MAX){
                    temp = fun(days, costs, j, cst);
                    //cout<<temp <<"-> "<<j<<endl;
                }else{
                    temp = mp[j];
                }
                mp[j] = temp;
                ans = min(ans, temp + costs[i]);
                
            }
        }
        mp[idx] = ans;
        return ans;
    }
    
    
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        
        for(int i = 0; i < 365; i++){
            mp.push_back(INT_MAX);
        }
        
        int ans = INT_MAX;
        
        for(int i = 0; i < costs.size(); i++){
            if(i == 0){
                // 1 day pass
                //cout<<fun(days, costs, 1, 0)<<" ";
                ans = min(ans, fun(days, costs, 1, 0) + costs[i]);
            }else if(i == 1){
                // 7 day pass
                int j = 0;
                while((j < days.size()) && (days[j] - days[0] + 1) <= 7){
                    j++;
                }
                //cout<<fun(days, costs, j, 0)<<" ";
                ans = min(ans, fun(days, costs, j, 0) + costs[i]);
            }else{
                // 30 day pass
                int j = 0;
                while((j < days.size()) && (days[j] - days[0] + 1) <= 30){
                    j++;
                }
                //cout<<fun(days, costs, j, 0)<<" ";
                ans = min(ans, fun(days, costs, j, 0) + costs[i]);
            }
        }
        
        return ans;
    }
};