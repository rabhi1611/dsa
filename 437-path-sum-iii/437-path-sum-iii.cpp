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
    int ans = 0;
    
    void fun(TreeNode* root, int sum, int targetSum){
        if(root == NULL){
            return;
        }    
        sum += root->val;

        if(sum == targetSum){
            ans++;    
        }
        
        fun(root->left, sum, targetSum);
        fun(root->right, sum, targetSum);
        return;
    }
    
    void fun2(TreeNode* root, int targetSum){
        if(root == NULL){
            return;
        }
        fun(root, 0, targetSum);
        fun2(root->left, targetSum);
        fun2(root->right, targetSum);
        return;
    }
    
    
    int pathSum(TreeNode* root, int targetSum) {
        if(root == NULL){
            return 0;
        }
        fun2(root, targetSum);
        
        return ans;
    }
};