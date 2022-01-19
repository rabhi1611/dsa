 bool compare(pair<int,int>a, pair<int,int>b){
        if(a.first < b.first){
            return true;
        }
        if(a.first == b.first){
            return a.second < b.second;
        }
        return false;
    }
class Solution {
public:
    int heightChecker(vector<int>& heights) {
        int c=0;
        vector<pair<int,int>>expected;
        for(int i=0;i<heights.size();i++){
            expected.push_back({heights[i],i});
        }
        sort(expected.begin(),expected.end(),compare);
        for(int i=0;i<heights.size();i++){
            if(heights[i]==expected[i].first){
                c++;
            }
        }
        return heights.size()-c;
    }
};