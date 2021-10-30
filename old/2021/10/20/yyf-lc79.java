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


// class Solution {
    
//     public boolean exist(char[][] board, String word) {
//         if (board == null || board.length == 0 || board[0].length == 0) {
//             return false;
//         }
//         boolean[][] visited = new boolean[board.length][board[0].length];
//         for (int i = 0; i < board.length; i++) {
//             for (int j = 0; j < board[0].length; j++) {
//                 if (dfs(i,j,board,visited,word, 0)) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
    
//     private boolean dfs(int row, int col, char[][] board, boolean[][] visited, String word, int index) {
//         if (index == word.length()) {
//             return true;
//         }
//         if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index) || visited[row][col]) {
//             return false;
//         }
//         visited[row][col] = true;
//         if (dfs(row + 1, col, board, visited, word, index + 1) ||
//            dfs(row - 1, col, board, visited, word, index + 1) ||
//            dfs(row, col + 1, board, visited, word, index + 1) ||
//            dfs(row, col - 1, board, visited, word, index + 1)) {
//             return true;
//         }
//         visited[row][col] = false;
//         return false;
//     }
// }