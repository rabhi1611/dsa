class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        
        unordered_set<int> st;
        
        for(auto x: nums){
            st.insert(x);
        }
        
        int len = 0;
        
        for(auto x: nums){
            if(st.count(x - 1) > 0){
                continue;
            }
            
            // means this is head
            int t_len = 1;
            int t_bar = x;
            while(st.count(t_bar + 1) > 0){
                t_len++;
                t_bar++;
            }
            len = max(len, t_len);
        }
        
        return len;
    }
};