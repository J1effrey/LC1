class Solution {
    
    // if val is 1, only 2 or 3 lives neighbours -> 1
    // if val is 0, only 3 lives neighbours -> 1
    
     // easy, space: O(m * n), newBoard[][]
        
        // O(1), optimal solution. 
        // remember previous state, calculate next state at same time
        // bit manupalation 
        // 0 or 1
        // 00 or 01,   left digit : next state,  right : current state.
        
        // while traversing each cell, main next state in the left, I won't change right digit,
        
        
        // final : >> 1, move bits to right by 1 step
    
        // live -> dead, 
        // you concern is correct, 01,   1 >> 1  -> 0 , 01 
    
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = getNumOfLiveNeighors(i, j, board);
                
                if (board[i][j] == 1 && (count == 2 || count == 3)) {
                    board[i][j] = 3;  // 11
                }
                
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 2; // 10
                }
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
    
    private int getNumOfLiveNeighors(int i, int j, int[][] board) {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int count = 0;
        int m = board.length;
        int n = board[0].length;
        
        for (int[] dir: dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                if (board[x][y] == 1 || board[x][y] == 3) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
