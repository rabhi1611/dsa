class Solution {
public:
    int nextGreaterElement(int n) {
        vector<int>v;
        int t = n;
        while(n){
            v.push_back(n % 10);
            n = n / 10;
        }
        reverse(v.begin(), v.end());
        next_permutation(v.begin(), v.end());
        
        int ans = 0;
        int i = v.size() - 1;
        int j = 0;
        while(i >= 0){
            if(ans + (v[j] * (pow(10, i))) > INT_MAX){
                return -1;
            }
            ans += (v[j] * (pow(10, i))); 
            j++;
            i--;
        }
        if(ans <= t){
            return -1;
        }
        return ans;
    }
};