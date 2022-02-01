class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int>mp;
        int max_k_idx=-1;
        string temp="";
        int ans=0;
        for(int i=0;i<s.size();i++){
            //cout<<temp<<endl;
            //cout<<mp[s[i]]<<" "<<s[i]<<endl;
            if(mp.count(s[i]) > 0){
                temp[mp[s[i]]]='0';
                if(max_k_idx < mp[s[i]]){
                    max_k_idx = mp[s[i]];
                }
                mp[s[i]]=i;
                temp+=s[i];
                if(ans < (temp.size()-1-max_k_idx)){
                    ans = (temp.size()-1-max_k_idx);
                }
                continue;
            }
            mp[s[i]]=i;
            temp+=s[i];
            if(ans < (temp.size()-1-max_k_idx)){
                ans = (temp.size()-1-max_k_idx);
            }
        }
        //cout<<temp;
        if(ans < (temp.size()-1-max_k_idx)){
            ans = (temp.size()-1-max_k_idx);
        }
        return ans;
    }
};