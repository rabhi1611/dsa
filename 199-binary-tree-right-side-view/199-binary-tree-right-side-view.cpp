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
    unordered_map<int, list<int>> mp;
    int maxi = -1;
    void fun(TreeNode* root, int level){
        if(root == NULL){
            return;
        }
        maxi = max(maxi, level);
        mp[level].push_back(root->val);
        fun(root->left, level + 1);
        fun(root->right, level + 1);
    }
    vector<int> rightSideView(TreeNode* root) {
        fun(root, 0);
        vector<int>ans;
        for(int i = 0; i <= maxi; i++){
            ans.push_back(mp[i].back());
        }
        return ans;
    }
};