class Solution {
public:
    int balancedStringSplit(string s) {
        int l=0,r=0,c=0;
        for(auto x:s){
            if(x=='R'){
                r++;
            }else{
                l++;
            }
            if(l==r){
                c++;
                l=0;
                r=0;
            }
        }
        return c;
    }
};