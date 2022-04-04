// Time: Time Complexity: O(Rows * Cols * 3^L) where Rows * Cols is the number of cells in the board and L is the length of the word to be matched
// Space: O(Rows * Cols + L)

class Solution { 
    int[] X_DIR = new int[] {1, -1, 0, 0};
    int[] Y_DIR = new int[] {0, 0, 1, -1};
    
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return false;
        }
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, 0, word, visited)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, int x, int y, int index, String word, boolean[][] visited) { 
        if (index == word.length() - 1 && word.charAt(index) == board[x][y]) {
            return true;
        }
    
        
        if (index >= word.length() || word.charAt(index) != board[x][y]) {
            return false;
        }
        
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int newX = x + X_DIR[i];
            int newY = y + Y_DIR[i];
            if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length || visited[newX][newY]) {
                continue;
            }
            
            if (dfs(board, newX, newY, index + 1, word, visited)) {
                return true;
            }
        }
        
        visited[x][y] = false;
        return false;
    }
}
