class Trie {
    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isEnd;
    }
    
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            
            cur = cur.children[c - 'a'];
            
        }
        
        return cur != null && cur.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            
            cur = cur.children[c - 'a'];
            
        }
        
        return cur != null;
    }
}
