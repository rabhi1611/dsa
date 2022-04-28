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
    bool equationsPossible(vector<string>& equations) {
        // dsu problem!
        int n = equations.size();
        
        UnionFind uf(26);
        
        for(auto x: equations){
            char node1 = x[0];
            char node2 = x[3];
            if(x[1] == '='){
                // same set me hona chahiye
                uf.join(node1 - 97, node2 - 97);
            }
        }
        
        
        for(auto x: equations){
            char node1 = x[0];
            char node2 = x[3];
            if(x[1] == '!'){
                // same set me hona chahiye
                if(uf.find(node1 - 97) == uf.find(node2 - 97)){
                    return false;
                }
            }
        }
        
        
        return true;
    }
};