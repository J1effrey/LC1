class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }
    
    int m;
    int n;
    
    int[] xDir = new int[]{1, -1, 0, 0};
    int[] yDir = new int[]{0 , 0, 1, -1};
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        
        // validate input
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return res;
        }
        
        if (words == null || words.length == 0) {
            return res;
        }
            
        // build trie
        TrieNode root = new TrieNode();
        buildTrie(root, words);
        
        // dfs
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (root.children[c - 'a'] != null) {
                    dfs(res, visited, i, j, board, root);
                }
            }
        }
        
        return res;
    }
    
    private void dfs(List<String> res, boolean[][] visited, int x, int y, char[][] board, TrieNode parent) {
        char c = board[x][y];
        visited[x][y] = true;
        
        TrieNode node = parent.children[c - 'a'];
        
        if (node != null && node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        
        for (int i = 0; i < 4; i++) {
            int newX = x + xDir[i];
            int newY = y + yDir[i];
            if (isValid(newX, newY) && !visited[newX][newY]) {
                char nextC = board[newX][newY];
                if (node.children[nextC - 'a'] != null) {
                    dfs(res, visited, newX, newY, board, node);
                }
            }
        }
        
        visited[x][y] = false;
    }
    
    private boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
    
    private void buildTrie(TrieNode n, String[] words) {
        for (int i = 0; i < words.length; i++) {
            buildTrieNode(n, words[i]);
        }
    }
    
    private void buildTrieNode(TrieNode n, String word) {
        TrieNode cur = n;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }   
        cur.word = word;
    }
}
