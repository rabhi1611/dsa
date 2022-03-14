/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
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
    
    void build_tree(vector<int>& v, int s, int e, TreeNode*& tree){
        if(s > e){
            return;
        }
        int mid = (s+e)/2;
        tree = new TreeNode(v[mid]);
        build_tree(v, s, mid - 1, tree -> left);
        build_tree(v, mid + 1, e, tree -> right);
        return;
    } 
    
    TreeNode* sortedListToBST(ListNode* head) {
        vector<int>v;
        while(head != NULL){
            v.push_back(head->val);
            head = head -> next;
        } 
        TreeNode* tree = NULL;
        if(v.size() == 0){
            return tree;
        }
        
        build_tree(v, 0, v.size() - 1, tree);
        return tree;
    }
};