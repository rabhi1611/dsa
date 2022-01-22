class Solution {
public:
    bool canMakeArithmeticProgression(vector<int>& arr) {
        sort(arr.begin(),arr.end());
        int i=0;
        int j=1;
        int diff=abs(arr[i]-arr[j]);
        while(j<arr.size()){
            if(abs(arr[i]-arr[j])!=diff){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
};