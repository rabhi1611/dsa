class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) {
        if(s.length() < 10){
            return {};
        }
        
        map<list<char>, int> mp;
        
        list<char> l;
        
        for(int i = 0; i < 10; i++){
            l.push_back(s[i]);
        }
        
        mp[l]++;
        
        for(int i = 10; i < s.length(); i++){
            l.pop_front();
            l.push_back(s[i]);
            mp[l]++;
        }
        
        vector<string>ans;
        
        for(auto x: mp){
            if(x.second > 1){
                string temp = "";
                for(auto y: x.first){
                    temp += y;
                }
                ans.push_back(temp);
            }
        }
        return ans;
    }
};