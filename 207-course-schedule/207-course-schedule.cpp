class Solution {
public:
    // solving through the concept of kahn's algo... topological sort
    
    unordered_map<int, list<int>> mp;
    
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        
        for(auto x: prerequisites){
            mp[x[0]].push_back(x[1]);
        }
        
        // create indegree
        vector<int>indegree(numCourses);
        for(auto x: mp){
            for(auto y: x.second){
                indegree[y]++;
            }
        }
        
        queue<int>q;
        int c =0;
        for(int i = 0; i<numCourses; i++){
            if(indegree[i] == 0){
                c++;
                q.push(i);
            }
        }
        
        while(!q.empty()){
            int node = q.front();
            q.pop();
            for(auto x: mp[node]){
                indegree[x]--;
                if(indegree[x] == 0){
                    c++;
                    q.push(x);
                }
            }
        }
        //cout<<c<<" ";
        if(c == numCourses){
            return true;
        }
        return false;
    }
};