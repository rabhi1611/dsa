class Solution {
public:
    
    unordered_set<string>st;
    
    unordered_map<string, int>mp;
    
    int fun(vector<string>v, string s){
        if(s.size() == 0){
            return 1;
        }
        
        int c = 0;
        
        string t="";
        for(auto x: s){
            t += x;
            if(st.count(t) > 0){
                v.push_back(t);
                if(mp.count(s.substr(t.size())) > 0){
                    c += mp[s.substr(t.size())];
                }
                else{
                    c += fun(v, s.substr(t.size()));
                }
            }
        }
        mp[s] = c;
        return mp[s];
    }
    
    
    int numDecodings(string s) {
        
        for(int i = 1; i <= 26; i++){
            st.insert(to_string(i));
        }

        vector<string>v;
        return fun(v, s);        
    }
};