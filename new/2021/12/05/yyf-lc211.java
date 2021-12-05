class WordDictionary {
    class TrieNode {
        char c;
        TrieNode[] children;
        String word;
        
        public TrieNode (char c) {
            this.c = c;
            children = new TrieNode[26];
            word = null;
        }
    }
    
    TrieNode root;
    
    public WordDictionary() {
        this.root = new TrieNode('r');
    }
    
    public void addWord(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int childIndex = c - 'a';
            if (cur.children[childIndex] == null) {
                cur.children[childIndex] = new TrieNode(c);
            }
            cur = cur.children[childIndex];
        }
        cur.word = word;
    }
    
    public boolean search(String word) {
        System.out.println(getAllMatchedWords(word));
        System.out.println("=======");
        return searchWithPreviousTrieNode(word, root);
    }
    
    public boolean searchWithPreviousTrieNode(String word, TrieNode pre) {
        TrieNode cur = pre;
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (c == '.') {
                for (int j = 0; j < 26; j++) {
                    if (cur.children[j] == null) {
                        continue;
                    }
                    
                    if (searchWithPreviousTrieNode(word.substring(i + 1), cur.children[j])) {
                        return true;
                    }
                }
                return false;
            } else {
                int childIndex = c - 'a';
                if (cur.children[childIndex] == null) {
                    return false;
                }
                cur = cur.children[childIndex];
            }
        }
        
        return  cur.word != null;
    }
    
    // TODO: YYF
    public List<String> getAllMatchedWords(String word) {
        return getAllPreviousTrieNode(word, root);
    }
    
    public List<String> getAllPreviousTrieNode(String word, TrieNode pre) {
        List<String> list = new ArrayList<>();
        TrieNode cur = pre;
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (c == '.') {
                for (int j = 0; j < 26; j++) {
                    if (cur.children[j] == null) {
                        continue;
                    }
                    List<String> temp = getAllPreviousTrieNode(word.substring(i + 1), cur.children[j]);
                    list.addAll(temp);
                }
                return list;
            } else {
                int childIndex = c - 'a';
                if (cur.children[childIndex] == null) {
                    return list;
                }
                cur = cur.children[childIndex];
            }
        }
        if (cur.word != null) {
            list.add(cur.word);
        }
        return list;
    }
}

// [".ad"],["b.."],
// "search","search"