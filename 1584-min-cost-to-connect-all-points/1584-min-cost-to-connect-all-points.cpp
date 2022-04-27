class UnionFind {
public:
    vector<int> group;
    vector<int> rank;

    UnionFind(int size) {
        group = vector<int>(size);
        rank = vector<int>(size);
        for (int i = 0; i < size; ++i) {
            group[i] = i;
        }
    }

    int find(int node) {
        if (group[node] != node) {
            group[node] = find(group[node]);
        }
        return group[node];
    }

    bool join(int node1, int node2) {
        int group1 = find(node1);
        int group2 = find(node2);
        
        // node1 and node2 already belong to same group.
        if (group1 == group2) {
            return false;
        }

        if (rank[group1] > rank[group2]) {
            group[group2] = group1;
        } else if (rank[group1] < rank[group2]) {
            group[group1] = group2;
        } else {
            group[group1] = group2;
            rank[group2] += 1;
        }

        return true;
    }
};




class Solution {
public:

    int minCostConnectPoints(vector<vector<int>>& points) {
        
        int n = points.size();
        
        vector<pair<int, pair<int, int>>> edges;
        
        for(int i = 0; i < points.size(); i++){
            for(int j = i + 1; j < points.size(); j++){
                
                int wt = abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1]);
                edges.push_back({wt, {i, j}});
            }
        }
        
        sort(edges.begin(), edges.end());
        UnionFind uf(n);
        int ans = 0;
        int edge_used = 0;
        
        for(int i = 0; i < edges.size() && edge_used < n - 1; i++){
            int node1 = edges[i].second.first;
            int node2 = edges[i].second.second;
            
            if(uf.join(node1, node2)){
                ans += edges[i].first;
                edge_used++;
            }
        }
        return ans;
    }
};