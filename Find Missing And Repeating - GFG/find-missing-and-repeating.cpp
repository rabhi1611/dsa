// { Driver Code Starts
#include <bits/stdc++.h>

using namespace std;

 // } Driver Code Ends
class Solution{
public:
    int *findTwoElement(int *arr, int n) {
        // code here
        
        int temp = arr[0];
        
        for(int i = 1; i < n; i++){
            temp = temp ^ arr[i];
        }
        
        for(int i = 1; i <= n; i++){
            temp = temp ^ i;
        }
        
        // x ^ y mil gya
        // now divide into two buckets
        
        int r_m_b = temp & (~(temp - 1));
        
        int b_1 = 0;
        int b_2 = 0;
        
        //cout<<b_1<<" "<<b_2<<endl;
        
        for(int i = 0; i < n; i++){
            if(arr[i] & r_m_b)
                b_1 = b_1 ^ arr[i];
            else
                b_2 = b_2 ^ arr[i];
        }
        
        //cout<<b_1<<" "<<b_2<<endl;
        for(int i = 1; i <= n; i++){
            if(i & r_m_b)
                b_1 = b_1 ^ i;
            else
                b_2 = b_2 ^ i;
        }
        
        //cout<<b_1<<" "<<b_2<<endl;
        
        int *ans = new int[2];
        
        int cnt_b_1 = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == b_1){
                cnt_b_1++;
            }
        }
        if(cnt_b_1 == 2){
            ans[0] = b_1;
            ans[1] = b_2;
        }else{
            ans[0] = b_2;
            ans[1] = b_1;
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
        int a[n];
        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }
        Solution ob;
        auto ans = ob.findTwoElement(a, n);
        cout << ans[0] << " " << ans[1] << "\n";
    }
    return 0;
}  // } Driver Code Ends