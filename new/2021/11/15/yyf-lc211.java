class WordDictionary {
    
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        return searchWithDot(word, root);
    }
    
    public boolean searchWithDot(String word, TrieNode nextNode) {
        if (nextNode == null) {
            return false;
        }
        TrieNode curr = nextNode;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (int j = 0; j < 26; j++) {
                    if (searchWithDot(word.substring(i + 1), curr.children[j])) {
                        return true;
                    }
                }
                return false;
            } 
            if (curr.children[c - 'a'] == null){
                return false;
            } 
            curr = curr.children[c - 'a'];
        }
        return curr.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
