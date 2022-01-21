class Solution {
public:
    char findTheDifference(string s, string t) {
        unordered_map<char,int>m;
        char ans;
        for(auto x:s){
            m[x]++;
        }
        for(auto x:t){
            if(m[x]>0){
                m[x]--;
            }else{
                ans= x;
            }
        }
        return ans;
    }
};