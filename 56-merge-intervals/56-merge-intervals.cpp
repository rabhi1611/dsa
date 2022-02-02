class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<vector<int>>ans;
        if(intervals.size() == 0){
            return ans;
        }
        sort(intervals.begin(), intervals.end());
        int s = intervals[0][0];
        int e = intervals[0][1];
        
        for(auto x: intervals){
            if(x[0] <= e){
                e = max(x[1], e);
            }else{
                ans.push_back({s,e});
                s = x[0];
                e= x[1];
            }
        }
        ans.push_back({s,e});
        return ans;
    }
};