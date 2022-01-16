// { Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
// User function template for C++

class Solution{
    public:
    vector<string>ans;
    void fun(vector<char>&dir, vector<vector<int>> &m, int& n, vector<vector<int>>& visited, int i, int j){
        if(i==n-1 && j==n-1){
            string s="";
            for(auto x:dir){
                s+=x;
            }
            ans.push_back(s);
            if(dir.size()!=0)
                dir.pop_back();
            visited[i][j]=0;
            return;
        }
        
        if(i+1 < n){
            if(m[i+1][j]==1 && visited[i+1][j]==0){
                visited[i+1][j]=1;
                dir.push_back('D');
                fun(dir,m,n,visited,i+1,j);
            }
        }
        if(i-1 >=0){
            if(m[i-1][j]==1 && visited[i-1][j]==0){
                visited[i-1][j]=1;
                dir.push_back('U');
                fun(dir,m,n,visited,i-1,j);
            }
        }
        if(j+1 < n){
            if(m[i][j+1]==1 && visited[i][j+1]==0){
                visited[i][j+1]=1;
                dir.push_back('R');
                fun(dir,m,n,visited,i,j+1);
            }
        }
        if(j-1 >=0){
            if(m[i][j-1]==1 && visited[i][j-1]==0){
                visited[i][j-1]=1;
                dir.push_back('L');
                fun(dir,m,n,visited,i,j-1);
            }
        }
        if(dir.size()!=0)
            dir.pop_back();
        visited[i][j]=0;
        return;
    }
    
    vector<string> findPath(vector<vector<int>> &m, int n) {
        // Your code goes here
        vector<char>dir;
        vector<vector<int>> visited;
        for(int i=0;i<n;i++){
            vector<int>v;
            for(int j=0;j<n;j++){
                v.push_back(0);
            }
            visited.push_back(v);
        }
        if(m[0][0]==1){
            visited[0][0]=1;
            fun(dir,m,n,visited,0,0);
        }
        return ans;
    }
};

    


// { Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<vector<int>> m(n, vector<int> (n,0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cin >> m[i][j];
            }
        }
        Solution obj;
        vector<string> result = obj.findPath(m, n);
        sort(result.begin(), result.end());
        if (result.size() == 0)
            cout << -1;
        else
            for (int i = 0; i < result.size(); i++) cout << result[i] << " ";
        cout << endl;
    }
    return 0;
}  // } Driver Code Ends