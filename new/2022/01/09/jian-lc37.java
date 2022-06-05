// T: O()
// S: O()
class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
             for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            } 
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
             }
        }
        return true;
    }
    
    public boolean isValid(char[][] board, int i, int j, char c) {
        // check same column
        for (int row = 0; row < 9; row++) {
            if (board[row][j] == c) {
                return false;
            }
        }
        
        // check same row
        for (int col = 0; col < 9; col++) {
            if (board[i][col] == c) {
                return false;
            }
        }
        
        // check 3 x 3
        for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {
            for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++) {
                if (board[row][col] == c) {
                    return false;
                }
            }
        }
        return true;
    }
}

-------------------------------------------------------------------------------
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
