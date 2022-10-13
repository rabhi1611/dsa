//{ Driver Code Starts
#include<bits/stdc++.h>

using namespace std;


// } Driver Code Ends
class Solution{

    // Function to find the trapped water between the blocks.
    public:
    long long trappingWater(int arr[], int n){
        // code here
        
        int low = 0;
        int high = n - 1;
        
        
        int left = INT_MIN;
        int right = INT_MIN;
        
        long long ans = 0;
        //int i = 0;
        
        while(low < high){
            if(arr[low] <= arr[high]){
                // jb low <= high
                
                if(arr[low] >= left){
                    left = arr[low];
                }else{
                    ans += (left - arr[low]);    
                }
                low++;
            }else{
                // jb low > high
                if(arr[high] >= right){
                    right = arr[high];
                }else{
                    ans += (right - arr[high]);    
                }
                high--;
            }
            //i++;
        }
        
        return ans;
    }
};

//{ Driver Code Starts.

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
}
// } Driver Code Ends