class Solution {
public:
    bool validPalindrome(string s) {
        int i = 0;
        int j = s.size() - 1;
        int c = 0;
        while(i <= j){
            if(s[i] != s[j]){
                if(c == 1){
                    break;
                }else{
                    j--;
                    c = 1;
                }
            }else{
                i++;
                j--;
            }
        }
        
        if(i > j){
            return true;
        }
        
        i = 0, j = s.size() - 1, c = 0;
        
        while(i <= j){
            if(s[i] != s[j]){
                if(c == 1){
                    break;
                }else{
                    i++;
                    c = 1;
                }
            }else{
                i++;
                j--;
            }
        }
        
        if(i > j){
            return true;
        }
        return false;
    }
};