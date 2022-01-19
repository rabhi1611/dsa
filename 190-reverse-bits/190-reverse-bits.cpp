class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        string temp="";
        while(n){
            if(n&1){
                temp+='1';
            }else{
                temp+='0';
            }
            n=n>>1;
        }
        while(temp.size()<32){
            temp+='0';
        }
        //cout<<temp;
        uint32_t t=0;
        uint32_t k=1;
        for(int i=temp.size()-1;i>=0;i--){
            if(temp[i]=='1'){
                t+=k;
            }
            k=k*2;
        }
        return t;
    }
};