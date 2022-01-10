   bool compare(pair<int,int>a, pair<int,int>b){
        if(a.second < b.second){
            return true;
        }
        if(a.second == b.second){
            return a.first <= b.first;
        }
        return false;
    }

class Solution {
public:
 
    
    vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {
        vector<pair<int,int>>v;
        for(int i=0;i<mat.size();i++){
            int n_s=0;
            for(int j=0;j<mat[i].size();j++){
                if(mat[i][j]==1){
                    n_s++;
                }
            }
            v.push_back({i,n_s});
        }
        sort(v.begin(),v.end(),compare);
        for(auto x:v){
            cout<<x.first<<" "<<x.second<<endl;
        }
        vector<int>ans;
        int i=0;
        while(k--){
            ans.push_back(v[i++].first);
        }
        return ans;
    }
};