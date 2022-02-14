class Solution {
public:
    vector<string>ans;
    
    void fun(int n, string t, int l_k, int r_k){
        if(l_k == n && r_k == n){
            ans.push_back(t);
            return;
        }
        if(l_k > n){
            return;
        }
        if(r_k > n){
            return;
        }
        if(r_k > l_k){
            return;
        }
        fun(n, t + '(', l_k + 1, r_k);
        fun(n, t + ')', l_k, r_k + 1);
        return;
    }
    
    vector<string> generateParenthesis(int n) {
        fun(n, "", 0, 0);
        return ans;
    }
};