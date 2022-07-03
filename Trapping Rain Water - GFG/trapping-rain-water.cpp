// { Driver Code Starts
#include<bits/stdc++.h>

using namespace std;


 // } Driver Code Ends
class Solution{

    // Function to find the trapped water between the blocks.
    public:
    long long trappingWater(int arr[], int n){
        // code here
        
        
        long long ans = 0;
        
        long long pref[n - 1] = {};
        long long suff[n - 1] = {};
        
        long long sum = 0;
        
        for(int i = 0; i < n; i++){
            pref[i] = sum;
            sum = max(sum, (long long)arr[i]);
        }
        
        sum = 0;
        
        for(int i = n - 1; i >= 0; i--){
            suff[i] = sum;
            sum = max(sum, (long long)arr[i]);
        }
        
        for(int i = 0 ; i < n ; i++){
            if(min(pref[i], suff[i]) - arr[i] > 0)
                ans += min(pref[i], suff[i]) - arr[i];
        }
        
        return ans;
    }
};

// { Driver Code Starts.

int main(){
    
    int t;
    //testcases
    cin >> t;
    
    while(t--){
        int n;
        
        //size of array
        cin >> n;
        
        int a[n];
        
        //adding elements to the array
        for(int i =0;i<n;i++){
            cin >> a[i];            
        }
        Solution obj;
        //calling trappingWater() function
        cout << obj.trappingWater(a, n) << endl;
        
    }
    
    return 0;
}  // } Driver Code Ends