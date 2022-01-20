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
    
    int fun2(TreeNode*& root,int target){
        if(root==NULL){
            return 0;
        }
        int a=0;
        int b=0;
        a=fun2(root->left,target);
        b=fun2(root->right,target);
        if(root->val==target){
            return a+b+1;
        }
        return a+b;
    }
    
    
    //unordered_map<int,int>m;
    int max_count=0;
    vector<int>ans;
    void fun(TreeNode*& root){
        if(root==NULL){
            return;
        }
        int c=fun2(root,root->val);
        //cout<<c<<endl;
        if(c>max_count){
            ans.clear();
            ans.push_back(root->val);
            max_count=c;
        }
        else if(c==max_count){
            ans.push_back(root->val);
        }
        //m[root->val]++;
        //max_count=max(max_count,m[root->val]);
        fun(root->left);
        fun(root->right);
        return;
    }
    vector<int> findMode(TreeNode* root) {
        fun(root);
        return ans;
    }
};