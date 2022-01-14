class Solution {
public:
    int twoCitySchedCost(vector<vector<int>>& costs) {
        int n=costs.size();
        priority_queue<pair<int,int>>pq;
        int person=1;
        for(auto x: costs){
            pq.push({abs(x[0]-x[1]),person});
            person++;
        }
        int sum=0;
        int city_a=0;
        int city_b=0;
        while(pq.size()!=0){
            pair<int,int>p=pq.top();
            int a=costs[p.second-1][0];
            int b=costs[p.second-1][1];
            
            if(a>=b){
                if(city_b<(n/2)){
                    sum+=(b);
                    city_b++;
                }else{
                    sum+=(a);
                    city_a++;
                }
            }else{
                if(city_a<(n/2)){
                    sum+=(a);
                    city_a++;
                }else{
                    sum+=(b);
                    city_b++;
                }
            }
            pq.pop();
        }
        return sum;
    }
};