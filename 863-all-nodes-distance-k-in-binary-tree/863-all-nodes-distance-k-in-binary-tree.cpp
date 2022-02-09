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
    
    vector<int>ans;
    TreeNode* rootNode = NULL; 
    void find_nodes(TreeNode*& root, vector<int>& nodes){
        if(root == NULL){
            return;
        }
        nodes.push_back(root->val);
        find_nodes(root->left, nodes);
        find_nodes(root->right, nodes);
        return;
    }
    
    unordered_map<int, vector<int>> mp;
    vector<int>temp;
    void fun(TreeNode*& root, int x){
        if(root == NULL){
            return;
        }
        temp.push_back(root->val);
        if(root->val == x){
            mp[x] = temp;
            temp.clear();
            return;
        }
        fun(root->left, x);
        fun(root->right, x);
        if(temp.size() != 0)
            temp.pop_back();
        return;
    }
    
    vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
        if(root == NULL){
            return ans;
        }
        rootNode = root;
        vector<int> nodes;
        find_nodes(root, nodes);
        for(auto x: nodes){
            fun(root, x);
        }
        /*
        for(auto x: mp){
            cout<<x.first<<" -> ";
            for(auto y: x.second){
                cout<<y<<" ";
            }
            cout<<endl;
        }
        */
        // 3 se saare node ka distance mil gya
        // ab kya?
        // 3 se target node ka bhi distance pta hai
        
        
        // jb tk commom hai , continue
        
        for (auto x: nodes){
            vector<int> fp = mp[x];
            vector<int> sp = mp[target->val];
            int i = 0;
            while(i < fp.size() && i < sp.size()){
                if(fp[i] == sp[i]){
                    i++;
                    continue;
                }
                break;
            }
            int c = 0;
            c += fp.size() - i;
            c += sp.size() - i;
            if(c == k){
                ans.push_back(x);
            }
        }
        return ans;
    }
};