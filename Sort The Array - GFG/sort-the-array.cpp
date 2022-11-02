//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
    public:
    
    void merge(vector<int>&arr, int s, int mid, int e){
        
        int i = s;
        int j = mid + 1;
        
        int n_arr[e - s + 1] = {};
        int k = 0;
        
        while(i <= mid && j <= e){
            if(arr[i] <= arr[j]){
                n_arr[k++] = arr[i++];
            }else{
                n_arr[k++] = arr[j++];
            }
        }
        
        while(i <= mid){
            n_arr[k++] = arr[i++];
        }
        
        while(j <= e){
            n_arr[k++] = arr[j++];
        }
        
       // for(int x = 0; x < k; x++){
          //  cout << n_arr[x] << " ";
      //  }
        
        int t = 0;
        
        for(int x = s; x <= e; x++){
            arr[x] = n_arr[t++];    
        }
        //cout << endl;
        
        return;
    }
    
    
    void m_sort(vector<int>& arr, int s, int e){
        if(s >= e){
            return;
        }
        
        int mid = (s + e) / 2;
        
        m_sort(arr, s, mid);
        m_sort(arr, mid + 1, e);
        
        merge(arr, s, mid, e);
    }
    
    vector<int> sortArr(vector<int>arr, int n){
    //complete the function here
    
        m_sort(arr, 0, n - 1);
        return arr;
    }
};

//{ Driver Code Starts.
int main(){
    
    int t;
    cin >> t;
    while(t--){
        int n;
        cin >> n;
        vector<int>s(n);
        for(int i = 0; i < n; i++)
            cin >> s[i];
        Solution ob;
        vector<int>v = ob.sortArr(s, n);
        for(auto i : v)
            cout << i << ' ';
        cout << endl;
    }
return 0;
}


// } Driver Code Ends