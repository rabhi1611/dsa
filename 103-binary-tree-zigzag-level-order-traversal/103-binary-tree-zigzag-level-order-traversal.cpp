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
    unordered_map<int, vector<int>>mp;
    void fun(TreeNode* root, int level){
        if(root == NULL){
            return;
        }
        mp[level].push_back(root -> val);
        fun(root->left, level + 1);
        fun(root->right, level + 1);
        return;
    }
    
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>>ans;
        if(root == NULL){
            return ans;
        }
        fun(root, 0);
        for(int i = 0; i < mp.size(); i++){
            vector<int>v;
            if(i%2 == 0){
                for(auto x: mp[i]){
                    v.push_back(x);
                }
            }else{
                for(int j = mp[i].size()-1; j >= 0; j--){
                    v.push_back(mp[i][j]);
                }
            }
            ans.push_back(v);
        }
        return ans;
    }
};