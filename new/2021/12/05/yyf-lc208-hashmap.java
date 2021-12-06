class Trie {
    
    class TrieNode{
        Map<Character, TrieNode> children;
        boolean isEnd = false;
        public TrieNode(){
            children = new HashMap();      
        }
        
        
    }
    
    /** Initialize your data structure here. */   
    public Trie() {
        root = new TrieNode();
    }
    
    TrieNode root;
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null) {
            return;
        }   
        TrieNode node = root;
        for(char ch : word.toCharArray()) {
            if(!node.children.containsKey(ch)){
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
        }
        node.isEnd = true;
       
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null) {
            return false;
        }
        TrieNode node = root;
        for(char ch : word.toCharArray()) {
            if(!node.children.containsKey(ch)){
                return false;
            } 
            node = node.children.get(ch);
            
        }
        return node.isEnd;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null) {
           return false; 
        } 
        TrieNode node = root;
        for(char ch : prefix.toCharArray()) {
            if(!node.children.containsKey(ch)){
                return false;
            } 
            node = node.children.get(ch);
            
        }
        return true; 
        
    }
    
    
}