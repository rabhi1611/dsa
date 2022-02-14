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
    
    void fun(Node*& root, int level){
        if(root == NULL){
            return;
        }
        mp[level].push_back(root);
        fun(root->left, level + 1);
        fun(root->right, level + 1);
        return;
    }
    
    void temp_fun(Node*& root,int level){
        if(root == NULL){
            return;
        }
        if(mp[level].size() > 1){
            auto it = mp[level].begin();
            it++;
            root->next = *it;
            mp[level].remove(*it);
        }
        //mp[level].push_back(root);
        temp_fun(root->left, level + 1);
        temp_fun(root->right, level + 1);
        return;
    }
    
    unordered_map<int, list<Node*>>mp;
    Node* connect(Node* root) {
        if(root == NULL){
            return root; 
        }
        // get the levels
        fun(root, 0);
        temp_fun(root, 0);
        return root;
    }
};