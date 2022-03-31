struct comp
{
    bool operator()(vector<int> &a, vector<int> &b)
    {
        return a[1]>b[1];
    }
};
class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        vector<vector<pair<int, int>>> adj(n);
        
        for (int i=0; i<flights.size(); i++)
        {
            adj[flights[i][0]].push_back(pair<int, int>(flights[i][1], flights[i][2]));
        }
        
        vector<int> distances(n, INT_MAX);
        vector<int> stops(n, INT_MAX);
        
        distances[src] = 0;
        stops[src] = 0;
        priority_queue<vector<int>, vector<vector<int>>, comp> q;
        
        q.push({src, 0, 0});
        
        while (!q.empty())
        {
            vector<int> cur = q.top();
            q.pop();
            
            int currNode = cur[0], currPrice = cur[1], currStop = cur[2];
            if (currNode == (dst))
                return currPrice;
            if (currStop == k+1)
                continue;
            
            for (auto neib: adj[currNode])
            {
                if (currPrice + neib.second < distances[neib.first])
                {
                    distances[neib.first] = currPrice + neib.second;
                    stops[neib.first] = currStop + 1;
                    q.push({neib.first, currPrice + neib.second, currStop + 1});
                }
                
                else if (currStop + 1 < stops[neib.first])
                {
                    distances[neib.first] = currPrice + neib.second;
                    stops[neib.first] = currStop + 1;
                    q.push({neib.first, currPrice + neib.second, currStop + 1});
                    
                }
            }
        }
        return -1;
    }
};