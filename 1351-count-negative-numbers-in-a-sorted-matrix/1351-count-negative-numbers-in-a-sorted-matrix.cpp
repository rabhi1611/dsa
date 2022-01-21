class Solution {
public:
    int binary_s(vector<int>v){
        int s=0;
        int e=v.size()-1;
        int ans=-1;
        while(s<=e){
            int mid=(s+e)/2;
            if(v[mid]>=0){
                ans=mid;
                s=mid+1;
            }else{
                e=mid-1;
            }
        }
        return ans;
    }

    int countNegatives(vector<vector<int>>& grid) {
        int ans=0;
        for(auto x:grid){
            int re=binary_s(x);
            //cout<<re<<" ";
            if(re==-1 && x[0]>=0){
                // sb positive hai
                cout<<0<<endl;
                continue;
            }
            if(re==-1 && x[0]<0){
                // sb negative hai
                ans+=(x.size());
              //  cout<<x.size()<<endl;
                continue;
            }
            ans+=(x.size()-1-re);
            //cout<<(x.size()-1-re)<<endl;
        }
        return  ans;
    }
};