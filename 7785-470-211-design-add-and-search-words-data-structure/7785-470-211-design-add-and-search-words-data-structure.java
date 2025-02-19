class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;

    TrieNode () {
        children = new HashMap<>();
        isWord = false;
    }
}

class WordDictionary {
    private TrieNode root; 

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);

            if(!node.children.containsKey(c)){
                node.children.put(c, new TrieNode());
            }

            node = node.children.get(c);
        }

        node.isWord = true;
    }
    
    public boolean search(String word) {
        return helper(root, word, 0);
    }

    private boolean helper(TrieNode node, String word, int idx){
        if(idx == word.length()){
            return node.isWord;
        }

        char c = word.charAt(idx);

        if (c == '.') {
            for(TrieNode child: node.children.values()){
                if(helper(child, word, idx + 1)){
                    return true;
                }
            }

            return false;
        } else {
            TrieNode child = node.children.get(c);

            if(child == null){
                return false;
            }

            return helper(child, word, idx + 1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */