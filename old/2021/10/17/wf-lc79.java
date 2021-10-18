class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board[0] == null || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        boolean[][] visited;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                visited = new boolean[board.length][board[0].length];
                if (board[i][j] == word.charAt(0) && dfs(i, j, board, word, visited, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(int i, int j, char[][] board, String word, boolean[][] visited, int index) {
        if (index == word.length()) {
            return true;
        }
        
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || visited[i][j]) {
            return false;
        }
        
        if (!visited[i][j] && board[i][j] != word.charAt(index)) {
            return false;
        }
        
        boolean res;
        visited[i][j] = true;
        res = dfs(i + 1, j, board, word, visited, index + 1) ||
            dfs(i - 1, j, board, word, visited, index + 1) ||
            dfs(i, j + 1, board, word, visited, index + 1) ||
            dfs(i, j - 1, board, word, visited, index + 1);
        visited[i][j] = false;
        return res;
    }
}
