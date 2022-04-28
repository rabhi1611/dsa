class Solution {
public:
    
    vector<int> gardenNoAdj(int n, vector<vector<int>>& paths) {
        
        unordered_map<int, list<int>> mp;
        
        for(auto x: paths){
            mp[x[0]].push_back(x[1]);
            mp[x[1]].push_back(x[0]);
        }
        
        vector<int>color(n + 1, 0);
        vector<int>visited(n + 1, 0);
        
        for(int i = 1; i <= n; i++){
            if(visited[i] == 0){
                queue<int> q;

                q.push(i);
                color[i] = 1;


                while(!q.empty()){
                    
                    int size = q.size();
                    while(size--){
                        int node = q.front();
                        q.pop(); 
                        visited[node] = 1;
                        for(auto x: mp[node]){
                            if(color[x] == 0){
                                color[x] = (color[node]) % 4 + 1;
                                q.push(x);
                                continue;
                            }
                            if(color[x] == color[node]){
                                color[x] = (color[x]) % 4 + 1;
                                continue;
                            }
                        }
                    }
                }
                
            }
        }
        vector<int>ans = {color.begin() +  1, color.end()};
        return ans;
    }
};