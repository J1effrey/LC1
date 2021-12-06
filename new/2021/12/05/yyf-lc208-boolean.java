class TrieNode {
    public TrieNode[] links;
    public int R = 26;
    public boolean isEnd;
    public TrieNode() {
        links = new TrieNode[R];
    }
}
class Trie {
    
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
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
        TrieNode node = helper(word);
        return node != null && node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = helper(prefix);
        return node != null;
    }
    
    private TrieNode helper(String word) {
        TrieNode node = root;
        for (char ch: word.toCharArray()) {
            if (node.links[ch - 'a'] == null) {
                return null;
            }
            node = node.links[ch - 'a'];
        }
        return node;
    }
}