class Solution {
public:
    
    long long ans = 0;
    
    void merge(long long arr[], long long s, long long mid, long long e){
        
        long long i = s;
        long long j = mid + 1;
        long long k = 0;
        
        
        while(i <= mid && j <= e){
            if(arr[i] > 2 * arr[j]){
                ans += (mid - i + 1);
                j++;
            }
            else{
                i++;
            }
        }
        
        sort(arr + s, arr + e + 1);
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
        return;
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
    
    
    int reversePairs(vector<int>& nums) {
        long long arr[50001] = {};
        long long n = nums.size();
        
        for(long long i = 0; i < nums.size(); i++){
            arr[i] = nums[i];
        }
        long long ans = inversionCount(arr, n);
        
        /*
        for(long long i = 0; i < nums.size(); i++){
            cout << arr[i] << " ";
        }
        cout<<endl;
        */
        return (long long)ans;
    }
};