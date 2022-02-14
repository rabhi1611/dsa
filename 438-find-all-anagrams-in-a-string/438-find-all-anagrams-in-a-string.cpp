class Solution {
public:
  
    vector<int> findAnagrams(string s, string p) {
        vector<int>ans;
        if(s.length() < p.length()){
            return ans;
        }
        
        vector<int>v(26);
        for(auto x: p){
            v[x - 97] += 1;
        }
        
        vector<int>temp(26);
        
        int i = 0;
        int s_p = i;
        while(i < p.length()){
            temp[s[i] - 97] += 1;
            i++;
        }
        if(temp == v){
            ans.push_back(s_p);
        }
        s_p++;
        
        while(i<s.length()){
            //cout<<s_p<<" "<<i<<endl;
            temp[s[s_p - 1] - 97] -= 1;
            temp[s[i] - 97] += 1;
            if(temp == v){
                ans.push_back(s_p);
            }
            //temp = v;
            s_p++;
            i++;
        }
        return ans;
    }
};