class TrieNode{
  public:
    char data;
    TrieNode ** child;
    bool isTerminal;
    
    TrieNode(char data){
        this->data = data;
        this->child = new TrieNode*[26];
        for(int i = 0; i<26; i++){
            this->child[i] = NULL;
        }
        this->isTerminal = false;
    }
};


class Trie {
public:
    TrieNode* root;
    Trie() {
        this->root = new TrieNode('*');
    }
    
    void insertNode(string word, TrieNode* root){
        if(word.length() == 0){
            root->isTerminal = true;
            return;
        }
        TrieNode* temp;
        int idx = word[0] - 97;
        if(root->child[idx] != NULL){
            temp = root->child[idx];
        }else{
            temp = new TrieNode(word[0]);
            root->child[idx] = temp;
        }
        insertNode(word.substr(1), temp);
        return;
    }
    
    bool searchNode(string word, TrieNode* root){
        if(word.length() == 0){
            if(root->isTerminal == true){
                return true;
            }
            return false;
        }
        TrieNode* temp;
        int idx = word[0] - 97;
        if(root->child[idx] != NULL){
            temp = root->child[idx];
        }
        if(temp == NULL){
            return false;
        }
        return searchNode(word.substr(1), temp);
    }
    
    bool sw(string word, TrieNode* root){
        if(word.length() == 0){
            return true;
        }
        
        
        TrieNode* temp;
        int idx = word[0] - 97;
        if(root->child[idx] != NULL){
            temp = root->child[idx];
        }
        if(temp == NULL){
            return false;
        }
        return sw(word.substr(1), temp);
        
    }
    
    void insert(string word) {
        insertNode(word, root);
    }
    
    bool search(string word) {
        return searchNode(word, root);
    }
    
    bool startsWith(string prefix) {
        return sw(prefix, root);
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */