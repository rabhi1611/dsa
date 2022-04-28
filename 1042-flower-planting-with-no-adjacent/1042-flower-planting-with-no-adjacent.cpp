class Solution {
public:
    
    vector<int> colorGraph(int n, unordered_map<int, list<int>>& g) {
        // -1 indicates uncolored
        vector<int> color(n, -1);
        for(int i = 0; i < n; i++) {
            // To track the colors used by neigbors
            vector<bool> color_used(4, false);
            // mark all used colors
            for(const auto& v: g[i])
                if(color[v] != -1)
                    color_used[color[v]-1] = true;
            // look for the unused color
            for(int c = 0; c < 4; c++)
                if(color_used[c] == false) {
                    color[i] = c + 1;
                    break;
                }
        }
        return color;
    }
    vector<int> gardenNoAdj(int n, vector<vector<int>>& paths) {
        
        unordered_map<int, list<int>> mp;
        
        for(auto x: paths){
            mp[x[0] - 1].push_back(x[1] - 1);
            mp[x[1] - 1].push_back(x[0] - 1);
        }
        
        return colorGraph(n, mp);
    }
};