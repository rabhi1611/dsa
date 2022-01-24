class Solution {
public:
    vector<pair<int,int>>ans;
    
    int pivot_idx(vector<pair<int,int>>&v, int s, int e){
        int t_p=s+(e-s)/2;
        int target=v[t_p].first;
        int s_c=0;
        do{
            s_c=0;
            for(int i=s;i<t_p;i++){
                if(v[i].first>target){
                    swap(v[i].first,v[t_p].first);
                    swap(v[i].second,v[t_p].second);
                    s_c++;
                    t_p=i;
                    break;
                }
            }
            for(int i=e;i>t_p;i--){
                if(v[i].first<v[t_p].first){
                    swap(v[i].first,v[t_p].first);
                    swap(v[i].second,v[t_p].second);
                    s_c++;
                    t_p=i;
                    break;
                }
            }
        }while(s_c>0);
        return t_p;
    } 
    
    void quicksort(vector<pair<int,int>>&v, int k, int s, int e){
        if(s>e){
            return;
        }
        int p_idx=pivot_idx(v,s,e);
        if((p_idx+1)==k){
            ans=vector<pair<int,int>>(v.begin(),v.begin()+k);
            return;
        }else if((p_idx+1) > k){
            quicksort(v,k,s,p_idx-1);
        }else{
            quicksort(v,k,p_idx+1,e);
        }
    }
    
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        vector<pair<int,int>>v;
        for(int i=0;i<points.size();i++){
            v.push_back({(points[i][0]*points[i][0])+(points[i][1]*points[i][1]),i});
        }
        quicksort(v,k,0,v.size()-1);
        vector<vector<int>>h;
        for(auto x:ans){
            int idx=x.second;
            h.push_back(points[idx]);
        }
        return h;
    }
};