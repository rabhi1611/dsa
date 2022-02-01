class Solution {
public:
    map<string,bool>mp;
    bool contain(string t, vector<string>& wordDict){
        for(int i=0;i<wordDict.size();i++){
            if(wordDict[i] == t){
                return true;
            }
        }
        return false;
    }
    bool ans =false;
    void fun(string s, vector<string>& wordDic){
        if(s.size()==0){
            ans = true;
            return;
        }
        string temp="";
        int i=0;
        do{
            temp+=s[i];
            if(contain(temp, wordDic)){
                if(mp.count(s.substr(i+1, s.size())) > 0){
                    
                }else
                    fun(s.substr(i+1, s.size()), wordDic);
                mp[s.substr(i+1, s.size())]=false;
                
            }
            i++;
        }while(i<s.size());
        return;
    }
    
    
    bool wordBreak(string s, vector<string>& wordDict) {
        fun(s, wordDict);
        return ans;
    }
};