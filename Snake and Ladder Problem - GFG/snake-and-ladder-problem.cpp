// { Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++

class Solution{
public:

    int minThrow(int N, int arr[]){
        // code here
        
        int moves[35];
        memset(moves, -1, sizeof(moves));
        
        for(int i = 0; i < 2 * N; i += 2){
            moves[arr[i]] = arr[i + 1];
        }
        
        vector<int>visited(35, 0);
    
        queue<pair<int, int>> q;
        pair<int, int> p;
        
        q.push({1, 0});
        visited[1] = 1;
        
        while(q.size() != 0){
            p = q.front();
            int cell = p.first;
            int turn = p.second;
            
            if(cell == 30){
                break;
            }
            q.pop();
            for(int i = cell + 1; i <= cell + 6 && i <= 30; i++){
                
                pair<int, int> pp;
                if(visited[i] == 0){
                                    
                    pp.second = turn + 1;
                    visited[i] = 1;
                    
                    if(moves[i] != -1){
                        pp.first = moves[i];
                    }
                    else{
                        pp.first = i;
                    }
                    q.push(pp);
                }
            }
        }
        
        return p.second;
    }
};

// { Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int N;
        cin>>N;
        int arr[2*N];
        for(int i = 0;i < 2*N;i++)
            cin>>arr[i];
        
        Solution ob;
        cout<<ob.minThrow(N, arr)<<"\n";
    }
    return 0;
}  // } Driver Code Ends