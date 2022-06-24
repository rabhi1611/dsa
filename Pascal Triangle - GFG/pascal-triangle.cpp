// { Driver Code Starts
#include <bits/stdc++.h>

using namespace std;
#define ll long long

 // } Driver Code Ends
// #define ll long long
class Solution{
public:
    vector<ll> nthRowOfPascalTriangle(int n) {
        // code here
        vector<vector<ll>> ans;
        ans.push_back({1});
        if(n == 1){
            return ans[0];
        }
        ans.push_back({1,1});
        
        if(n == 2){
            return ans[1];
        }
        
        for(int i = 2; i < n; i++){
            vector<ll>temp;
            temp.push_back(1);
            for(int j = 0; j < i - 1; j++){
                temp.push_back((ans[i - 1][j] + ans[i - 1][j + 1]) % 1000000007);
            }
            temp.push_back(1);
            ans.push_back(temp);
        }
        
        return ans[ans.size() - 1];
    }
};


// { Driver Code Starts.


void printAns(vector<ll> &ans) {
    for (auto &x : ans) {
        cout << x << " ";
    }
    cout << "\n";
}

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        Solution ob;
        auto ans = ob.nthRowOfPascalTriangle(n);
        printAns(ans);
    }
    return 0;
}
  // } Driver Code Ends