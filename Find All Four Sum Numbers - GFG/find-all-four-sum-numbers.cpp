// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
// User function template for C++

class Solution{
    public:
    // arr[] : int input array of integers
    // k : the quadruple sum required
    vector<vector<int> > fourSum(vector<int> &arr, int k) {
        // Your code goes here
        
        vector<vector<int>> ans;
        
        if(arr.size() <= 3){
            return ans;
        }
        
        sort(arr.begin(), arr.end());

        int i = 0;
        
        do{
            int j = i + 1;
            do{
                int left = j + 1;
                int right = arr.size() - 1;
                
                while(left < right){
                    if((arr[i] + arr[j] + arr[left] + arr[right]) < k){
                        left++;
                    }else if((arr[i] + arr[j] + arr[left] + arr[right]) > k){
                        right--;
                    }else{
                        ans.push_back({arr[i], arr[j], arr[left], arr[right]});
                        while(right > left && arr[right - 1] == arr[right]) right--;
                        while(left < right && arr[left + 1] == arr[left])   left++;
                        left++;
                        right--;
                    }
                }
                
                while(j + 1 < arr.size() && arr[j + 1] == arr[j])   j++;
                j++;
            }while(j < arr.size());
            
            while(i + 1 < arr.size() && arr[i + 1] == arr[i])   i++;
            i++;
        }while(i < arr.size());
        
        return ans;
    }
};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, k, i;
        cin >> n >> k;
        vector<int> a(n);
        for (i = 0; i < n; i++) {
            cin >> a[i];
        }
        Solution ob;
        vector<vector<int> > ans = ob.fourSum(a, k);
        for (auto &v : ans) {
            for (int &u : v) {
                cout << u << " ";
            }
            cout << "$";
        }
        if (ans.empty()) {
            cout << -1;
        }
        cout << "\n";
    }
    return 0;
}  // } Driver Code Ends