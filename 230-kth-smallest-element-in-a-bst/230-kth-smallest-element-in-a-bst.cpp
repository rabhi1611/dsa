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
    
    int height(TreeNode* root){
        if(root == NULL){
            return 0;
        }
        
        int a = height(root -> left);
        int b = height(root -> right);
        
        return  a + b + 1;
    }
    
    int ans = 0;
    int t = 0;
    
    void fun(TreeNode* root, int k){
        if(root == NULL){
            return;
        }
        // is node ke left ki height kya hai?
        int h = height(root -> left);
        //cout<<h<<endl;
        if(h + 1 + t == k){
            ans = root -> val;
            return;
        }
        
        if(h + 1 + t > k){
            fun(root -> left, k);
        }
        else{
            t += h + 1;
            fun(root -> right, k);
        }
        return;
    }
    
    int kthSmallest(TreeNode* root, int k) {
        fun(root, k);
        return ans;
    }
};