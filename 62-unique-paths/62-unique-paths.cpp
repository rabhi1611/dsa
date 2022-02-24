class Solution {
public:
    //int ans = 0;
    map<pair<int,int>, int> mp;
    int fun(int i, int j, int m, int n){
        if(i == m && j == n){
            //ans++;
            return 1;
        }
        if(i < 0 || j < 0 || i > m || j > n){
            return 0;
        }
        int ans1 = 0;
        if(mp.count({i, j+1}) == 0){
            mp[{i, j+1}] = fun(i, j + 1, m, n);
        }
        ans1 += mp[{i, j+1}];
        int ans2 = 0;
        
        if(mp.count({i + 1, j}) == 0){
            mp[{i + 1, j}] = fun(i + 1, j, m, n);
        }
        
        ans2 += mp[{i + 1, j}];
        return ans1 + ans2;
    }
    
    int uniquePaths(int m, int n) {
        return fun(0, 0, m-1, n-1);
        // ans;
    }
};