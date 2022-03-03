class Solution {
public:
    
    map<pair<int,int>, int>mp; 
    
    int fun(int n, int k, int target, int d_u){
        if(target == 0 && d_u == n){
            return 1;
        }
        
        
        if(target < 0){
            return 0;
        }
        
        if(d_u == n){
            return 0;
        }
        
        if(target == 0){
            return 0;
        }
        
        
        int c = 0;
        for(int i = 1; i <= k; i++){
            if(mp.count({d_u + 1, target - i}) > 0){
                c = (c + mp[{d_u + 1, target - i}]) % 1000000007;
            }else{
                c =  (c+ fun(n, k, target - i, d_u + 1)) % 1000000007;
            }
        }
        mp[{d_u, target}] = c;
        return c;
    }
    
    int numRollsToTarget(int n, int k, int target) {
        
        int ans = 0;
        for(int i = 1; i <= k; i++){
            //cout<<fun(n, k, target - i, 1)<<endl;
            ans = (ans + fun(n, k, target - i, 1))  % 1000000007;
        }
        return ans;
    }
};