class Solution {
public:
    string convert(string s, int numRows) {
        // find m
        int m = 0;
        int i = 0;
        /*while(i < s.size()){
            
            i += numRows;
            m++;
            if((numRows - 2) >= 0){
                i += (numRows - 2);
                m += (numRows - 2);  
            }else{
                m++;
            }
        }*/
        char arr[1001][1001];
        m = 1001;
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = ' ';
            }
        }
        int k = 0;
        i = 0;
        int j = 0;
        while(k < s.size()){
            while(i < numRows){
                if(k >= s.size()){
                    break;
                }
                //cout<<i<<" "<<j<<endl;
                arr[i][j] = s[k];
                k++;
                i++;
            }
            j++;
            i -= 2;
            if(i < 0){
                i = 0;
            }
            if(k >= s.size()){
                break;
            }
            if(j < m && i >= 0){
                while(i > 0){
                    if(k >= s.size()){
                        break;
                    }
                    arr[i][j] = s[k];
                    i--;
                    j++;
                    k++;
                }
            }
        }
        
        string ans = "";
        for(int i = 0; i < numRows;i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] != ' '){
                    ans += arr[i][j];
                }
            }
        }
        
        return ans;
    }
};