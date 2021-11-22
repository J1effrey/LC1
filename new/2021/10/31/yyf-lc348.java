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
/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */


/*
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
*/
