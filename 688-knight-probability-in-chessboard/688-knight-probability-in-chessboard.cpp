class Solution {
public:
    unordered_map<string, double>dp;
    double fun(int n, int k, int r, int c){
        if(k == 0){
            if((r >= 0 && r < n) && (c >= 0 && c < n)){
                // mtlb board pe hai
                return 1.0;
            }
            return 0.0;
        }
        
        if(!(r >= 0 && r < n)){
            return 0.0;
        }
    
        if(!(c >= 0 && c < n)){
            return 0.0;
        }
        
        string temp = to_string(r) + "r" + to_string(c) +"r" + to_string(k);
        
        if(dp.count(temp) > 0){
            return dp[temp];
        }
        
        double ans = 0.0;
        
        int arr1[] = {1, 2, 2, 1, -1, -2, -2, -1};
        int arr2[] = {2, 1, -1, -2, 2, 1, -1, -2};
        
        for(int i = 0; i < 8; i++){
            ans += fun(n, k - 1, r + arr1[i], c + arr2[i]);
        }
        ans = ans / 8;
        temp = to_string(r) + "r" + to_string(c) +"r" + to_string(k);
        dp[temp] = ans;
        return ans;
    }
    
    double knightProbability(int n, int k, int row, int column) {
        /*for(int i = 0; i < 100; i++){
            dp[i] = new double[100];
            for(int j = 0; j < 100; j++){
                dp[i][j] = -1.0;
            }
        }
        dp[row][column] = double(1.0);
        double ans = 
        
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0; j <  n; j++){
                cout<<dp[i][j]<<" ";
            }
            cout<<endl;
        }*/
        return fun(n, k, row, column);
    }
};