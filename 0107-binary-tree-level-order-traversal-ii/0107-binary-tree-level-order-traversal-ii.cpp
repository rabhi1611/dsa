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
    map<int,vector<int>>m;
    int level=0;
    void fun(TreeNode*& root){
        if(root==NULL){
            level--;
            return;
        }
        m[level].push_back(root->val);
        level++;
        fun(root->left);
        level++;
        fun(root->right);
        level--;
        return;
    }
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        vector<vector<int>>v;
        fun(root);
        if(m.size()!=0){
            auto it=m.end();
            it--;
            while(it!=m.begin()){
                v.push_back((*it).second);
                it--;
            }
            v.push_back((*it).second);
        }
        return v;
    }
};