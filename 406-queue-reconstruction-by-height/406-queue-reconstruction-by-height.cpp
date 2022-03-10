

class Solution {
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        int N = people.size();
        vector<vector<int>> ans(N);
        vector<bool> filled(N, false);
        
        sort(people.begin(), people.end(), [](const vector<int>& a, const vector<int>& b){return (a[0] == b[0]) ? (a[1] < b[1]) : (a[0] < b[0]);});
        
        for(int i = 0; i < N; i++){
            int value =  people[i][0], largerCount = people[i][1];
        
            int pos, j;
            for(pos = 0, j = 0; j <= largerCount; pos++){
                if(!filled[pos] || (filled[pos] && ans[pos][0] >= value))
                    j++;

            }
            pos--;
            
           
            ans[pos] = people[i];
            filled[pos] = true;
        }
        
        return ans;
    }
};

