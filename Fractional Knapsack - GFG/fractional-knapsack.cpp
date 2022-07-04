// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

struct Item{
    int value;
    int weight;
};


 // } Driver Code Ends
//class implemented
/*
struct Item{
    int value;
    int weight;
};
*/

bool compare(Item &a, Item &b){
    return (double(a.value) / a.weight) > (double(b.value) / b.weight);
}


class Solution
{
    public:
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n)
    {
        // Your code here
        sort(arr, arr + n, compare);
        double ans = 0;
        
        if(arr[0].weight <= W){
            ans += arr[0].value;
            W -= arr[0].weight;
            //cout<<arr[0].weight<<" ";
        }else{
            ans += ((double)arr[0].value / arr[0].weight) * W;
            return ans;
        }
        for(int i = 1; i < n; i++){
            if(arr[i].weight > W){
                ans += ((double)arr[i].value / arr[i].weight) * W;
                return ans;
            }
            ans += arr[i].value;
            W -= arr[i].weight;
            //cout<<arr[i].weight<<" ";
        }
        return ans;
    }
        
};


// { Driver Code Starts.
int main()
{
	int t;
	//taking testcases
	cin>>t;
	cout<<setprecision(2)<<fixed;
	while(t--){
	    //size of array and weight
		int n, W;
		cin>>n>>W;
		
		Item arr[n];
		//value and weight of each item
		for(int i=0;i<n;i++){
			cin>>arr[i].value>>arr[i].weight;
		}
		
		//function call
		Solution ob;
		cout<<ob.fractionalKnapsack(W, arr, n)<<endl;
	}
    return 0;
}  // } Driver Code Ends