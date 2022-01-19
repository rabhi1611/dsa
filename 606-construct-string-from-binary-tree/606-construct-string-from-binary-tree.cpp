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
    void fun(TreeNode*& root, string& s){
        if(root==NULL){
            s+=')';
            return;
        }
        s+=(to_string(root->val));
        if(root->left==NULL && root->right==NULL){
            s+=')';
            return;
        }
        s+='(';
        fun(root->left, s);
        if(root->right!=NULL){
            s+='(';
            fun(root->right, s);
        }
        s+=')';
        return;
    }
    
    string tree2str(TreeNode* root) {
        string s="";
        fun(root, s);
        return s.substr(0,s.size()-1);
    }
};