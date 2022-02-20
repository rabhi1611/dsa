class Solution {
public:
    int myAtoi(string s) {
        int i = 0;
        
        while(i < s.size() && s[i] == ' '){
            i++;
        }
        if(i >= s.size()){
            return 0;
        }
        int sign = 1;
        if(!(s[i] >= '0' && s[i] <= '9')){
            if(s[i] == '-'){
                i++;
                sign = -1;
                if(s[i] == '-' || s[i] == '+'){
                    //cout<<"0";
                    return 0;
                }
            }
            else if(s[i] == '+'){
                i++;
                sign = 1;
                if(s[i] == '-' || s[i] == '+'){
                    //cout<<"0";
                    return 0;
                }
            }
            else{
                //cout<<"0";
                return 0;
            }
        }
        //cout<<s.substr(i)<<endl;
        if(i >= s.size()){
            return 0;
        }
        string temp = "";
        while(s[i] >= '0' && s[i] <= '9'){
          //  cout<<s[i]<<" ";
            temp += s[i];
            i++;
        }      
        int j = 0;
        cout<<temp<<endl;
        string result = temp;
        while(j < temp.size()){
            if(temp[j] == '0'){
                result = temp.substr(j+1);
            }else{
                break;
            }
            j++;
        }
        if(result.size() > 10){
            if(sign == -1){
                return -2147483648;
            }
            if(sign == 1){
                return 2147483647;
            }
        }
        cout<<result;
        if(result.size() == 0){
            return 0;
        }
        long long re = stoll(result);
        if(sign == -1){
            re = re * -1;
        }
        if( re > 2147483647){
            return 2147483647;
        }
        if( re < -2147483648){
            return -2147483648;
        }
        int l = (int)re;
        return l;
        
        //return 1;
    }
};