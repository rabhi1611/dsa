class Solution {
public:
    int numEquivDominoPairs(vector<vector<int>>& dominoes) {
        map<pair<int,int>,int>m;
        int ans=0;
        for(auto x:dominoes){
            int a=x[0];
            int b=x[1];
            if(m.count({a,b})==0 && m.count({b,a})==0){
                m[{a,b}]++;
                continue;
            }
            if(m.count({a,b})>0){
                m[{a,b}]++;
                continue;
            }
            if(m.count({b,a})>0){
                m[{b,a}]++;
                continue;
            }
        }
        for(auto x:m){
                int temp=x.second;
                temp=(temp*(temp-1))/2;
                ans+=temp;
            
        }
        return ans;
    }
};