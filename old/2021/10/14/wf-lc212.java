class Solution {
    class TrieNode {
        String word;
        HashMap<Character, TrieNode> child;
        public TrieNode() {
            word = null;
            child = new HashMap<>();
        }
    }
    
    class TrieTree {
        TrieNode root;
        public TrieTree(TrieNode root) {
            this.root = root;
        }
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                if (!node.child.containsKey(word.charAt(i))) {
                    node.child.put(word.charAt(i), new TrieNode());
                }
                node = node.child.get(word.charAt(i));
            }
            
            node.word = word;
        }
    }
    
    public int[] dx = {1, 0, -1, 0};
    public int[] dy = {0, 1, 0, -1};
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieTree root = new TrieTree(new TrieNode());
        if (board == null || board[0] == null || board[0].length == 0 || words == null || words.length == 0) {
            return result;
        }
        
        for (String word : words) {
            root.insert(word);
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                dfs(board, i, j, result, visited, root.root);
            }
        }
        return result;
    }
    
    private void dfs(char[][] board, int x, int y, List<String> res, boolean[][] visited, TrieNode root) {
        if (!root.child.containsKey(board[x][y])) {
            return;
        }
        TrieNode node = root.child.get(board[x][y]);
        if (node.word != null && !res.contains(node.word)) {
            res.add(node.word);
        }
        
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (!isValid(board, newX, newY, visited)) {
                continue;
            }
            if (node.child.containsKey(board[newX][newY])) {
                dfs(board, newX, newY, res, visited, node);
            }
        }
        visited[x][y] = false;
    }
    
    private boolean isValid(char[][] board, int x, int y, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }
        return !visited[x][y];
    }
}
