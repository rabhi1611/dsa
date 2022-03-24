class Solution {
public:
    //int ans = INT_MAX;
    map<pair<int, int>, int> mp;
    int fun(vector<vector<int>>& triangle, int idx, int level){
        if(level >= triangle.size()){
            //ans = min(ans, sum);
            return 0;
        }    
        
        if(idx >= triangle[level].size()){
            return 0;
        }
        int a, b;
        if(mp.count({level + 1, idx}) != 0){
            a = mp[{level + 1, idx}];
        }
        else
            a = fun(triangle, idx, level + 1);
        
        if(mp.count({level + 1, idx + 1}) != 0){
            b = mp[{level + 1, idx + 1}];
        }
        else
            b = fun(triangle, idx + 1, level + 1);
        
        mp[{level, idx}] = min(a, b) + triangle[level][idx];
        return min(a, b) + triangle[level][idx];
    }
    
    int minimumTotal(vector<vector<int>>& triangle) {
        return fun(triangle, 0, 0);
    }
};