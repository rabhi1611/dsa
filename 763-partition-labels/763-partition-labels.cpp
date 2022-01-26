class Solution {
public:
    vector<int>ans;
    int find_last_idx(unordered_map<char, int>& mp, int s, int e, string st){
        int maxi=mp[st[s]];
        int new_maxi=mp[st[s]];
        while(1){
            for(int i=s;i<=maxi;i++){
                new_maxi=max(new_maxi,mp[st[i]]);
            }
            if(maxi==new_maxi){
                break;
            }
            maxi=new_maxi;
        }
        return maxi;
    }
    
    vector<int> partitionLabels(string st) {
        unordered_map<char, int>mp;
        for(int i=0;i<st.size();i++){
            mp[st[i]]=i;
        }
        int s=0,e=0;
        while(s<st.size()){
            e=find_last_idx(mp,s,e,st);
            ans.push_back(e-s+1);
            s=e+1;
        }
        return ans;
    }
};