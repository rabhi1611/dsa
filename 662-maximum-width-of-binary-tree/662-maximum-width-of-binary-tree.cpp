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
    unordered_map<int, list<unsigned long long>>mp;
    
    void fun(TreeNode* root, int level, unsigned long long idx){
        if(root == NULL){
            return;
        }
        mp[level].push_back(idx);
        fun(root->left, level + 1, (2 * idx) + 1);
        fun(root->right, level + 1, (2 * idx) + 2);
    } 
    
    int widthOfBinaryTree(TreeNode* root) {
        fun(root, 0, 0);
        int ans = 0;
        for(auto x : mp){
            auto it1 = x.second.end();
            it1--;
            auto it2 = x.second.begin();
            //cout<<(*it1)<<" "<<(*it2)<<endl;
            if((*it1 - *it2) + 1 > ans){
                ans  = (*it1 - *it2) + 1;
            }
        }
        return ans;
    }
};