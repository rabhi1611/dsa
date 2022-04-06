class Solution {
public:
    
    
    
    int threeSumMulti(vector<int>& arr, int target) {
        
        long ans = 0;
        int MOD = 1000000007;
        sort(arr.begin(), arr.end());
        for(int i = 0; i < arr.size(); i++){
            int j = i + 1;
            int k = arr.size() - 1;
            
            while(j < k){
                if(arr[j] + arr[k] < (target - arr[i])){
                    j++;
                }
                else if(arr[j] + arr[k] > (target - arr[i])){
                    k--;
                }
                else if(arr[j] != arr[k]){
                    int l = 1, r = 1;
                    while(j + 1 < k && arr[j] == arr[j + 1]){
                        l++;
                        j++;
                    }

                    while(k - 1 > j && arr[k] == arr[k - 1]){
                        r++;
                        k--;
                    }

                    ans += l * r;
                    ans %= MOD;
                    j++;
                    k--;
                }
                else{
                    ans += (k - j + 1) * (k - j) / 2;
                    ans %= MOD;
                    break;
                }
            }
        }
        
        return (int)ans;
    }
};