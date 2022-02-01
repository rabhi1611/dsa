class Solution {
public:
    vector<string>v{"", "" , "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    vector<string> letterCombinations(string digits) {
        vector<string>ans;
        if(digits.size()==0){
            return ans;
        }
        string temp1=v[digits[0]-48];
        for(auto x:temp1){
            string t="";
            t+=x;
            ans.push_back(t);
        }
        
        for(int i=1;i<digits.size();i++){
            vector<string>tem;
            int idx=digits[i]-48;
            string temp2=v[idx];
            int j=0;
            while(j<ans.size()){
                for(auto x:temp2){
                    string t="";
                    t+=ans[j];
                    t+=x;
                    tem.push_back(t);
                }
                j++;
            }
            ans=tem;
        }
        
        return ans;
    }
};