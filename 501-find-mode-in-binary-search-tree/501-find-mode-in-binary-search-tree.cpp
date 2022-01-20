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
    unordered_map<int,int>m;
    int max_count=0;
    void fun(TreeNode*& root){
        if(root==NULL){
            return;
        }
        m[root->val]++;
        max_count=max(max_count,m[root->val]);
        fun(root->left);
        fun(root->right);
        return;
    }
    vector<int> findMode(TreeNode* root) {
        fun(root);
        vector<int>ans;
        for(auto x:m){
            if(x.second==max_count){
                ans.push_back(x.first);
            }
        }
        return ans;
    }
};