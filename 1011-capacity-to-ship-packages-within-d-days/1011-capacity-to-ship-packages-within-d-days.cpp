class Solution {
public:
    int shipWithinDays(vector<int>& weights, int days) {
        int limit = 0;
        for(auto x: weights){
            limit += x;
        }
        
        int s = 0;
        int e = limit;
        
        int ans = limit;
        
        while(s <= e){
            // abhi mid maximum weight hai ship ka
            int mid = (s + e) / 2;
            cout<<mid<<" ";
            int i = 0;
            int j = 0;
            int s_l = mid;
            for(i = 1; i <= days; i++){
                while(1){
                    if(j >= weights.size()){
                        break;
                    }
                    if(s_l - weights[j] >= 0){
                        s_l -= weights[j];
                        j++;
                    }else{
                        s_l = mid;
                        break;
                    }
                }
            }
            cout<<i<<" "<<j<<endl;
            //if(mid < 0){
              //  break;
            //}
            if(j >= weights.size()){
                ans = mid;
                e = mid - 1;    
            }else{
                s = mid + 1;       
            }
        }
        return ans;
    }
};