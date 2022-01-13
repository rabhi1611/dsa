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
    vector<int>v1;
    vector<int>v2;
    void fun1(TreeNode*& root){
        if(root==NULL){
            return;
        }
        if(root->left==NULL && root->right==NULL){
            v1.push_back(root->val);
            return;
        }
        fun1(root->left);
        fun1(root->right);
        return;
    }
    
    void fun2(TreeNode*& root){
        if(root==NULL){
            return;
        }
        if(root->left==NULL && root->right==NULL){
            v2.push_back(root->val);
            return;
        }
        fun2(root->left);
        fun2(root->right);
        return;
    }
    
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        fun1(root1);
        fun2(root2);
        int i=0,j=0;
        while(i<v1.size() && j<v2.size()){
            if(v1[i]!=v2[j]){
                return false;
            }
            i++;
            j++;
        }
        if(i<v1.size() || j<v2.size()){
            return false;
        }
        return true;
    }
};