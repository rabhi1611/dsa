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
    
    unordered_map<int, int> mp;
    
    // mp.second.first = sum
    // mp.second.second = count
    
    
    void fun1(TreeNode* root, int& sum){
        if(root == NULL){
            return;
        }   
        sum += root -> val;
        
        fun1(root -> left, sum);
        fun1(root -> right, sum);
        
        //path.push_back(-1);
        return;
    }
    
    void fun(TreeNode* root){
        if(root == NULL){
            return;
        }
        
        
        int sum = 0;
        //path.push_back(root -> val);
        
        fun1(root, sum);
        
        mp[sum] ++;
        
        fun(root -> left);
        fun(root -> right);
        return;
    }
    
    vector<int> findFrequentTreeSum(TreeNode* root) {
        
        fun(root);
        
        vector<int> ans;
        
        //int sum = INT_MIN;
        int maxi = INT_MIN;
        
        for(auto x: mp){
            if(x.second > maxi){
                maxi = x.second;
            }
        }
        
        for(auto x: mp){
            if(x.second == maxi){
                ans.push_back(x.first);      
            }
        }
        return ans;
    }
};