class Solution {
public:
    int lengthOfLastWord(string s) {
        string temp = "";
        bool char_aaya = false;
        for(int i = s.size()-1 ; i>=0; i--){
            if(char_aaya == false && s[i]==' '){
                continue;
            }
            char_aaya = true;
            temp += s[i];
        }
        int c = 0;
        reverse(temp.begin(), temp.end());
        for(auto x: temp){
            if(x == ' '){
                c = 0;
                continue;
            }
            c++;
        }
        
        return c;
    }
};