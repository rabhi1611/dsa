class Solution {
public:
    string longestPalindrome(string s) {
        int n=s.size();
        int s_i=-1;
        int e_i=-1;
        int max_len=0;
        for(int i=0;i<n;i++){
            int l=i;
            int r=i;
            while(1){
                if(s[l]!=s[r]){
                    l++;
                    r--;
                    if(max_len< (r-l+1)){
                        max_len=(r-l+1);
                        s_i=l;
                        e_i=r;
                    }
                    break;
                }
                if(l-1<0){
                    if(max_len< (r-l+1)){
                        max_len=(r-l+1);
                        s_i=l;
                        e_i=r;
                    }
                    break;
                }
                if(r+1>=n){
                    if(max_len< (r-l+1)){
                        max_len=(r-l+1);
                        s_i=l;
                        e_i=r;
                    }
                    break;
                }
                l--;
                r++;
            }
        }
        
        for(int i=0;i<n-1;i++){
            int l=i;
            int r=i+1;
            while(1){
                if(s[l]!=s[r]){
                    l++;
                    r--;
                    if(l>r){
                        break;
                    }
                    if(max_len< (r-l+1)){
                        max_len=(r-l+1);
                        s_i=l;
                        e_i=r;
                    }
                    break;
                }
                if(l-1<0){
                    if(max_len< (r-l+1)){
                        max_len=(r-l+1);
                        s_i=l;
                        e_i=r;
                    }
                    break;
                }
                if(r+1>=n){
                    if(max_len< (r-l+1)){
                        max_len=(r-l+1);
                        s_i=l;
                        e_i=r;
                    }
                    break;
                }
                l--;
                r++;
            }
        }
        string result="";
        for(int i=s_i;i<=e_i;i++){
            result+=s[i];
        }
        return result;
    }
};