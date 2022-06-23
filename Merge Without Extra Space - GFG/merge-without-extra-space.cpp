// { Driver Code Starts
#include <bits/stdc++.h> 
using namespace std; 


 // } Driver Code Ends
class Solution{
    public:
        //Function to merge the arrays.
        
        void merge(long long arr1[], long long arr2[], int n, int m) 
        { 
            // code here
            int gap = (n + m) / 2;
            
            if((n + m) % 2 == 1){
                gap++;
            }
            
            while(gap){
                int p1 = 0;
                int p2 = gap;
                
                if(gap < n){
                    while(p2 < n){
                        if(arr1[p1] > arr1[p2]){
                            swap(arr1[p1], arr1[p2]);
                        }
                        p1++;
                        p2++;
                    }
                }
                if(gap >= n)
                    p2 = gap - n;
                else
                    p2 = 0;
                    
                if(p1 < n){
                    while(p2 < m){
                        if(arr1[p1] > arr2[p2]){
                            swap(arr1[p1], arr2[p2]);
                        }
                        p1++;
                        p2++;
                        if(p1 == n){
                            break;
                        }
                    }
                }
                
                if(p1 == n){
                    p1 = 0;
                    while(p2 < m){
                        if(arr2[p1] > arr2[p2]){
                            swap(arr2[p1], arr2[p2]);
                        }
                        p1++;
                        p2++;
                    }
                }
                /*
                for(int i = 0; i < n; i++){
                    cout<<arr1[i]<<" ";
                }
                for(int i = 0; i < m; i++){
                    cout<<arr2[i]<<" ";
                }
                cout<<endl;
                */
                if(gap == 1){
                    break;
                }
                if(gap % 2 == 1){
                    gap = gap / 2;
                    gap++;
                }else{
                    gap = gap / 2;
                }
            }
        } 
};

// { Driver Code Starts.

int main() 
{ 
	
	int T;
	cin >> T;
	
	while(T--){
	    int n, m;
	    cin >> n >> m;
	    
	    long long arr1[n], arr2[m];
	    
	    for(int i = 0;i<n;i++){
	        cin >> arr1[i];
	    }
	    
	    for(int i = 0;i<m;i++){
	        cin >> arr2[i];
	    }
	    Solution ob;
	    ob.merge(arr1, arr2, n, m); 

        for (int i = 0; i < n; i++) 
            cout<<arr1[i]<<" "; 
        
       
	    for (int i = 0; i < m; i++) 
		    cout<<arr2[i]<<" "; 
	    
	    cout<<endl;
	}

	return 0; 
} 
  // } Driver Code Ends