class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return false;
        }
        
        if (board[0] == null || board[0].length == 0) {
            return false;
        }
        
        Set<String> visited = new HashSet<String>();
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char cur = board[i][j];
                if (cur == '.') {
                    continue;
                }
                
                String rowStr = "row" + i + cur;
                if (visited.contains(rowStr)) {
                    return false;
                }
                visited.add(rowStr);
                
                String columnStr = "column" + j + cur;
                if (visited.contains(columnStr)) {
                    return false;
                }
                visited.add(columnStr);
                int boxNumber = (i / 3 * 3) + j / 3;
                String boxStr = "box" + boxNumber + cur;
                
                if (visited.contains(boxStr)) {
                    return false;
                }
                visited.add(boxStr);
            }
        }

        return true;  
    }
}
