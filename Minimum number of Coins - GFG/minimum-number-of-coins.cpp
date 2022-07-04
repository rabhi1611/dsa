// { Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++

class Solution{
public:
    vector<int> minPartition(int N)
    {
        // code here]
        
        int coins[] = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        
        vector<int> ans;
        
        int j = 9;
        
        while(N){
            while(coins[j] > N){
                j--;
            }
            int t = (N / coins[j]);
            while(t--)  ans.push_back(coins[j]);
            //ans += N / coins[j];
            N = N % coins[j];
        }
        
        return ans;
    }
};

// { Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int N;
        cin>>N;
        
        Solution ob;
        vector<int> numbers = ob.minPartition(N);
        for(auto u: numbers)
            cout<<u<<" ";
        cout<<"\n";
    }
    return 0;
}  // } Driver Code Ends