class Solution {
    private int rows;
    private int cols;
    private int DIR_NUM = 4;
    private int[] xDir = new int[]{1, -1, 0, 0};
    private int[] yDir = new int[]{0, 0, 1, -1};
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        int[][] memo = new int[rows][cols];
        int res = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res = Math.max(res, dfs(i, j, matrix, memo));
            }
        }
        
        return res;
    }
    
    private int dfs(int x, int y, int[][] matrix, int[][] memo) {
        if (memo[x][y] != 0) {
            return memo[x][y];
        }
        
        int res = 1;
        
        for (int i = 0; i < DIR_NUM; i++) {
            int newX = x + xDir[i];
            int newY = y + yDir[i];
            if (newX < 0 || newX >= rows || newY < 0 || newY >= cols || matrix[newX][newY] <= matrix[x][y]) {
                continue;
            }
            res = Math.max(res, 1 + dfs(newX, newY, matrix, memo));
        }
        
        memo[x][y] = res;
        
        return res;
    }
}
