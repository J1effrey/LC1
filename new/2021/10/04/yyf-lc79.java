// Time: Time Complexity: O(Rows * Cols * 3^L) where NN is the number of cells in the board and LL is the length of the word to be matched
// Space: O(Rows * Cols)
class Solution {
    private boolean[][] visited;
    private char[][] board;
    private int ROWS;
    private int COLS;
    
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        }
        
        this.board = board;
        this.ROWS = board.length;
        this.COLS = board[0].length;
        this.visited = new boolean[ROWS][COLS];
        
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (backTrack(i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean backTrack(int row, int col, String word, int index) {
        if (index == word.length() - 1 && word.charAt(index) == board[row][col]) {
            return true;
        }
        
        if (index >= word.length()) {
            return false;
        }
        
        if (word.charAt(index) != board[row][col]) {
            return false;
        }
        
        visited[row][col] = true;
        
        int[] rowOffsets = new int[]{0, 1, 0, -1};
        int[] colOffsets = new int[]{1, 0, -1, 0};
        
        boolean foundWord = false;
        for (int i = 0; i < 4; i++) {
            if (isValid(row + rowOffsets[i], col + colOffsets[i]) && !visited[row + rowOffsets[i]][col + colOffsets[i]]) {
                foundWord = backTrack(row + rowOffsets[i], col + colOffsets[i], word, index + 1);
                if (foundWord) {
                    return true;
                }
            }
        }     
        
        visited[row][col] = false;
        
        return false;
    }
    
    private boolean isValid(int x, int y) {
        return x >= 0 && x < ROWS && y >= 0 && y < COLS;
    }
}

