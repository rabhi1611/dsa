class Solution {
public:
    string reorganizeString(string S) {
               unordered_map<char, int> map;
        for(auto c: S)
            map[c]++;
        
        priority_queue<pair<int, char>> q;
        for(auto n: map){
            if(n.second> (S.length()+1)/2) return ""; 
            q.push({n.second, n.first});
        }
        
        string res;
        while(q.size()>= 2){
            auto tmp1= q.top(); q.pop();
            auto tmp2= q.top(); q.pop();
            res.push_back(tmp1.second);
            res.push_back(tmp2.second);
            if(--tmp1.first > 0) q.push(tmp1);
            if(--tmp2.first > 0) q.push(tmp2);
        }
        if(!q.empty())
            res.push_back(q.top().second);
        return res;
    }
};