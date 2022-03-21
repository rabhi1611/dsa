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
    vector<vector<int>> ans;
    
    void fun(TreeNode* root, int targetSum, vector<int>& v, int sum){
        if(root == NULL){
            return;
        }
        sum += root->val;
        v.push_back(root -> val);
        if(sum == targetSum && (root -> left == NULL && root -> right == NULL)){
            ans.push_back(v);
            v.pop_back();
            return;
        }
        fun(root->left, targetSum, v, sum);
        fun(root->right, targetSum, v, sum);
        if(v.size() != 0){
            v.pop_back();
        }
        return;
    }
    
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        vector<int> v;
        fun(root, targetSum, v, 0);
        return ans;
    }
};