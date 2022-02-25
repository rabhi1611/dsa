/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
public:
    unordered_map<Node*, Node*>mp;
    
    Node* dfs(Node* node){
        Node* clone = new Node(node->val);
        vector<Node*>v;
        mp[node] = clone;
        for(int i = 0; i < node->neighbors.size(); i++){
            if(mp.count(node->neighbors[i]) == 0){
                mp[node->neighbors[i]] = dfs(node->neighbors[i]);
            }
            v.push_back(mp[node->neighbors[i]]);
        }
        clone->neighbors = v;
        return clone;
    }
   
    
    
    Node* cloneGraph(Node* node) {
        if(node == NULL){
            return NULL;
        }
        if(node->neighbors.size() == 0){
            Node* clone = new Node(node->val);
            return clone;
        }
        return dfs(node);
    }
};