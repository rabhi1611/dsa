class Solution {
public:
    unordered_map<int, list<int>>mp;
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int>indegree(numCourses);
        
        for(auto x: prerequisites){
            mp[x[0]].push_back(x[1]);
            indegree[x[1]]++;
        }
        
       
        vector<int>ans;
        queue<int>q;
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                ans.push_back(i);
                q.push(i);
            }
        }
        
        
        while(q.size() != 0){
            int book = q.front();
            q.pop();
            //indegree[book]--;
            for(auto x: mp[book]){
                indegree[x]--;
                if(indegree[x] == 0){
                    ans.push_back(x);
                    q.push(x);
                }
            }
        }
        if(ans.size() != numCourses){
            ans.clear();
            return ans;
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};