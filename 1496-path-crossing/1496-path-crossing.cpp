class Solution {
public:
    bool isPathCrossing(string path) {
        int i=0;
        int j=0;
        set<pair<int,int>>s;
        for(auto x:path){
            if(s.count({i,j})>0){
                return true;
            }else{
                s.insert({i,j});
            }
            if(x=='N'){
                i--;
                continue;
            }
           if(x=='S'){
                i++;
                continue;
            }
            if(x=='E'){
                j++;
                continue;
            }
            if(x=='W'){
                j--;
                continue;
            }
        }
        if(s.count({i,j})>0){
                return true;
            }
        return false;
    }
};