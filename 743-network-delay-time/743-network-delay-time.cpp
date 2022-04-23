class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        
        unordered_map<int, list<pair<int, int>>> mp;
        
        for(auto x: times){
            mp[x[0]].push_back({x[1], x[2]});
        }
        
        int dist[101] = {};
        
        
        
        for(int i = 1; i <= n; i++){
            dist[i] = 100000;
            //cout<<i<<" - > "<<dist[i]<<endl;
        }
        
        //cout<<endl;
        
        dist[k] = 0;
        
        priority_queue<pair<int, int>> pq;
        pq.push({dist[k], k});
        
        while(pq.size() != 0){
            pair<int, int> p = pq.top();
            pq.pop();    
            int node = p.second;
            int d = p.first;
            
            for(auto x: mp[node]){
                if(d + x.second < dist[x.first]){
                    dist[x.first] = d + x.second;
                    pq.push({dist[x.first], x.first});
                }
            }
        }
        
       
        
        int ans = -1;
        
        for(int i = 1; i <= n; i++){
            //cout<<dist[i]<<" ";
            
            if(dist[i] == 100000){
                return -1;
            }
            
            if(i == k){
                continue;
            }
            
            ans = max(ans, dist[i]);
        }
        
        return ans;
    }
};