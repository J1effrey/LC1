class Trie {
    class TrieNode {
        public TrieNode[] links;
        public int R = 26;
        public boolean isEnd;
        public TrieNode() {
            links = new TrieNode[R];
        }
    }
    
    public Trie() {
        root = new TrieNode();
    }
    
    private TrieNode root;
    public void insert(String word) {
        TrieNode node = root;
        for (char ch: word.toCharArray()) {
            if (node.links[ch - 'a'] == null) {
                node.links[ch - 'a'] = new TrieNode();
            }
            node = node.links[ch - 'a'];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch: word.toCharArray()) {
            if (node.links[ch - 'a'] == null) {
                return false;
            }
            node = node.links[ch - 'a'];
        }
        return node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch: prefix.toCharArray()) {
            if (node.links[ch - 'a'] == null) {
                return false;
            }
            node = node.links[ch - 'a'];
        }
        return true;
    }
}
