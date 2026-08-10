class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string ans="";
        string first_string=strs[0];
        int j=0;
        while(j<first_string.size()){
            int flag=0;
            for(int i=1;i<strs.size();i++){
                if(j>=strs[i].size() || j>=first_string.size()){
                    flag=1;
                    break;
                }
                if(strs[i][j]!=first_string[j]){
                    flag=1;
                    break;
                }
            }
            if(flag==1){
                break;
            }
            ans+=first_string[j];
            j++;
        }
        return ans;
    }
};