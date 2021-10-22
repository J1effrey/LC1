class Solution {
    public void gameOfLife(int[][] board) {
       if (board == null || board.length == 0 || board[0].length == 0) {
           return;
       }
        
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int neighbors = getNeighborCount(i, j, board);
                if (board[i][j] == 0 && neighbors == 3) {
                    board[i][j] = 2;
                }
                
                if (board[i][j] == 1 && (neighbors == 2 || neighbors == 3)) {
                    board[i][j] = 3;
                }
            }
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
    
    private int getNeighborCount(int row, int col, int[][] board) {
        int[][] directions = {{-1, 0},{-1, 1},{-1, -1},{1, 0},{1, -1},{1, 1},{0, -1},{0, 1}};
        int count = 0;
        for (int i = 0; i < directions.length; i++) {
            int x = row + directions[i][0];
            int y = col + directions[i][1];
            if (isValid(x, y, board) &&(board[x][y] == 1 || board[x][y] == 3)) {
                count++;
            }
        }
        return count;
    }
    
    private boolean isValid(int x, int y, int[][] board) {
        return x >= 0 && x < board.length  && y >= 0 && y < board[0].length;
    }
}


/*
00  4
01  1/3
10  4
11  2
*/
