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
    TreeNode* deleteNode(TreeNode* root, int key) {
        if(root==NULL){
            return root;
        }
        TreeNode* parent=NULL;
        TreeNode* node=root;
        int l=0,r=0;
        bool found_key=false;
        while(node!=NULL){
            if(key == node->val){
                found_key=true;
                break;
            }
            else if(key > node->val){
                parent=node;
                r=1;
                l=0;
                node=node->right;
            }
            else{
                parent=node;
                l=1;
                r=0;
                node=node->left;
            }
        }
        if(found_key==false){
            return root;
        }
        // agar leaf node child hai?
        if(node->left == NULL && node->right == NULL){
            if(l==0 && r==0){
                root=NULL;
                delete node;
                node=NULL;
                return root;
            }
            if(l==1){
                parent->left=NULL;
                delete node;
                node=NULL;
                return root;
            }
            if(r==1){
                parent->right=NULL;
                delete node;
                node=NULL;
                return root;
            }
        }
        else if(node ->left == NULL){
            if(l==0 && r==0){
                root=node->right;
                delete node;
                node=NULL;
                return root;
            }
            if(l==1){
                parent->left=node->right;
                delete node;
                node=NULL;
                return root;
            }
            if(r==1){
                parent->right=node->right;
                delete node;
                node=NULL;
                return root;
            }
        }
        else if(node->right == NULL){
            if(l==0 && r==0){
                root=node->left;
                delete node;
                node=NULL;
                return root;
            }
            if(l==1){
                parent->left=node->left;
                delete node;
                node=NULL;
                return root;
            }
            if(r==1){
                parent->right=node->left;
                delete node;
                node=NULL;
                return root;
            }
        }
        else{
                TreeNode* temp1=node->right;
                parent=node;
                l=0;
                r=1;
                while(temp1->left!=NULL){
                    parent=temp1;
                    l=1;
                    r=0;
                    temp1=temp1->left;
                }
                node->val=temp1->val;
                if(l==1)
                    parent->left=temp1->right;
                if(r==1)
                    parent->right=temp1->right;
                delete temp1;
                temp1=NULL;
                return root;   
        }
        return root;
    }
};