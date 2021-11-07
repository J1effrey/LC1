class AutocompleteSystem {
    
    class TrieNode implements Comparable<TrieNode> {
        String sentence;
        Map<Character, TrieNode> children;
        int times;
        List<TrieNode> hot;
        
        public TrieNode() {
            sentence = null;
            children = new HashMap<Character, TrieNode>();
            times = 0;
            hot = new ArrayList<TrieNode>();
        }
        
        public int compareTo(TrieNode node) {
            if (node.times == this.times) {
                return this.sentence.compareTo(node.sentence);
            }
            
            return node.times - this.times;
        }
        
        private void updateHot(TrieNode node) {
            if (!hot.contains(node)) {
                this.hot.add(node);
            }
            
            Collections.sort(hot);
            
            while(hot.size() > 3) {
                hot.remove(hot.size() - 1);
            }
        }
    }

    TrieNode root;
    TrieNode cur;
    StringBuilder sb;
    public AutocompleteSystem(String[] sentences, int[] times) {
        if (sentences == null || sentences.length == 0) {
            return;
        }
        
        if (sentences == null || sentences.length == 0) {
            return;
        }
        
        root = new TrieNode();
        cur = root;
        sb = new StringBuilder();
        
        for (int i = 0; i < sentences.length; i++) {
            addSentence(sentences[i], times[i]);
        }
    }
    
    private void addSentence(String sentence, int time) {
        TrieNode cur = root;
        
        Set<TrieNode> visited = new HashSet<TrieNode>();
        
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
            visited.add(cur);
        }
        cur.sentence = sentence;
        cur.times += time;
        
        for (TrieNode node: visited) {
            node.updateHot(cur);
        }
    }
    
    
    public List<String> input(char c) {
        List<String> res = new ArrayList<String>();
        
        if (c == '#') {
            String newSentence = sb.toString();
            addSentence(newSentence, 1);
            sb = new StringBuilder();
            cur = root;
            return res;
        }  
        
        sb.append(c);
        if (cur == null) {
            return res;
        }
        
        cur = cur.children.get(c);
        
        if (cur == null) {
            return res;
        }
        
        for (TrieNode node: cur.hot) {
            res.add(node.sentence);
        }
        
        return res;
    }
}
