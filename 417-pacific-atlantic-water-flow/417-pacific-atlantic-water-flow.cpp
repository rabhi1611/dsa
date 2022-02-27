class Solution {
public:
    set<pair<int, int>>s;
    pair<int,int>p;
    void fun(int i, int j, vector<vector<int>>& visited, bool& a_m, bool& p_m, vector<vector<int>>& heights){
        
        
        if(i == 0){
            p_m = true;
        }
        if(j == 0){
            p_m = true;
        }
        if(j == heights[0].size() - 1){
            a_m = true;
        }
        
        if(i == heights.size() - 1){
            a_m = true;
        }
        
        if(a_m && p_m){
            s.insert(p);
            return;
        }
        
        int arr1[] = {0, 1, -1, 0};
        int arr2[] = {1, 0, 0, -1};
        int k = 0;
        while(k < 4){
            if(i + arr1[k] < 0 || j + arr2[k] < 0 ||  i + arr1[k] >= heights.size() || j + arr2[k] >= heights[0].size() || heights[i + arr1[k]][j + arr2[k]] > heights[i][j]){
                k++;
                continue;
            }
            //cout<<(i + arr1[k]) <<" "<<j + arr2[k]<<endl;
            if(visited[i + arr1[k]][j + arr2[k]] == 0){
                visited[i + arr1[k]][j + arr2[k]] = 1;
                fun(i + arr1[k], j + arr2[k], visited, a_m, p_m, heights);
                visited[i + arr1[k]][j + arr2[k]] = 0;
            }
            k++;
        }
    }
    
    
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        vector<vector<int>>visited(heights.size(), vector<int>(heights[0].size(), 0));
        
        for(int i = 0; i < heights.size(); i++){
            for(int j = 0; j < heights[i].size(); j++){
                visited[i][j] = 1;
                p = {i, j};
                bool a_m = false, p_m = false;
                fun(i, j, visited, a_m , p_m, heights);
                visited[i][j] = 0;
            }
        }
        
        vector<vector<int>> ans;
        for(auto x: s){
            ans.push_back({x.first, x.second});
        }
        return ans;
    }
};