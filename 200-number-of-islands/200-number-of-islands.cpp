class Solution {
public:
    
    void dfs(map<pair<int,int>,list<pair<int,int>>>&mp, set<pair<int,int>>&visited ,pair<int,int> &cell){
        for(auto x:mp[cell]){
            if(visited.count(x)>0){
                    continue;
            }
            visited.insert(x);
            dfs(mp,visited,x);
        }
    }
    
    
    int numIslands(vector<vector<char>>& grid) {
        map<pair<int,int>,list<pair<int,int>>>mp;
        int n=grid.size();
        int m=grid[0].size();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='0'){
                    continue;
                }
                if(i+1 < n && grid[i+1][j]=='1')
                    mp[{i,j}].push_back({i+1,j});
                if(i-1 >=0 && grid[i-1][j]=='1')
                    mp[{i,j}].push_back({i-1,j});
                if(j+1 < m && grid[i][j+1]=='1')
                    mp[{i,j}].push_back({i,j+1});
                if(j-1 >=0 && grid[i][j-1]=='1')
                    mp[{i,j}].push_back({i,j-1});
            }
        }
        /*
        for(auto x:mp){
            pair<int,int>p=x.first;
            cout<<"("<<p.first<<", "<<p.second<<") => ";
            for(auto y:x.second){
                cout<<"("<<y.first<<", "<<y.second<<"), ";
            }
            cout<<endl;
        }
        */
        // implement dfs
        set<pair<int,int>>visited;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='0'){
                    continue;
                }        
                if(visited.count({i,j})>0){
                    continue;
                }
                ans++;
                pair<int,int>p={i,j};
                visited.insert(p);
                dfs(mp,visited,p);
            }
        }
        
        return ans;
    }
};