class Solution {
public:
    vector<string> ans;
    void fun(string temp, string s, int dot){
        if(s.size() == 0){
            if(dot == 4){
                ans.push_back(temp.substr(1));   
            }
            return;
        }
        
        // base case 
        temp += '.';
        dot++;
        
        string t="";
        for(auto x: s){
            t += x;
            if(t[0] == '0' && t.size() > 1){
                break;
            }
            if(t.size() > 3){
                break;
            }
            if(!(stoi(t) >= 0 && stoi(t) <= 255)){
                break;
            }
            fun(temp + t, s.substr(t.size()), dot);
        }
        
        
        return;
    }
    vector<string> restoreIpAddresses(string s) {
        fun("", s, 0);
        return ans;
    }
};