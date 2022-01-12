// T: O()
// S: O()

class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
            
        dfs(board, 0, 0);
    }
    
    public boolean dfs(char[][] board, int row, int col) {
        if (row == 9 && col == 0) {
            return true;
        }
        
        int newCol = col + 1;
        int newRow = row;
        
        if (newCol == 9) {
            newCol = 0;
            newRow += 1;
        }
        
        if (board[row][col] != '.') {
            return dfs(board, newRow, newCol);
        }
        
        for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, row, col, c)) {
                board[row][col] = c;
                if (dfs(board, newRow, newCol)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }
    
    private boolean isValid(char[][] board, int row, int col, char c){
        int boxRow = 3 * (row / 3);  
        int boxCol = 3 * (col / 3);  
        
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) {
                return false;
            }
            
            if (board[row][i] == c) {
                return false;
            }
            
            if (board[boxRow + i / 3][boxCol + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
}
