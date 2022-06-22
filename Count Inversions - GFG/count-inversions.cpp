// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution{
  public:
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    long long ans = 0;
    
    void merge(long long arr[], long long s, long long mid, long long e){
        long long i = s;
        long long j = mid + 1;
        long long k = 0;
        
        long long t_arr[e - s + 1] = {};
        
        while(i <= mid && j <= e){
            if(arr[i] <= arr[j]){
                t_arr[k++] = arr[i++];
            }
            else{
                ans += (mid - i + 1); 
                t_arr[k++] = arr[j++];
            }
        }
        
        while(i <= mid){
            t_arr[k++] = arr[i++];
        }
        
        while(j <= e){
            t_arr[k++] = arr[j++];
        }
        k = 0;
        for(long long i = s; i <= e; i++){
            arr[i] = t_arr[k++];
        }
        return;
    }
    
    
    void mergeSort(long long arr[], long long s, long long e){
        if(s >= e){
            return;
        }
        
        long long mid = (s + e) / 2;
        //cout<<s<<"- "<<e<<" -"<<mid<<endl;
        mergeSort(arr, s, mid);
        mergeSort(arr, mid + 1, e);
        
        merge(arr, s, mid , e);
        //for(int i = s; i <= e; i++){
          //  cout<<arr[i]<<" ";
        //}
        //cout<<endl;
    }
    
    long long int inversionCount(long long arr[], long long N)
    {
        // Your Code Here
        long long s = 0;
        long long e = N - 1;
        //for(int i = 0; i < N; i++){
          //  cout<<arr[i]<<" ";
        //}
        //cout<<endl;
        mergeSort(arr, s, e);
        
        return ans;
    }

};

// { Driver Code Starts.

int main() {
    
    long long T;
    cin >> T;
    
    while(T--){
        long long N;
        cin >> N;
        
        long long A[N];
        for(long long i = 0;i<N;i++){
            cin >> A[i];
        }
        Solution obj;
        cout << obj.inversionCount(A,N) << endl;
    }
    
    return 0;
}
  // } Driver Code Ends