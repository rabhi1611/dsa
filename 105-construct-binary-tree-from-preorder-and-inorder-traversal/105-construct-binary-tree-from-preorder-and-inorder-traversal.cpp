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
    unordered_map<int, pair<int, int>> mp;
    
    void fun(TreeNode*& root, vector<int>& preorder, vector<int>& inorder, int& i){
        if(i >= preorder.size()){
            return;
        }
        
        int idx = mp[preorder[i]].first;
        mp[preorder[i]].second = 1;
        
        if(idx - 1 >= 0 && mp[inorder[idx - 1]].second == 0){
            //cout<<i<<" "<<idx<<endl;
            root->left = new TreeNode(preorder[i + 1]);
            i+=1;
            //cout<<endl;
            //cout<<root->left->val<<" ";
            fun(root->left, preorder, inorder, i);
        }
        
        if(idx + 1 < inorder.size() && mp[inorder[idx + 1]].second == 0){
            //cout<<i<<" "<<idx<<endl;
            root->right = new TreeNode(preorder[i+1]);
            i+=1;
            fun(root->right, preorder, inorder, i);
        }
        return;
    }
    
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        for(int i = 0; i < inorder.size(); i++){
            mp[inorder[i]] = {i, 0};
        }
        TreeNode* tree = new TreeNode(preorder[0]);
        int i = 0;
        fun(tree, preorder, inorder, i);
        return tree;
    }
};