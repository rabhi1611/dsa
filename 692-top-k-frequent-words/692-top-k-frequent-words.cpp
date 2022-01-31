    bool compare(string a, string b){
        if(a<=b){
            return true;
        }
        return false;
    }
    


class Solution {
public:    
    vector<string> topKFrequent(vector<string>& words, int lim) {
        unordered_map<string,int>mp;
        for(auto x: words){
            mp[x]++;
        }
        map<int,vector<string>>m;
        for(auto x:mp){
            m[x.second].push_back(x.first);
        }
        for(auto x:m){
            vector<string>v=x.second;
            sort(v.begin(),v.end(),compare);
            m[x.first]=v;
        }
        vector<string>ans;
        while(m.size()!=0){
            auto it=m.end();
            it--;
            vector<string>v=it->second;
            m.erase(it);
            for(int i=0;i<v.size();i++){
                ans.push_back(v[i]);
            }
        }
        return vector<string>(ans.begin(),ans.begin()+lim);
    }
};