/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    
    bool fun(TreeNode*& root, long long int s,long long int e){
        if(root == NULL){
            return true;
        }
        if(!(root->val >s && root->val < e)){
            return false;
        }
        bool a = fun(root->left, s, root->val);
        bool b = fun(root->right, root->val, e);
        if(a == true && b == true){
            return true;
        }
        return false;
    }
    
    bool isValidBST(TreeNode* root) {
        return fun(root, LONG_MIN, LONG_MAX);
    }
};