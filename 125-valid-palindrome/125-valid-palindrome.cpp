class Solution {
public:
    bool isPalindrome(string s) {
        string temp ="";
        for(auto x: s){
            if(x >= 65 && x <= 90){
                temp += (x+32);
            }
            else if(x >= 97 && x <= 122){
                temp += x;
            }else if(x >= 48 && x <=57){
                temp += x;
            }else{
                continue;
            }
        }
        
        int i = 0;
        int j = temp.size() - 1;
        while(i < j){
            if(temp[i] != temp[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
};