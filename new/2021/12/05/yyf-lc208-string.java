class Trie {
    private TrieNode root;
    
    class TrieNode {
        char val;
        String endWord;
        TrieNode[] children = new TrieNode[26];
        public TrieNode (char val) {
            this.val = val;
        }
    }

    public Trie() {
        root = new TrieNode('a');
    }
    
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode(c);
            }
            current = current.children[c - 'a'];
        }
        current.endWord = word;    
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.children[c - 'a'] == null) {
                return false;
            }
            current = current.children[c - 'a'];
        }
        return current.endWord != null;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (current.children[c - 'a'] == null) {
                return false;
            }
            current = current.children[c - 'a'];
        }
        return true;
    }
}