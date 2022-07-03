// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends

bool compare(vector<int>& a, vector<int>& b){
    if(a[2] == b[2]){
        return a[2] < b[2];
    }
    return a[1] < b[1];
}

class Solution
{
    public:
    
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    
    
    
    int maxMeetings(int start[], int end[], int n)
    {
        // Your code here
        vector<vector<int>> v;
        
        for(int i = 0; i < n; i++){
            v.push_back({start[i], end[i], i + 1});
        }
        
        sort(v.begin(), v.end(), compare);
        
        //for(auto x: v){
          //  cout<<x[0]<<" - "<<x[1]<<endl;
        //}
        
        int ans = 1;
        int end_bar = v[0][1];
        
        for(int i = 1; i < n; i++){
            if(v[i][0] > end_bar){
                // mtlb task kiya hai
                ans++;
                end_bar = v[i][1];
            }
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
        int start[n], end[n];
        for (int i = 0; i < n; i++) cin >> start[i];

        for (int i = 0; i < n; i++) cin >> end[i];

        Solution ob;
        int ans = ob.maxMeetings(start, end, n);
        cout << ans << endl;
    }
    return 0;
}  // } Driver Code Ends