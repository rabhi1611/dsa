class Solution {
public:
    map<pair<int, int>, list<pair<int, int>>> mp;
    map<pair<int, int>, int> dist;
    
    int minPathSum(vector<vector<int>>& grid) {
        
        for(int i = 0; i < grid.size(); i++){
            for(int j = 0; j < grid[i].size(); j++){
                if(j + 1 < grid[i].size()){
                    mp[{i,j}].push_back({i, j+1});         
                }
                if(i + 1 < grid.size()){
                    mp[{i,j}].push_back({i+1, j});
                }
                dist[{i,j}] = INT_MAX;
            }
        }
        
        pair<int,int> i = {0,0};
        
        set<pair<int, pair<int,int>>> s;
        s.insert({grid[i.first][i.second], i});
        dist[i] = grid[i.first][i.second];
        
        while(s.size() != 0){
            auto t = *(s.begin());
            auto node = t.second;
            s.erase(s.begin());
            for(auto x: mp[node]){
                if(dist[node] + grid[x.first][x.second] < dist[x]){
                    if(s.find({dist[x], x}) != s.end())
                        s.erase(s.find({dist[x], x}));
                    dist[x] = dist[node] + grid[x.first][x.second];
                    s.insert({dist[x], x});
                }
            }
        }
        
        return dist[{grid.size()-1, grid[0].size()-1}];
    }
};