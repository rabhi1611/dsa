class Solution {
public:
    string removeDuplicateLetters(string s) {
        
        int count[26]={0};
        int visited[26]={0};
        int n=s.length();
        
        
        for(int i=0;i<n;i++){
            count[s[i]-'a']++;
        }
        string res="";
        for(int i=0;i<n;i++){
            
            count[s[i]-'a']--;
            
            if(!visited[s[i]-'a']){
                
                while(res.length()>0 && res.back()>s[i] && count[res.back()-'a']>0){
                    
                    visited[res.back()-'a']=0;
                    res.pop_back();
                }
                
                res+=s[i];
                visited[s[i]-'a']=1;
            }
        }
        return res;
    }
};