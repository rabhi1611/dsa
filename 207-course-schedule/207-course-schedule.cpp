class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        int plen = prerequisites.size();
        vector<int> ind(numCourses,0); //indegree vector
        
        //construct map & get indegree of each vertex
        vector<vector<bool> > map(numCourses, vector<bool>(numCourses, false));
        for (int i=0;i<plen;i++){
            //Important: in case of duplicates in prerequisites, only +1 indegree 
            if (map[prerequisites[i][0]][prerequisites[i][1]] == false){
                map[prerequisites[i][0]][prerequisites[i][1]] = true;
                ind[prerequisites[i][0]]++;
            }
        }
        
        //BFS
        stack<int> st;
        for (int i=0;i<numCourses;i++){
            if (ind[i]==0) st.push(i);
        }
        
        int count = 0;  // to get the bool result
        
        while (!st.empty()){
            int tmp = st.top();
            st.pop();
            count ++;
            for (int i=0;i<numCourses;i++){
                if (map[i][tmp]){
                    ind[i]--;
                    if (ind[i]==0) st.push(i);
                }
            }
        }
        return count < numCourses ? false : true;
    }
};