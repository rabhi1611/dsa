class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        
        vector<int> visited(rooms.size(), 0);
        queue<int> q;
        q.push(0);
        visited[0]  = 1;
        
        while(!q.empty()){
            int node = q.front();
            q.pop();
            
            for(auto x: rooms[node]){
                if(visited[x] == 0){
                    visited[x] = 1;
                    q.push(x);
                }
            }
        }
        
        for(auto x: visited){
            if(x == 0){
                return false;
            }    
        }
        return true;
    }
};