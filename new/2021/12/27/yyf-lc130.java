class Solution {
    int ROW;
    int COL;
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
          return;
        }
        ROW = board.length;
        COL = board[0].length;
        List<Pair<Integer, Integer>> borders = new LinkedList<Pair<Integer, Integer>>();

        for (int r = 0; r < ROW; ++r) {
          borders.add(new Pair(r, 0));
          borders.add(new Pair(r, COL - 1));
        }
        for (int c = 0; c < COL; ++c) {
          borders.add(new Pair(0, c));
          borders.add(new Pair(ROW - 1, c));
        }
        
        for (Pair<Integer, Integer> pair : borders) {
            int x = (int)(pair.getKey());
            int y = (int)(pair.getValue());
            if (board[x][y] == 'O') {
                dfs(board, pair);
            }
        }
        
        for (int r = 0; r < ROW; ++r) {
          for (int c = 0; c < COL; ++c) {
            if (board[r][c] == 'O')
              board[r][c] = 'X';
            if (board[r][c] == 'E')
              board[r][c] = 'O';
          }
        }
        
    }
    
    public void dfs(char[][] board, Pair pair) {
        int x = (int)(pair.getKey());
        int y = (int)(pair.getValue());
        if (!isValid(x, y) || board[x][y] != 'O') {
            return;
        }
        
        board[x][y] = 'E';
        dfs(board, new Pair(x + 1, y));
        dfs(board, new Pair(x - 1, y));
        dfs(board, new Pair(x, y + 1));
        dfs(board, new Pair(x, y - 1));
    }
    
    public boolean isValid(int i, int j) {
        return i >= 0 && i < ROW && j >= 0 && j < COL;
    }
}
