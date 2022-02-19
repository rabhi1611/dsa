/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Codec {
public:
    string s="";
    TreeNode* ans = NULL;
    // Encodes a tree to a single string.
    
    void fun(TreeNode* root){
        if(root == NULL){
            s += "-1";
            return;
        }
        s+='(';
        s += to_string(root->val);
        s+=')';
        fun(root->left);
        fun(root->right);
    }
    
    void fun2(TreeNode*& root, int& i){
        //cout<<s.size()<<endl;
        if(i >= s.size()){
            return;
        }
        //cout<<s[i]<<" -> ";
        if(s[i] == 45){
            i += 2;
            return;
        }
        string temp = "";
        int j = i + 1;
        while(s[j] != ')'){
            temp += s[j];
            j++;
        }
        //cout<<temp<<" ";
        root = new TreeNode(stoi(temp));
        
        i = j + 1;
        fun2(root->left, i);
        fun2(root->right, i);
    }
    
    
    string serialize(TreeNode* root) {
        fun(root);
        //cout<<s<<endl;
        return s;
    }
    
    

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        TreeNode* root = NULL;
        int i = 0;
        s = data;
        fun2(root, i);
        return root;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec* ser = new Codec();
// Codec* deser = new Codec();
// string tree = ser->serialize(root);
// TreeNode* ans = deser->deserialize(tree);
// return ans;