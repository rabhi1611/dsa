// { Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++

class Solution{
public:
    vector<int> nextPermutation(int N, vector<int> arr){
        // code here
        bool flag = false;
        int i = N - 1;
        while(i > 0){
            if(arr[i] > arr[i - 1]){
                flag = true;
                break;
            }
            i--;
        }
        
        if(flag == false){
            reverse(arr.begin(), arr.end());
            return arr;
        }
        
        i--;
        // i is flag 1
        int flag2 = N - 1;
        
        while(arr[flag2] <= arr[i]){
            flag2--;
        }
        
        swap(arr[i], arr[flag2]);
        
        reverse(arr.begin() + (i + 1), arr.end());
        return arr;
    }
};

// { Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int N;
        cin>>N;
        vector<int> arr(N);
        for(int i = 0;i < N;i++)
            cin>>arr[i];
        
        Solution ob;
        vector<int> ans = ob.nextPermutation(N, arr);
        for(int u: ans)
            cout<<u<<" ";
        cout<<"\n";
    }
    return 0;
}  // } Driver Code Ends