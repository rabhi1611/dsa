class Solution {
public:
    bool checkValidString(string s) {
        int l = 0, h = 0;
        for(auto x: s){
            if(x == '('){
                l += 1;
            }else{
                l -= 1;
            }
            if(x != ')'){
                h += 1;
            }else{
                h -= 1;
            }
            
            if(h < 0){
                break;
            }
            l = max(l, 0);
        }
        return l == 0;
    }
};