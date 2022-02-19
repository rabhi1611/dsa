/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};
*/

class Solution {
public:
    unordered_map<int, list<Node*>>mp;
    
    void fun(Node* root, int level){
        if(root == NULL){
            return;
        }
        mp[level].push_back(root);
        fun(root->left, level + 1);
        fun(root->right, level + 1);
    }
    
    
    void fun2(Node* root, int level){
        if(root == NULL){
            return;
        }
        auto it = mp[level].begin();
        it++;
        if(it != mp[level].end()){
            root->next = *it;
            mp[level].erase(it);
        }
        fun2(root->left, level + 1);
        fun2(root->right, level + 1);
    }
    
    
    Node* connect(Node* root) {
        fun(root, 0);
        fun2(root, 0);
        return root;
    }
};