class Solution {
public:
    
    vector<vector<string>> ans;
    
    bool is_p(string temp){
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
    
    void fun(string s, vector<string>& choice){
        
        if(s.size() == 0){
            ans.push_back(choice);
            return;
        }
        
        string temp = "";
        
        for(int i = 0; i < s.length(); i++){
            temp += s[i];
            if(is_p(temp)){
                choice.push_back(temp);
                fun(s.substr(i + 1), choice);
                choice.pop_back();
            }
        }
        
        return;
    }
    
    vector<vector<string>> partition(string s) {
        vector<string> choice;
        fun(s, choice);
        return ans;
    }
};