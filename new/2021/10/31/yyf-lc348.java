class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal;
    int antidiagonal;
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }
    
    public int move(int row, int col, int player) {
        int val = player == 1 ? 1 : -1;
        rows[row] += val;
        cols[col] += val;
        if (row == col) {
            diagonal += val;
        }
        
        int size = rows.length;
        if (row == size - col - 1) {
            antidiagonal += val;
        }
        
        if (Math.abs(rows[row]) == size) {
            return player;
        } else if (Math.abs(cols[col]) == size) {
            return player;
        } else if (Math.abs(diagonal) == size) {
            return player;
        } else if (Math.abs(antidiagonal) == size) {
            return player;
        } else {
            return 0;
        }
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
