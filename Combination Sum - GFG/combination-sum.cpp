// { Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function template for C++

class Solution {
  public:
  
    vector<vector<int>> ans;
    
    void fun(vector<int>& bucket, vector<int>& arr, int target, int idx){
        
        if(target < 0){
            return;
        }
        
        if(target == 0){
            ans.push_back(bucket);
            return;
        }
        
        if(idx >= arr.size()){
            return;
        }
        
        while(idx < arr.size() - 1 && arr[idx] == arr[idx + 1]){
            idx++;
        }
        bucket.push_back(arr[idx]);
        fun(bucket, arr, target - arr[idx], idx);
        bucket.pop_back();
        fun(bucket, arr, target, idx + 1);
        return;
    } 
  
    //Function to return a list of indexes denoting the required 
    //combinations whose sum is equal to given number.
    vector<vector<int> > combinationSum(vector<int> &A, int B) {
        // Your code here
        sort(A.begin(), A.end());
        int idx = 0;
        vector<int> bucket;
        fun(bucket, A, B, idx);
        return ans;
    }
};

// { Driver Code Starts.
int main(){
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        vector<int> A;
        for(int i=0;i<n;i++){
            int x;
            cin>>x;
            A.push_back(x);
        }   
        int sum;
        cin>>sum;
        Solution ob;
        vector<vector<int>> result = ob.combinationSum(A, sum);
   		if(result.size()==0){
   			cout<<"Empty";
   		}
        for(int i=0;i<result.size();i++){
            cout<<'(';
            for(int j=0;j<result[i].size();j++){
                cout<<result[i][j];
                if(j<result[i].size()-1)
                    cout<<" ";
            }
            cout<<")";
        }
        cout<<"\n";
    }
}	  // } Driver Code Ends