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
    bool fun(TreeNode*& root, int& num){
        if(root == NULL){
            return true;
        }    
        if(root->val != num){
            return false;
        }
        bool a =fun(root->left, num);
        bool b =fun(root->right, num);
        if(a== true && b==true){
            return true;
        }
        return false;
    }
    
    bool isUnivalTree(TreeNode* root) {
        int num=root->val;
        return fun(root,num);
    }
};