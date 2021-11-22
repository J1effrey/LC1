class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;
    int n;
    
    public TicTacToe(int n) {
        this.rows = new int[n];
        this.cols = new int[n];
        this.diagonal = 0;
        this.antiDiagonal = 0;
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        int val = player == 1 ? 1 : -1;
        
        rows[row] += val;
        if (Math.abs(rows[row]) == n) {
            return player;
        }
        
        cols[col] += val;
        if (Math.abs(cols[col]) == n) {
            return player;
        }
        
        if (row == col) {
            diagonal += val;
            if (Math.abs(diagonal) == n) {
                return player;
            }
        }
        
        if (row + col == n - 1) {
            antiDiagonal += val;
            if (Math.abs(antiDiagonal) == n) {
                return player;
            }
        }   
        
        return 0;
    }
}
