/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<TreeNode*>p_p;
    vector<TreeNode*>p_q;
    
    vector<TreeNode*>ans_p_p;
    vector<TreeNode*>ans_p_q;
    
    void fun1(TreeNode*& p, TreeNode*& root){
        if(root==NULL){
            return;
        }
        p_p.push_back(root);
        if(root->val == p->val){
            ans_p_p=p_p;
            return;
        }
        fun1(p, root->left);
        //if(p_p.size() > 0)
          //  p_p.pop_back();
        fun1(p, root->right);
        if(p_p.size() > 0)
            p_p.pop_back();
    }
    
    void fun2(TreeNode*& q, TreeNode*& root){
        if(root==NULL){
            return;
        }
        p_q.push_back(root);
        if(root->val == q->val){
            ans_p_q=p_q;
            return;
        }
        fun2(q, root->left);
        //if(p_q.size() > 0)
          //  p_q.pop_back();
        fun2(q, root->right);
        if(p_q.size() > 0)
            p_q.pop_back();
    }
    
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        fun1(p, root);
        fun2(q, root);
        for(auto x: ans_p_p)    cout<<x->val<<" ";
        cout<<endl;
        for(auto x: ans_p_q)    cout<<x->val<<" ";
        cout<<endl;
        int i=0;
        int j=0;
        while(i< ans_p_p.size() && j< ans_p_q.size()){
            if(ans_p_p[i]==ans_p_q[j]){
                i++;
                j++;
                continue;
            }else{
                break;
            }
        }
        cout<<i<<" "<<j<<endl;
        if(i >= ans_p_p.size() && j >= ans_p_q.size()){
            return ans_p_p[i-1];
        }
        else if(i >= ans_p_p.size()){
            return ans_p_p[i-1];
        }else if(j >= ans_p_q.size()){
            return ans_p_q[i-1];
        }else{
            return ans_p_p[i-1];
        }
    }
};