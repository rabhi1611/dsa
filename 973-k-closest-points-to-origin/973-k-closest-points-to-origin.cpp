class Solution {
public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        vector<pair<long long,int>>ans;
        for(int i=0;i<points.size();i++){
            long long x=(long long)points[i][0];
            long long y=(long long)points[i][1];
            long long dis=(x*x)+(y*y);
            ans.push_back({dis,i});
        }
        sort(ans.begin(),ans.end());
        vector<vector<int>>result;
        int i=0;
        while(k--){
            result.push_back({points[ans[i].second][0],points[ans[i].second][1]});
            i++;
        }
        return result;
    }
};