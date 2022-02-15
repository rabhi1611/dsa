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
    vector<vector<int>>ans;
    int max_level = -1;
    void fun(TreeNode* root, int level){
        if(root == NULL){
            return;
        }
        max_level = max(max_level, level);
        ans[level].push_back(root->val);
        fun(root->left, level + 1);
        fun(root->right, level + 1);
        return;
    }
    
    vector<vector<int>> levelOrder(TreeNode* root) {
        for(int i = 0; i <= 2000; i++){
            ans.push_back({});
        }
        fun(root, 0);
        return vector<vector<int>>(ans.begin(), ans.begin() + max_level+1);
    }
};